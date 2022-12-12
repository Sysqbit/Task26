package com.example.inventorymanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterSeller extends RecyclerView.Adapter<AdapterSeller.holder> {

    String data[];



    public AdapterSeller(String[] data) {
        this.data = data;

    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_seller,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        String arrNum[]={"03150086621","03325378699","03185589458"};
        holder.tvsellermobile.setText(arrNum[position]);
        holder.tvsellername.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    class holder extends RecyclerView.ViewHolder{
        TextView tvsellername, tvsellermobile;


        public holder(@NonNull View itemView) {
            super(itemView);
            tvsellername=itemView.findViewById(R.id.tvSellerName);
            tvsellermobile=itemView.findViewById(R.id.tvSellerMobile);

        }
    }




}
