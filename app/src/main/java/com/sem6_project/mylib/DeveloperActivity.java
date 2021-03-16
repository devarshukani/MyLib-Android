package com.sem6_project.mylib;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DeveloperActivity extends AppCompatActivity {

    TextView tv_number_1 , tv_number_2 , tv_number_3 , tv_mail_1 , tv_mail_2 , tv_mail_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Developer");

        ImageView iv_backarrow = findViewById(R.id.iv_backarrow);
        iv_backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tv_number_1 = findViewById(R.id.tv_number_1);
        tv_number_2 = findViewById(R.id.tv_number_2);
        tv_number_3 = findViewById(R.id.tv_number_3);
        tv_mail_1 = findViewById(R.id.tv_mail_1);
        tv_mail_2 = findViewById(R.id.tv_mail_2);
        tv_mail_3 = findViewById(R.id.tv_mail_3);

        tv_number_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7990638761"));
                startActivity(intent);
            }
        });

        tv_number_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7041220538"));
                startActivity(intent);
            }
        });

        tv_number_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9104559910"));
                startActivity(intent);
            }
        });

        tv_mail_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:186620307056@darshan.ac.in"));
                emailIntent.setType("text/plain");
                startActivity(emailIntent);
            }
        });

        tv_mail_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:186620307001@darshan.ac.in"));
                emailIntent.setType("text/plain");
                startActivity(emailIntent);
            }
        });

        tv_mail_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:186620307055@darshan.ac.in"));
                emailIntent.setType("text/plain");
                startActivity(emailIntent);
            }
        });

    }
}