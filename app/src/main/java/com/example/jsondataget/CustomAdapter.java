package com.example.jsondataget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter  extends  RecyclerView.Adapter<CustomAdapter.MyViewHolder> {





    ArrayList<String> tList;
    ArrayList<String> nList;
    ArrayList<String> sList;
    ArrayList<String> rList;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> tList, ArrayList<String> rList, ArrayList<String> nList, ArrayList<String> sList) {
        this.context = context;
        this.tList = tList;
        this.nList = nList;
        this.rList = rList;
        this.sList = sList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
       try{
           holder.t.setText(tList.get(position));

       }catch (Exception e) { }

        try{
            holder.r.setText(rList.get(position)); }catch (Exception e) {}

        try{
            holder.n.setText(nList.get(position)); }catch (Exception e) {}


        try{

            holder.s.setText(sList.get(position));

        }catch (Exception e)
        {

        }


        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, tList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {

        if (tList.size()!=0)
        {  return tList.size();

        }else
        {
            return 0;
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t, r, n,s;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            t =  itemView.findViewById(R.id.tListID);
            r = (TextView) itemView.findViewById(R.id.rListID);
            n = (TextView) itemView.findViewById(R.id.nListID);
            s = (TextView) itemView.findViewById(R.id.scListID);

        }
    }






}
