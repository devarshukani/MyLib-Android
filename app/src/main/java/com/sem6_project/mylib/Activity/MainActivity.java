package com.sem6_project.mylib.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {

    public final static String ip = "http://10.20.18.30/";
    Button btn_login;
    EditText et_id, et_pass;
    String json1 = ip + "mylib/json/user.php?id=";
    String json2 = "&pas=";
    static String JSON_URL;
    public static String var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn_login = findViewById(R.id.btn_login);


        et_id = findViewById(R.id.main_id);
        et_pass = findViewById(R.id.main_password);
        //afdjasdf

        System.out.println(var);



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var = et_id.getText().toString();
                JSON_URL = json1 + et_id.getText().toString() + json2 + et_pass.getText().toString() ;

                System.out.println(JSON_URL);

                extractCategory();
            }
        });

    }

    public void extractCategory() {


        JsonArrayRequest req = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject userLoginArray = (JSONObject) response.get(0);

                    if (Integer.parseInt(userLoginArray.getString("value")) == 1){
                        String id = et_id.getText().toString();
                        Intent in = new Intent(getApplicationContext(),DashboardActivity.class);
                        startActivity(in);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                    }


                }catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error Avi", "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        AppController.getInstance().addToRequestQueue(req);

    }
}