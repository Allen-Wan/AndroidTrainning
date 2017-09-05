package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ex_wanzhipeng001.demo_java.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraActivity extends AppCompatActivity {

    @BindViews({R.id.btn_camera,R.id.select_camera})
    List<Button> buttonList ;
    @BindView(R.id.iv_camera)
    ImageView mImageView;
    private Uri imgUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_camera,R.id.select_camera})
    public void onClick(View v) throws IllegalStateException {
        if (v.getId() == R.id.btn_camera) {
            File file = new File(getExternalCacheDir(),"img.jpg");
            if (file.exists()) {
                boolean delete = file.delete();
                if (!delete) {
                    throw new IllegalStateException("文件删除失败");
                }
            }
            try {
                boolean newFile = file.createNewFile();
                if (!newFile) {
                    throw  new IllegalStateException("创建文件失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (Build.VERSION.SDK_INT >= 24) {
                imgUri = FileProvider.getUriForFile(CameraActivity.this,"com.example.ex_wanzhipeng001.demo_java" +
                        ".fileprovider",file);
            }else {
                imgUri = Uri.fromFile(file);
            }

            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imgUri);
            startActivityForResult(intent,1);
        }else if (v.getId() == R.id.select_camera) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager
                    .PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            }else {
                openAlbum();
            }
        }


    }

    private void openAlbum() {
        Intent intent  = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,2);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imgUri));
                        mImageView.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    if (Build.VERSION.SDK_INT >= 19) {//4.4 os
                        handleImageOnKitKat(data);
                    }else {
                        handleImage(data);
                    }
                }
                break;
            default:
                break;
        }
    }

    private void handleImage(Intent data) {
        Uri uri = data.getData();
        String imgPath = getImgPath(uri,null);
        disPlayImg(imgPath);
    }

    private void disPlayImg(String imgPath) {
        if (!TextUtils.isEmpty(imgPath)) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
            mImageView.setImageBitmap(bitmap);
        }else {
            Toast.makeText(this, "imgpath not exist", Toast.LENGTH_SHORT).show();
        }
    }

    private String getImgPath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this,uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id = documentId.split(":")[1];
                String selction = MediaStore.Images.Media._ID+"="+id;
                imagePath = getImgPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selction);
            }else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri parse = Uri.parse("content://downloads/public_downloads");
                Uri contentUri = ContentUris.withAppendedId(parse,Long.parseLong(documentId));
                imagePath = getImgPath(contentUri,null);
            }else if("content".equalsIgnoreCase(uri.getScheme())){
                imagePath = getImgPath(uri,null);
            }else if("file".equalsIgnoreCase(uri.getScheme())){
                imagePath = uri.getPath();
            }
            disPlayImg(imagePath);
        }
    }
}
