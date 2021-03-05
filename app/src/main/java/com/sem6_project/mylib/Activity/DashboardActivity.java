package com.sem6_project.mylib.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sem6_project.mylib.R;

public class DashboardActivity extends AppCompatActivity {

    ImageView iv_account;
    Button btn_search;
    Button btn_categories;
    Button btn_about;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_dashboard);

        iv_account = findViewById(R.id.iv_account);
        btn_search = findViewById(R.id.btn_search);
        btn_categories = findViewById(R.id.btn_categories);
        btn_about = findViewById(R.id.btn_about);

        iv_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MyAccountActivity.class);
                startActivity(in);
            }
        });

        btn_categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), CategoriesActivity.class);
                startActivity(in);
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(in);
            }
        });

        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),AboutLibraryActivity.class);
                startActivity(in);
            }
        });

    }
}