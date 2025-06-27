package com.example.vinheria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class NovoPedidoActivity extends AppCompatActivity {

    private Button buttonSairPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novopedido);

        buttonSairPedido = findViewById(R.id.buttonSairPedido);

        // Clique no botão de sair
        buttonSairPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
