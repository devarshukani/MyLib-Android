package com.sem6_project.mylib.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sem6_project.mylib.Activity.CategoryBookActivity;
import com.sem6_project.mylib.R;
import com.sem6_project.mylib.bean.Book;
import com.sem6_project.mylib.bean.Category;

import java.util.ArrayList;

public class CategoryBookDetailAdapter extends RecyclerView.Adapter<CategoryBookDetailAdapter.ViewHolder> {

    public String categoryid;
    private ArrayList<Book> listdata;

    public CategoryBookDetailAdapter(ArrayList<Book> listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public CategoryBookDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listitem = layoutInflater.inflate(R.layout.activity_category_book, parent, false);
        CategoryBookDetailAdapter.ViewHolder viewHolder = new CategoryBookDetailAdapter.ViewHolder(listitem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_book_name.setText(listdata.get(position).getBookName());
        holder.tv_book_category.setText(listdata.get(position).getCategoryName());
        holder.tv_book_author.setText(listdata.get(position).getAuthorName());
        holder.tv_book_publication.setText(listdata.get(position).getPublicationName());
        holder.tv_book_pages.setText(listdata.get(position).getBookPages());
        holder.tv_book_quantity.setText(listdata.get(position).getBookQuantity());
        holder.tv_book_racknumber.setText(listdata.get(position).getRackNumber());


    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_book_name, tv_book_category, tv_book_author, tv_book_publication, tv_book_pages, tv_book_quantity, tv_book_racknumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_book_name = (TextView) itemView.findViewById(R.id.tv_book_name);
            this.tv_book_category = (TextView) itemView.findViewById(R.id.tv_book_category);
            this.tv_book_author = (TextView) itemView.findViewById(R.id.tv_book_author);
            this.tv_book_publication = (TextView) itemView.findViewById(R.id.tv_book_publication);
            this.tv_book_pages = (TextView) itemView.findViewById(R.id.tv_book_pages);
            this.tv_book_quantity = (TextView) itemView.findViewById(R.id.tv_book_quantity);
            this.tv_book_racknumber = (TextView) itemView.findViewById(R.id.tv_book_racknumber);
        }
    }
}
