package com.sem6_project.mylib.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.sem6_project.mylib.Adapter.CategoryAdapter;
import com.sem6_project.mylib.Adapter.SearchBookAdapter;
import com.sem6_project.mylib.R;
import com.sem6_project.mylib.appcontroller.AppController;
import com.sem6_project.mylib.bean.Book;
import com.sem6_project.mylib.bean.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.sem6_project.mylib.Activity.MainActivity.ip;

public class SearchActivity extends AppCompatActivity {

    RecyclerView rv_CategoryList;
    ArrayList<Book> bookbean;
    ArrayList<Book> tempuserlist;
    EditText et_search;
    Book bookdata;
    SearchBookAdapter adapter;

    private  static String JSON_URL = ip + "mylib/json/book.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Search");

        et_search = (EditText) findViewById(R.id.et_search);
        rv_CategoryList = (RecyclerView) findViewById(R.id.search_rc_book);
        bookbean = new ArrayList<>();
        tempuserlist = new ArrayList<>();

        extractbook();

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                tempuserlist.addAll(bookbean);


                tempuserlist.clear();


                for(int i=0 ; i < bookbean.size(); i++) {

                    if(bookbean.get(i).getBookName().toLowerCase().contains(s.toString().toLowerCase()))
                    {
                        tempuserlist.add(bookbean.get(i));
                    }
                    else if(bookbean.get(i).getAuthorName().toLowerCase().contains(s.toString().toLowerCase()))
                    {
                        tempuserlist.add(bookbean.get(i));
                    }
                    else if(bookbean.get(i).getCategoryName().toLowerCase().contains(s.toString().toLowerCase()))
                    {
                        tempuserlist.add(bookbean.get(i));
                    }

                }
                if(s.toString().length() == 0)
                {
                    tempuserlist.removeAll(bookbean);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void extractbook() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.search_progressBar);
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

                        bookdata = new Book(bookArray.getString("BookID"), bookArray.getString("BookName"), bookArray.getString("AuthorName"), bookArray.getString("PublicationName"), bookArray.getString("CategoryName"), bookArray.getString("BookPages"), bookArray.getString("BookPrice"), bookArray.getString("BookQuantity"), bookArray.getString("PurchaseDate"), bookArray.getString("RackNumber"), bookArray.getString("Remark"));

                        bookbean.add(bookdata);

                    }
                    tempuserlist.addAll(bookbean);
                    adapter = new SearchBookAdapter(tempuserlist, getApplicationContext());
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