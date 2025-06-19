package com.example.vinheria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalheClienteActivity extends AppCompatActivity {

    private TextView nomeCliente, emailCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);

        nomeCliente = findViewById(R.id.textDetalheNome);
        emailCliente = findViewById(R.id.textDetalheEmail);

        String nome = getIntent().getStringExtra("nome");
        String email = getIntent().getStringExtra("email");

        nomeCliente.setText(nome);
        emailCliente.setText(email);

        Button buttonSair = findViewById(R.id.buttonSair);

        buttonSair.setOnClickListener(v -> {
            finish();
        });
    }
}
