package com.example.vinheria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ManutencaoPedidosActivity extends AppCompatActivity {

    private Button btnPedidosCadastrados, btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manutencaopedidos);

        btnPedidosCadastrados = findViewById(R.id.pedidosCadastrados);

        btnPedidosCadastrados.setOnClickListener(v -> {
            Intent intent = new Intent(ManutencaoPedidosActivity.this, PedidosCadastradosActivity.class);
            startActivity(intent);
        });

        btnNovoPedido = findViewById(R.id.novoPedido);

        btnNovoPedido.setOnClickListener(v -> {
            Intent intent = new Intent(ManutencaoPedidosActivity.this, NovoPedidoActivity.class);
            startActivity(intent);
        });

        Button buttonSair = findViewById(R.id.buttonSair);

        buttonSair.setOnClickListener(v -> {
            finish();
        });
    }
}
