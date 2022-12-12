package com.example.inventorymanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.holder> {

    String dataa[];



    public AdapterProduct(String[] dataa) {
        this.dataa = dataa;

    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shimmer_product,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        String arrNum[]={"mobile","mobile","mobile"};
        holder.tvProductCategory.setText(arrNum[position]);
        holder.tvProductName.setText(dataa[position]);
    }

    @Override
    public int getItemCount() {
        return dataa.length;
    }


    class holder extends RecyclerView.ViewHolder{
        private TextView tvProductName,tvProductLocation, tvProductCategory, tvProductSize, tvProductQuantity, tvProductBrand, tvProductPrice, tvProductManufacture, tvProductExpire, tvCount;
        private CardView cvProduct;


        public holder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductLocation = itemView.findViewById(R.id.tvProductLocation);
            tvProductSize = itemView.findViewById(R.id.tvProductSize);
            tvProductQuantity = itemView.findViewById(R.id.tvProductQuantity);
            tvProductBrand = itemView.findViewById(R.id.tvProductBrand);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            tvProductExpire = itemView.findViewById(R.id.tvProductExpire);
            tvProductManufacture = itemView.findViewById(R.id.tvProductManufacture);
            tvProductCategory = itemView.findViewById(R.id.tvProductCategory);
            cvProduct = itemView.findViewById(R.id.cvProduct);
            tvCount = itemView.findViewById(R.id.tvCount);

        }
    }




}
