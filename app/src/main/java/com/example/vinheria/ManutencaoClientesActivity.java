package com.example.vinheria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ManutencaoClientesActivity extends AppCompatActivity {

    private Button btnClientesCadastrados, btnNovoCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manutencaoclientes);

        btnClientesCadastrados = findViewById(R.id.clientesCadastrados);

        btnClientesCadastrados.setOnClickListener(v -> {
            Intent intent = new Intent(ManutencaoClientesActivity.this, ClientesCadastradosActivity.class);
            startActivity(intent);
        });

        btnNovoCliente = findViewById(R.id.novoCliente);

        btnNovoCliente.setOnClickListener(v -> {
            Intent intent = new Intent(ManutencaoClientesActivity.this, NovoClienteActivity.class);
            startActivity(intent);
        });

        Button buttonSair = findViewById(R.id.buttonSair);

        buttonSair.setOnClickListener(v -> {
            finish();
        });
    }
}
