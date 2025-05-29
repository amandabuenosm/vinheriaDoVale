package com.example.vinheria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    LinearLayout layoutCliente, layoutVendedor;
    Button btnCliente, btnVendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        layoutCliente = findViewById(R.id.layoutCliente);
        layoutVendedor = findViewById(R.id.layoutVendedor);
        btnCliente = findViewById(R.id.btnCliente);
        btnVendedor = findViewById(R.id.btnVendedor);

        btnCliente.setOnClickListener(v -> {
            layoutCliente.setVisibility(View.VISIBLE);
            layoutVendedor.setVisibility(View.GONE);
            btnCliente.setBackgroundColor(getResources().getColor(R.color.terracotta_500));
            btnVendedor.setBackgroundColor(getResources().getColor(R.color.terracotta_200));
        });

        btnVendedor.setOnClickListener(v -> {
            layoutCliente.setVisibility(View.GONE);
            layoutVendedor.setVisibility(View.VISIBLE);
            btnCliente.setBackgroundColor(getResources().getColor(R.color.terracotta_200));
            btnVendedor.setBackgroundColor(getResources().getColor(R.color.terracotta_500));
        });
    }
}
