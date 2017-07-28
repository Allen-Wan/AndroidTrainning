package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.ex_wanzhipeng001.demo_java.R;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MediaActivity extends AppCompatActivity {

    @BindView(R.id.btn_playAudio)
    Button mBtnPlayAudio;
    @BindView(R.id.btn_pauseAudio)
    Button mBtnPauseAudio;
    @BindView(R.id.btn_stopAudio)
    Button mBtnStopAudio;
    @BindView(R.id.btn_playVideo)
    Button mBtnPlayVideo;
    @BindView(R.id.btn_pauseVideo)
    Button mBtnPauseVideo;
    @BindView(R.id.btn_replayVideo)
    Button mBtnReplayVideo;
    @BindView(R.id.videoView)
    VideoView mVideoView;
    private  MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        ButterKnife.bind(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager
                .PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else {
            initAudioPlayer();
            initMeidaPlayer();
        }
    }

    private void initMeidaPlayer() {
        File file = new File(getExternalCacheDir(),"video.mp4");
        mVideoView.setVideoPath(file.getPath());
    }

    private void initAudioPlayer() {
        try {
            File file = new File(getExternalCacheDir(),"bgm.mp3");
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initAudioPlayer();
                    initMeidaPlayer();
                }else {
                    Toast.makeText(this, "denied permission", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.btn_playAudio,R.id.btn_pauseAudio,R.id.btn_stopAudio,R.id.btn_playVideo,R.id
            .btn_pauseVideo,R.id.btn_replayVideo})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_playAudio:
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
                break;
            case R.id.btn_pauseAudio:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                break;
            case R.id.btn_stopAudio:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                    initAudioPlayer();
                }
                break;
            case R.id.btn_playVideo:
                if (!mVideoView.isPlaying()) {
                    mVideoView.start();
                }
                break;
            case R.id.btn_pauseVideo:
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                }
                break;
            case R.id.btn_replayVideo:
                if (mVideoView.isPlaying()) {
                    mVideoView.resume();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();;
            mediaPlayer.release();
        }
        if (mVideoView != null) {
            mVideoView.suspend();
        }
    }
}
