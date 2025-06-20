package com.example.vinheria;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinheria.adapters.ClientAdapter;
import com.example.vinheria.dao.ClientDAO;
import com.example.vinheria.models.Client;

import java.util.List;

public class ClientesCadastradosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ClientAdapter adapters;
    private ClientDAO clienteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientescadastrados);

        recyclerView = findViewById(R.id.recyclerViewClientes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        clienteDAO = new ClientDAO(this);

        // inserção no banco para testes
        if (clienteDAO.listarClientes().isEmpty()) {
            Client c1 = new Client();
            c1.setNome("Raimundo Tiago Caldeira");
            c1.setCpf_cnpj("556.445.956-33");
            c1.setTelefone("11 99805-2261");
            c1.setEmail("raimundo_caldeira@fibran.com.br");
            c1.setEndereco("Rua Rinópolis, 623, Bairro Cidade Industrial Satélite de São Paulo");
            c1.setCidade("São Paulo");
            c1.setEstado("SP");
            c1.setCep("69918-178");
            c1.setObservacoes("Cliente VIP");
            clienteDAO.inserirCliente(c1);

            Client c2 = new Client();
            c2.setNome("Vinícola Trevisol LTDA");
            c2.setCpf_cnpj("47.085.221/0001-73");
            c2.setTelefone("48 3940-2249");
            c2.setEmail("administrativo@trevisol.com.br");
            c2.setEndereco("Rua Arcelino Pedro Batista, 521, São Simão");
            c2.setCidade("Criciúma");
            c2.setEstado("SC");
            c2.setCep("88811-830");
            c2.setObservacoes("Parente do dono");
            clienteDAO.inserirCliente(c2);

            Client c3 = new Client();
            c3.setNome("Isabelly Eliane Laura da Cunha");
            c3.setCpf_cnpj("811.095.219-44");
            c3.setTelefone("41 98766-2660");
            c3.setEmail("isabelly-dacunha73@db9.com.br");
            c3.setEndereco("Rua Antonio dos Santos, 849, Ipê");
            c3.setCidade("São José dos Pinhais");
            c3.setEstado("PR");
            c3.setCep("83055-519");
            c3.setObservacoes("Nova cliente");
            clienteDAO.inserirCliente(c3);
        }

        // carga de clientes cadastrados
        List<Client> clientes = clienteDAO.listarClientes();
        adapters = new ClientAdapter(clientes);
        recyclerView.setAdapter(adapters);

        Button buttonSair = findViewById(R.id.buttonSair);

        buttonSair.setOnClickListener(v -> {
            finish();
        });
    }
}
