package com.example.hp.ideatube;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Filehelper {
    final static String fileName = "yo.txt";
    final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/IdeaTube/" ;
    final static String TAG = Filehelper.class.getName();

    public static boolean saveToFile( String data){
        try {
            new File(path  ).mkdir();
            File file = new File(path+ fileName);
            if (!file.exists()) {
                file.createNewFile();

            }
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write((data + System.getProperty("line.separator")).getBytes());

            return true;
        }
        catch(FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        }
        catch(IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return  false;


    }
}
