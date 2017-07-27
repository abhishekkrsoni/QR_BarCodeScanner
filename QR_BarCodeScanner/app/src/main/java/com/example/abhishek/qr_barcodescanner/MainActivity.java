package com.example.abhishek.qr_barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button scan,generate;
    ImageView qrcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.result);
        editText=(EditText)findViewById(R.id.text);
        scan=(Button)findViewById(R.id.button);
        generate=(Button)findViewById(R.id.button2);
        qrcode=(ImageView)findViewById(R.id.imageView);
        Intent i=getIntent();
        textView.setText(i.getStringExtra("data"));
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Camera.class);
                startActivity(intent);
            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://chart.googleapis.com/chart?chs=250x250&cht=qr&chl="+generate.getText().toString();
                Glide.with(getApplicationContext()).load(url).placeholder(R.drawable.loading_img).error(R.drawable.error_icon).into(qrcode);
            }
        });
    }
}
