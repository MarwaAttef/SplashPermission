package com.example.marwa.splashtest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splash extends AppCompatActivity{

    private static int  SPLASH_TIME_OUT = 3000 ;
    private static final int MY_PERMISSIONS_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        requestPermissions();
    }

    private void displaySplashScreen() {
        new Handler().postDelayed(new Runnable() {

        /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         */

            @Override
            public void run() {
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


    private boolean requestPermissions() {

        int permissionCAMERA = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int permissionLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionCALL_PHONE = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        int permissionRECORD_AUDIO = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        int permissionREAD_EXTERNAL_STORAGE = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permissionWRITE_EXTERNAL_STORAGE = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);


        List<String> listPermissionsNeeded = new ArrayList<>();

        if (permissionCAMERA != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.CAMERA);

        if (permissionLocation != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCALL_PHONE != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.CALL_PHONE);

        if (permissionREAD_EXTERNAL_STORAGE != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permissionWRITE_EXTERNAL_STORAGE != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionRECORD_AUDIO != PackageManager.PERMISSION_GRANTED)
            listPermissionsNeeded.add(Manifest.permission.RECORD_AUDIO);

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), MY_PERMISSIONS_REQUEST);

//
            return false;
        }


        return true;
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        Map<String, Integer> perms = new HashMap<String, Integer>();


        for (int i = 0; i < permissions.length; i++) {
            perms.put(permissions[i], grantResults[i]);
        }

     int count =0;

                // If request is cancelled, the result arrays are empty.

        if(perms.get(Manifest.permission.CAMERA)!=null){
        if (perms.get(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    count++;
                } else {
                    count++;
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }}
//--------------------------------------------------------------------------------------------------//
if(perms.get(Manifest.permission.ACCESS_FINE_LOCATION)!=null) {
    if (perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

        count++;
        // permission was granted, yay! Do the
        // contacts-related task you need to do.

    } else {
        count++;
        // permission denied, boo! Disable the
        // functionality that depends on this permission.
    }
}
                //--------------------------------------------------------------------------------------------------//
        if(perms.get(Manifest.permission.CALL_PHONE)!=null){
        if (perms.get(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){

                    count++;
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    count++;
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }}
                //--------------------------------------------------------------------------------------------------//
        if(perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE)!=null){
        if (perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    count++;
                } else {
                    count++;
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }}
                //--------------------------------------------------------------------------------------------------//
        if(perms.get(Manifest.permission.READ_EXTERNAL_STORAGE)!=null){
        if (perms.get(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){


                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    count++;
                } else {
                    count++;
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }}

//--------------------------------------------------------------------------------------------------//
        if(perms.get(Manifest.permission.RECORD_AUDIO)!=null) {
            if (perms.get(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {

                count++;
                // permission was granted, yay! Do the
                // contacts-related task you need to do.

            } else {
                count++;
                // permission denied, boo! Disable the
                // functionality that depends on this permission.
            }
        }
                if(count==permissions.length){
                    displaySplashScreen();
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }




