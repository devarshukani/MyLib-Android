package com.sem6_project.mylib.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.sem6_project.mylib.Adapter.CategoryAdapter;
import com.sem6_project.mylib.R;
import com.sem6_project.mylib.appcontroller.AppController;
import com.sem6_project.mylib.bean.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.sem6_project.mylib.Activity.MainActivity.ip;

public class CategoriesActivity extends AppCompatActivity {

    RecyclerView rv_CategoryList;
    ArrayList<Category> cat;

    static String JSON_URL = ip + "mylib/json/category.php";

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Categories");


        rv_CategoryList = (RecyclerView) findViewById(R.id.rv_CategoryList);
        cat = new ArrayList<>();

        extractCategory();


    }

    public void extractCategory() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest req = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
//                Log.d(TAG, response.toString());
                progressBar.setVisibility(View.INVISIBLE);
                try {
                    // Parsing json array response
                    // loop through each json object
                    for (int i = 0; i < response.length(); i++) {

                        JSONObject categoryArray = (JSONObject) response.get(i);

                        Category categorydata = new Category(categoryArray.getString("CategoryID"), categoryArray.getString("CategoryName"), categoryArray.getString("Remark"));

                        cat.add(categorydata);
                    }
                    CategoryAdapter adapter = new CategoryAdapter(cat, getApplicationContext());
                    rv_CategoryList.setHasFixedSize(true);
                    rv_CategoryList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv_CategoryList.setAdapter(adapter);
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