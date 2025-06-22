package com.example.vinheria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinheria.dao.ClientDAO;

public class DetalheClienteActivity extends AppCompatActivity {

    private TextView nomeCliente, cpfCliente, telefoneCliente, emailCliente, enderecoCliente, cidadeCliente, estadoCliente, cepCliente, observacoesCliente;

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

        Button buttonDeletar = findViewById(R.id.buttonDeletar);

        // Pegando o id vindo da intent
        int clienteId = getIntent().getIntExtra("id", -1);

        buttonDeletar.setOnClickListener(v -> {
            if (clienteId != -1) {
                ClientDAO dao = new ClientDAO(DetalheClienteActivity.this);
                dao.deletarCliente(clienteId);
                Toast.makeText(this, "Cliente excluído com sucesso.", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Erro ao excluir cliente.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
