package com.sem6_project.mylib.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.sem6_project.mylib.R;
import com.sem6_project.mylib.appcontroller.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.sem6_project.mylib.Activity.MainActivity.ip;
import static com.sem6_project.mylib.Activity.MainActivity.var;

public class MyAccountActivity extends AppCompatActivity {

    Button btn_logout;
    TextView tv_username, tv_image_character, tv_address, tv_contact, tv_dues, tv_issuedbooks;
    String JSON_URL = ip + "mylib/json/user_detail.php?id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("My Account");

        JSON_URL = JSON_URL + "\"" + var + "\"";

        initialize();

        accountInfo();

        tv_username.setText(var);

        image_character_get();

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }

    void image_character_get() {
        String s;
        s = (String) tv_username.getText();
        s = String.valueOf(s.charAt(0)).toUpperCase();
        tv_image_character.setText(s);
    }

    void initialize(){
        btn_logout = findViewById(R.id.btn_logout);
        tv_image_character = findViewById(R.id.tv_image_character);
        tv_username = findViewById(R.id.tv_username);
        tv_address = findViewById(R.id.tv_address);
        tv_contact = findViewById(R.id.tv_contact);
        tv_dues = findViewById(R.id.tv_dues);
        tv_issuedbooks = findViewById(R.id.tv_issuedbooks);
    }

    public void accountInfo() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_myaccount);
        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest req = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
//                Log.d(TAG, response.toString());
                progressBar.setVisibility(View.INVISIBLE);
                try {
                    JSONObject bookArray = (JSONObject) response.get(0);
                    tv_contact.setText(bookArray.getString("UserContactNumber"));
                    tv_address.setText(bookArray.getString("UserAddress"));
                    tv_issuedbooks.setText(bookArray.getString("NumberOfIssuedBooks"));
                    tv_dues.setText(bookArray.getString("PendingDues"));

                }catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error Avi", "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        AppController.getInstance().addToRequestQueue(req);


    }
}