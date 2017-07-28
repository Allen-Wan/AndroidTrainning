package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ex_wanzhipeng001.demo_java.R;

public class UIComponentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicomponents);

        testProgressDialog();
        testAlertDialog();
        textPercentLayout();
    }

    private void textPercentLayout() {
        findViewById(R.id.btn_percentLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UIComponentsActivity.this, PercentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void testAlertDialog() {
        findViewById(R.id.btn_alertDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UIComponentsActivity.this);
                builder.setTitle("title");
                builder.setMessage("msg");
                builder.setPositiveButton("pos", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UIComponentsActivity.this, "pos", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("neg", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UIComponentsActivity.this, "neg", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();

            }
        });
    }

    private void testProgressDialog() {
        findViewById(R.id.btn_pbDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog = new ProgressDialog(UIComponentsActivity.this);
                dialog.setTitle("title");
                dialog.setMessage("msg");
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.show();
            }
        });
    }
}
