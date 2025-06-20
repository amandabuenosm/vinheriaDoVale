package com.example.vinheria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalheClienteActivity extends AppCompatActivity {

    private TextView nomeCliente, cpfCliente, telefoneCliente, emailCliente,
            enderecoCliente, cidadeCliente, estadoCliente, cepCliente, observacoesCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);

        nomeCliente = findViewById(R.id.textDetalheNome);
        cpfCliente = findViewById(R.id.textDetalheCpf);
        telefoneCliente = findViewById(R.id.textDetalheTelefone);
        emailCliente = findViewById(R.id.textDetalheEmail);
        enderecoCliente = findViewById(R.id.textDetalheEndereco);
        cidadeCliente = findViewById(R.id.textDetalheCidade);
        estadoCliente = findViewById(R.id.textDetalheEstado);
        cepCliente = findViewById(R.id.textDetalheCep);
        observacoesCliente = findViewById(R.id.textDetalheObservacoes);

        // Recebe os dados via Intent
        nomeCliente.setText(getIntent().getStringExtra("nome"));
        cpfCliente.setText(getIntent().getStringExtra("cpf_cnpj"));
        telefoneCliente.setText(getIntent().getStringExtra("telefone"));
        emailCliente.setText(getIntent().getStringExtra("email"));
        enderecoCliente.setText(getIntent().getStringExtra("endereco"));
        cidadeCliente.setText(getIntent().getStringExtra("cidade"));
        estadoCliente.setText(getIntent().getStringExtra("estado"));
        cepCliente.setText(getIntent().getStringExtra("cep"));
        observacoesCliente.setText(getIntent().getStringExtra("observacoes"));

        Button buttonSair = findViewById(R.id.buttonSair);
        buttonSair.setOnClickListener(v -> finish());
    }
}
