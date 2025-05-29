package com.example.vinheria;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinheria.adapters.ProductAdapter;
import com.example.vinheria.models.Product;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvProducts;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvProducts = findViewById(R.id.rvProducts);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();
        loadSampleProducts();

        ProductAdapter adapter = new ProductAdapter(this, productList);
        rvProducts.setAdapter(adapter);
    }

    private void loadSampleProducts() {
        productList.add(new Product("Vinho Tinto Reserva", "sample_wine", 89.90));
        productList.add(new Product("Vinho Branco Suave", "sample_wine", 74.50));
        productList.add(new Product("Espumante Brut", "sample_wine", 102.30));
        // Adicione mais conforme necessário
    }
}
