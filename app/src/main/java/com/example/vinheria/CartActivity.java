package com.example.vinheria;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vinheria.models.Product;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ListView listCart;
    private TextView totalCart;
    private Button btnCheckout;

    private ArrayList<Product> cartItems;
    private ArrayAdapter<String> adapter;
    private float total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        listCart = findViewById(R.id.listCart);
        totalCart = findViewById(R.id.totalCart);
        btnCheckout = findViewById(R.id.btnCheckout);

        cartItems = CartSingleton.getInstance().getItems();

        ArrayList<String> names = new ArrayList<>();
        for (Product p : cartItems) {
            names.add(p.getName() + " - R$ " + String.format("%.2f", p.getPrice()));
            total += p.getPrice();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listCart.setAdapter(adapter);

        totalCart.setText("Total: R$ " + String.format("%.2f", total));

        btnCheckout.setOnClickListener(v -> {
            Toast.makeText(this, "Order placed successfully!", Toast.LENGTH_SHORT).show();
            CartSingleton.getInstance().clearCart();
            finish();
        });
    }
}
