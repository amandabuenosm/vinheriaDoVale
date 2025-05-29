package com.example.vinheria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView tvName, tvPrice;
    private ImageView imgProduct;
    private Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        tvName = findViewById(R.id.tvDetailName);
        tvPrice = findViewById(R.id.tvDetailPrice);
        imgProduct = findViewById(R.id.imgDetailProduct);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        // Recuperar dados enviados da tela anterior
        String name = getIntent().getStringExtra("productName");
        double price = getIntent().getDoubleExtra("productPrice", 0.0);
        String image = getIntent().getStringExtra("productImage");

        tvName.setText(name);
        tvPrice.setText("R$ " + String.format("%.2f", price));
        // imgProduct.setImageResource(R.drawable.sample_wine); // Pode ser substituído por Glide/Picasso

        btnAddToCart.setOnClickListener(v -> {
            // Aqui você pode implementar a lógica de carrinho
            Toast.makeText(this, "Adicionado ao carrinho!", Toast.LENGTH_SHORT).show();
        });
    }
}
