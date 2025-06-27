package com.example.vinheria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    LinearLayout layoutCliente, layoutVendedor;
    Button btnCliente, btnVendedor, btnLoginCliente, btnLoginVendedor;
    EditText inputEmailCliente, inputSenhaCliente, inputEmailVendedor, inputSenhaVendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Elementos comuns
        layoutCliente = findViewById(R.id.layoutCliente);
        layoutVendedor = findViewById(R.id.layoutVendedor);
        btnCliente = findViewById(R.id.btnCliente);
        btnVendedor = findViewById(R.id.btnVendedor);

        // Campos do Cliente
        inputEmailCliente = findViewById(R.id.inputEmailCliente);
        inputSenhaCliente = findViewById(R.id.inputSenhaCliente);
        btnLoginCliente = findViewById(R.id.btnLoginCliente);

        // Campos do Vendedor
        inputEmailVendedor = findViewById(R.id.inputEmailVendedor);
        inputSenhaVendedor = findViewById(R.id.inputSenhaVendedor);
        btnLoginVendedor = findViewById(R.id.btnLoginVendedor);

        // Alternar abas
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

        // Lógica de login do cliente
        btnLoginCliente.setOnClickListener(v -> {
            String email = inputEmailCliente.getText().toString().trim();
            String senha = inputSenhaCliente.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (email.equals("cliente@email.com") && senha.equals("1234")) {
                Toast.makeText(this, "Login do Cliente bem-sucedido!", Toast.LENGTH_SHORT).show();
                // Redireciona para próxima activity
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Credenciais do cliente inválidas", Toast.LENGTH_SHORT).show();
            }
        });

        // Lógica de login do vendedor
        btnLoginVendedor.setOnClickListener(v -> {
            String email = inputEmailVendedor.getText().toString().trim();
            String senha = inputSenhaVendedor.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (email.equals("vendedor@email.com") && senha.equals("admin")) {
                Toast.makeText(this, "Login do Vendedor bem-sucedido!", Toast.LENGTH_SHORT).show();
                // Redireciona para próxima activity
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Credenciais do vendedor inválidas", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
