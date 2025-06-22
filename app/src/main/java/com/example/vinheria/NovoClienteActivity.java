package com.example.vinheria;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinheria.dao.ClientDAO;
import com.example.vinheria.models.Client;

public class NovoClienteActivity extends AppCompatActivity {

    // Declaração dos campos
    private EditText editNome, editCpfCnpj, editTelefone, editEmail, editEndereco,
            editCidade, editEstado, editCep, editObservacoes;
    private Button buttonSalvar, buttonSair;

    private ClientDAO clientDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novocliente);

        // Inicializa o DAO
        clientDAO = new ClientDAO(this);

        // Referencia os campos
        editNome = findViewById(R.id.editNome);
        editCpfCnpj = findViewById(R.id.editCpfCnpj);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail = findViewById(R.id.editEmail);
        editEndereco = findViewById(R.id.editEndereco);
        editCidade = findViewById(R.id.editCidade);
        editEstado = findViewById(R.id.editEstado);
        editCep = findViewById(R.id.editCep);
        editObservacoes = findViewById(R.id.editObservacoes);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonSair = findViewById(R.id.buttonSair);

        // Clique no botão de salvar
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarCliente();
            }
        });

        // Clique no botão de sair
        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void salvarCliente() {
        // Validação básica
        if (editNome.getText().toString().isEmpty() || editCpfCnpj.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha pelo menos o nome e o CPF/CNPJ!", Toast.LENGTH_SHORT).show();
            return;
        }

        // 📝 LOG para ver o nome digitado
        String nomeDigitado = editNome.getText().toString();
        Log.d("DEBUG_NOME", "Nome digitado: " + nomeDigitado);

        // Cria cliente
        Client cliente = new Client();
        cliente.setNome(nomeDigitado);
        cliente.setCpf_cnpj(editCpfCnpj.getText().toString());
        cliente.setTelefone(editTelefone.getText().toString());
        cliente.setEmail(editEmail.getText().toString());
        cliente.setEndereco(editEndereco.getText().toString());
        cliente.setCidade(editCidade.getText().toString());
        cliente.setEstado(editEstado.getText().toString());
        cliente.setCep(editCep.getText().toString());
        cliente.setObservacoes(editObservacoes.getText().toString());

        // Insere no banco
        long id = clientDAO.inserirCliente(cliente);

        if (id != -1) {
            Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            finish(); // Fecha a activity após cadastro
        } else {
            Toast.makeText(this, "Erro ao cadastrar cliente.", Toast.LENGTH_SHORT).show();
        }
    }
}
