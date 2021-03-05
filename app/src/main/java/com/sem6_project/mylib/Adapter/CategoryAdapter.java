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
import com.sem6_project.mylib.Activity.MyAccountActivity;
import com.sem6_project.mylib.R;
import com.sem6_project.mylib.bean.Category;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    public String categoryid;
    private ArrayList<Category> listdata;
    Context context;

    public CategoryAdapter(ArrayList<Category> listdata, Context context){
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listitem = layoutInflater.inflate(R.layout.view_row_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(listitem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Category myListData = listdata.get(position);
        holder.tv_CategoryID.setText(listdata.get(position).getCategoryID());
        holder.tv_CategoryName.setText(listdata.get(position).getCategory_Name());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                categoryid = listdata.get(position).getCategoryID();
                Intent in = new Intent(context.getApplicationContext(), CategoryBookActivity.class);
                in.putExtra("categoryid",categoryid);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);

//                Toast.makeText(v.getContext(),"Click on item:"+ myListData.getCategoryID(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_CategoryName, tv_CategoryID;
        public LinearLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_CategoryID = (TextView) itemView.findViewById(R.id.tv_CategoryID);
            this.tv_CategoryName = (TextView) itemView.findViewById(R.id.tv_CategoryName);
            relativeLayout = (LinearLayout) itemView.findViewById(R.id.linear);
        }
    }
}
