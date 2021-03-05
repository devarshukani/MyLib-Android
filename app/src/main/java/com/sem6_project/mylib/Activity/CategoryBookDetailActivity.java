package com.sem6_project.mylib.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class CategoryBookDetailActivity extends AppCompatActivity {

    TextView tv_book_name, tv_book_category, tv_book_author, tv_book_publication, tv_book_pages, tv_book_quantity, tv_book_racknumber;
    ArrayList<Book> bookbean;
    String id = "";

    String json = ip + "mylib/json/final_book.php?id=";
    static String JSON_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_book_detail);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Book");

        initialize();

        id = getIntent().getStringExtra("bookid");

        JSON_URL = json + id;

        bookbean = new ArrayList<>();

        extractbook();

    }

    public void initialize() {
        tv_book_name = (TextView) findViewById(R.id.tv_book_name);
        tv_book_category = (TextView) findViewById(R.id.tv_book_category);
        tv_book_author = (TextView) findViewById(R.id.tv_book_author);
        tv_book_publication = (TextView) findViewById(R.id.tv_book_publication);
        tv_book_pages = (TextView) findViewById(R.id.tv_book_pages);
        tv_book_quantity = (TextView) findViewById(R.id.tv_book_quantity);
        tv_book_racknumber = (TextView) findViewById(R.id.tv_book_racknumber);
    }

    public void extractbook() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_book);
        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest req = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
//                Log.d(TAG, response.toString());
                progressBar.setVisibility(View.INVISIBLE);
                try {
                    JSONObject bookArray = (JSONObject) response.get(0);
                    tv_book_name.setText(bookArray.getString("BookName"));
                    tv_book_author.setText(bookArray.getString("AuthorName"));
                    tv_book_category.setText(bookArray.getString("CategoryName"));
                    tv_book_pages.setText(bookArray.getString("BookPages"));
                    tv_book_publication.setText(bookArray.getString("PublicationName"));
                    tv_book_quantity.setText(bookArray.getString("BookQuantity"));
                    tv_book_racknumber.setText(bookArray.getString("RackNumber"));

                } catch (JSONException e) {
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

