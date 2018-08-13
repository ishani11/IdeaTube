package com.example.hp.ideatube;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public Button btnSave;
    final static String fileName = "yo.txt";
    final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/IdeaTube/";
    final static String TAG = Filehelper.class.getName();
    public static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkAndRequestPermissions()) {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            onResume();
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }


    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    private boolean checkAndRequestPermissions() {

        int permissionSendMessage = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);
        int receiveSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        int readSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (receiveSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECEIVE_SMS);
        }
        if (readSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_SMS);
        }

        if (permissionSendMessage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.SEND_SMS);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;


    }

    public void onClick(View view) {
        btnSave = findViewById(R.id.btnStart);
        //  btnSave.setOnClickListener(new View.OnClickListener());

        //File file = new File(getApplicationContext().getFilesDir(), "hi.txt");
        new File(path  ).mkdir();
        File file = new File(path+ fileName);


        if (file.length()>0) {
            Intent intent = new Intent(MainActivity.this, Choice.class);
            MainActivity.this.startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, ThisBetterWork.class);
            MainActivity.this.startActivity(intent);
        }

        /*if(count==0){
            count++;
            Intent intent = new Intent(MainActivity.this, ThisBetterWork.class);
            MainActivity.this.startActivity(intent);

        }
        else{
            Intent intent = new Intent(MainActivity.this, Choice.class);
            MainActivity.this.startActivity(intent);
        }*/


    }

}