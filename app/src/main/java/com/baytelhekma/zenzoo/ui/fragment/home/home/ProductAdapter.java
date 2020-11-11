package com.baytelhekma.zenzoo.ui.fragment.home.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baytelhekma.zenzoo.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.Holder> {

    ArrayList arrayList=new ArrayList();
    Context context;


    public void setData(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,
                parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(context).load(R.drawable.product_1).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_product);
        }
    }
}
