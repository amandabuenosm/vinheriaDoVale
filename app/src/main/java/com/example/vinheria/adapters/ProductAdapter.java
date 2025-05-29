package com.example.vinheria.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vinheria.R;
import com.example.vinheria.models.Product;
import com.example.vinheria.ProductDetailActivity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private final Context context;
    private final List<Product> productList;

    public ProductAdapter(Context ctx, List<Product> products) {
        this.context = ctx;
        this.productList = products;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        Product p = productList.get(position);
        holder.name.setText(p.getName());
        holder.price.setText("R$ " + String.format("%.2f", p.getPrice()));
        // Para usar imagens reais, use Picasso, Glide ou Coil
        // holder.image.setImageResource(R.drawable.sample_wine); // placeholder
        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, ProductDetailActivity.class);
            i.putExtra("productName", p.getName());
            i.putExtra("productPrice", p.getPrice());
            i.putExtra("productImage", p.getImageUrl());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvProductName);
            price = itemView.findViewById(R.id.tvProductPrice);
            image = itemView.findViewById(R.id.imgProduct);
        }
    }
}
