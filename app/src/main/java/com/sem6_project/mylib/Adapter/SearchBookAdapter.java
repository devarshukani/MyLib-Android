package com.sem6_project.mylib.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sem6_project.mylib.Activity.CategoryBookActivity;
import com.sem6_project.mylib.Activity.CategoryBookDetailActivity;
import com.sem6_project.mylib.R;
import com.sem6_project.mylib.bean.Book;
import com.sem6_project.mylib.bean.Category;

import java.util.ArrayList;

public class SearchBookAdapter extends RecyclerView.Adapter<SearchBookAdapter.ViewHolder> {

    private ArrayList<Book> listdata;
    public String bookid;
    Context context;
    // banne search and category book ma kaam laagse

    public SearchBookAdapter(ArrayList<Book> listdata, Context context){
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listitem = layoutInflater.inflate(R.layout.view_row_search_book, parent, false);
        SearchBookAdapter.ViewHolder viewHolder = new SearchBookAdapter.ViewHolder(listitem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Book myListData = listdata.get(position);
        holder.tv_search_bookid.setText(listdata.get(position).getBookID());
        holder.tv_search_bookname.setText(listdata.get(position).getBookName());
        holder.tv_search_authorname.setText(listdata.get(position).getAuthorName());
        holder.tv_search_categoryname.setText(listdata.get(position).getCategoryName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"Click on item:"+ myListData.getBookID(), Toast.LENGTH_LONG).show();
                bookid = listdata.get(position).getBookID();
                Intent in = new Intent(context.getApplicationContext(), CategoryBookDetailActivity.class);
                in.putExtra("bookid",bookid);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_search_bookname, tv_search_categoryname, tv_search_authorname, tv_search_bookid;
        public LinearLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_search_bookid = (TextView) itemView.findViewById(R.id.tv_search_bookid);
            this.tv_search_bookname = (TextView) itemView.findViewById(R.id.tv_search_bookname);
            this.tv_search_authorname = (TextView) itemView.findViewById(R.id.tv_search_authorname);
            this.tv_search_categoryname = (TextView) itemView.findViewById(R.id.tv_search_categoryname);
            this.relativeLayout = (LinearLayout) itemView.findViewById(R.id.search_book_linear);
        }
    }
}
