package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void biodata(View view) {
        startActivity(new Intent(MainActivity.this, BiodataActivity.class));
    }

    public void moveMaps(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-5.0790837,120.2697669")).setPackage("com.google.android.apps.maps"));
    }

    public void moveSms(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "082394989406")).putExtra("sms_body", "Assalamu Alaikum"));
    }

    public void exit(View view) {
        logout(this);
    }

    public static void logout(Activity activity){
        AlertDialog.Builder builder= new AlertDialog.Builder(activity);
        builder.setTitle("Keluar");
        builder.setMessage("Lanjutkan Keluar?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });

        builder.setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}