package com.example.cw7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
  ImageView imageView;
  TextView namee;
  TextView totall;
  TextView defe;
  TextView atactt;
  String name;
    String total;
    String def;
    String atact;
  int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.image);
        namee = findViewById(R.id.name);
        totall = findViewById(R.id.role);
        defe = findViewById(R.id.textView);
        atactt=findViewById(R.id.textView1);
        name = getIntent().getStringExtra("name");
        total = getIntent().getStringExtra("total");
        image = getIntent().getIntExtra("image",0);
        def = getIntent().getStringExtra("def");
        atact = getIntent().getStringExtra("atact");
        defe.setText("defence:"+def);
        namee.setText(name);
        totall.setText("Total:"+total);
        atactt.setText("attack:"+atact);
        imageView.setImageResource(image);
    }
}