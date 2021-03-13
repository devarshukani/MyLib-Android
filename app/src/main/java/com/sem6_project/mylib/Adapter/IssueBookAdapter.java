package com.sem6_project.mylib.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sem6_project.mylib.R;
import com.sem6_project.mylib.bean.Category;
import com.sem6_project.mylib.bean.IssueBook;

import java.util.ArrayList;

public class IssueBookAdapter extends RecyclerView.Adapter<IssueBookAdapter.ViewHolder>{

    private ArrayList<IssueBook> listdata;
    Context context;

    public IssueBookAdapter(ArrayList<IssueBook> listdata, Context context){
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listitem = layoutInflater.inflate(R.layout.view_issued_book, parent, false);
        IssueBookAdapter.ViewHolder viewHolder = new IssueBookAdapter.ViewHolder(listitem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_issued_bookname.setText(listdata.get(position).getBookName());
        holder.tv_issued_date.setText(listdata.get(position).getIssueBookDate());
        holder.tv_due_date.setText(listdata.get(position).getDueDate());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_issued_bookname, tv_issued_date, tv_due_date;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_due_date = v.findViewById(R.id.tv_due_date);
            tv_issued_bookname = v.findViewById(R.id.tv_issued_bookname);
            tv_issued_date = v.findViewById(R.id.tv_issued_date);
        }
    }
}
