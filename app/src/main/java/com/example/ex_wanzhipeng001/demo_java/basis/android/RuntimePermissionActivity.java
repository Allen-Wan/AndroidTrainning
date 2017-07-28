package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;
import com.zhy.m.permission.ShowRequestPermissionRationale;

public class RuntimePermissionActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SDCARD = 2;
    private static final int REQUEST_CODE_CALL_PHONE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permission);

        findViewById(R.id.btn_callPhone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(RuntimePermissionActivity.this, Manifest.permission
                        .CALL_PHONE) != PackageManager
                        .PERMISSION_GRANTED) {//strange!!!  360 ROM doesn't goes here
                    Log.d("RuntimePermissionActivi", "1");
                    ActivityCompat.requestPermissions(RuntimePermissionActivity.this, new String[]{Manifest.permission
                            .CALL_PHONE}, 1);
                }else {
                    Log.d("RuntimePermissionActivi", "2");
                    call();
                }


                //MPermission lib
//                if (!MPermissions.shouldShowRequestPermissionRationale(RuntimePermissionActivity.this, Manifest.permission
//                        .WRITE_EXTERNAL_STORAGE, REQUEST_CODE_SDCARD))
//                {

//                    MPermissions.requestPermissions(RuntimePermissionActivity.this, REQUEST_CODE_SDCARD, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//               }
//            if (!MPermissions.shouldShowRequestPermissionRationale(RuntimePermissionActivity.this, Manifest
//                    .permission
//                        .CALL_PHONE, REQUEST_CODE_CALL_PHONE)){
//                    MPermissions.requestPermissions(RuntimePermissionActivity.this, REQUEST_CODE_CALL_PHONE, Manifest.permission.CALL_PHONE);
//                }
            }
        }
        );
    }

    private void call() {
        try {
            Log.d("RuntimePermissionActivi", "3");
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10010"));
            startActivity(intent);
        } catch (SecurityException e) {
            Log.d("RuntimePermissionActivi", "4");
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("RuntimePermissionActivi", "5");
                    call();
                }else {
                    Log.d("RuntimePermissionActivi", "6");
                    Toast.makeText(this, "权限被你拒绝", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
        }
    }


    @ShowRequestPermissionRationale(REQUEST_CODE_SDCARD)
    public void whyNeedSdCard()
    {
        Log.d("RuntimePermissionActivi", "whyNeedSdCard");
        Toast.makeText(this, "I need write news to sdcard!", Toast.LENGTH_SHORT).show();
        MPermissions.requestPermissions(RuntimePermissionActivity.this, REQUEST_CODE_SDCARD, Manifest.permission.WRITE_EXTERNAL_STORAGE);

    }

    @ShowRequestPermissionRationale(REQUEST_CODE_CALL_PHONE)
    public void whyNeedCallPhone()
    {
        Log.d("RuntimePermissionActivi", "whyNeedCallPhone");
        Toast.makeText(this, "I need  to CallPhone!", Toast.LENGTH_SHORT).show();
        MPermissions.requestPermissions(RuntimePermissionActivity.this, REQUEST_CODE_CALL_PHONE, Manifest.permission
                .CALL_PHONE);

    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
//    {
//        Log.d("RuntimePermissionActivi", "onRequestPermissionsResult");
//        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }


    @PermissionGrant(REQUEST_CODE_SDCARD)
    public void requestSdcardSuccess()
    {
        Log.d("RuntimePermissionActivi", "requestSdcardSuccess");
        Toast.makeText(this, "GRANT ACCESS SDCARD!", Toast.LENGTH_SHORT).show();
    }

    @PermissionDenied(REQUEST_CODE_SDCARD)
    public void requestSdcardFailed()
    {
        Log.d("RuntimePermissionActivi", "requestSdcardFailed");
        Toast.makeText(this, "DENY ACCESS SDCARD!", Toast.LENGTH_SHORT).show();
    }


    @PermissionGrant(REQUEST_CODE_CALL_PHONE)
    public void requestCallPhoneSuccess()
    {
        Log.d("RuntimePermissionActivi", "requestCallPhoneSuccess");
        Uri telUri = Uri.parse("tel:" + "15817471800");
        Intent intent = new Intent(Intent.ACTION_CALL, telUri);
        startActivity(intent);
//        Toast.makeText(this, "GRANT ACCESS requestCallPhoneSuccess!", Toast.LENGTH_SHORT).show();
    }

    @PermissionDenied(REQUEST_CODE_CALL_PHONE)
    public void requestCallPhoneFailed()
    {
        Log.d("RuntimePermissionActivi", "requestCallPhoneFailed");
        Toast.makeText(this, "DENY ACCESS requestCallPhoneFailed!", Toast.LENGTH_SHORT).show();
    }
}
