package com.sem6_project.mylib.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.sem6_project.mylib.Adapter.SearchBookAdapter;
import com.sem6_project.mylib.R;
import com.sem6_project.mylib.appcontroller.AppController;
import com.sem6_project.mylib.bean.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.sem6_project.mylib.Activity.MainActivity.ip;

public class CategoryBookActivity extends AppCompatActivity {

    RecyclerView rv_CategoryList;
    ArrayList<Book> bookbean;
    String id ="";

    String json = ip + "mylib/json/search_book.php?id=";
    static String JSON_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_book);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Books");

        id = getIntent().getStringExtra("categoryid");

        JSON_URL = json + id;

        rv_CategoryList = (RecyclerView) findViewById(R.id.rv_categorybooklist);
        bookbean = new ArrayList<>();

        extractbook();

    }
    public void extractbook() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_categorybook);
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

                        JSONObject bookArray = (JSONObject) response.get(i);

                        Book bookdata = new Book(bookArray.getString("BookID"), bookArray.getString("BookName"), bookArray.getString("AuthorName"), bookArray.getString("PublicationName"), bookArray.getString("CategoryName"), bookArray.getString("BookPages"), bookArray.getString("BookPrice"), bookArray.getString("BookQuantity"), bookArray.getString("PurchaseDate"), bookArray.getString("RackNumber"), bookArray.getString("Remark"));

                        bookbean.add(bookdata);
                    }
                    SearchBookAdapter adapter = new SearchBookAdapter(bookbean, getApplicationContext());
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
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        AppController.getInstance().addToRequestQueue(req);


    }
}