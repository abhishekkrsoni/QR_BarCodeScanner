package com.example.abhishek.qr_barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Camera extends AppCompatActivity {

    ZXingScannerView scanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        scanner = new ZXingScannerView(Camera.this);
        setContentView(scanner);
        scanner.startCamera();
        scanner.setResultHandler(new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(Result result) {
                //Toast.makeText(getApplicationContext(),""+result.getText(),Toast.LENGTH_SHORT).show();
                scanner.stopCamera();
                Intent i = new Intent(Camera.this,MainActivity.class);
                String temp = result.getText().toString();
                Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_SHORT).show();
                i.putExtra("data",temp);
                startActivity(i);
                finishAffinity();
            }
        });
    }
}
