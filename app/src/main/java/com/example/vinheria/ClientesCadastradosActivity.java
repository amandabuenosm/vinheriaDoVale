package com.example.vinheria;

import android.os.Bundle;
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
            Client c1 = new Client(0, "Amanda", "amanda@email.com");
            Client c2 = new Client(0, "Bruno", "bruno@email.com");
            clienteDAO.inserirCliente(c1);
            clienteDAO.inserirCliente(c2);
        }

        // carga de clientes cadastrados
        List<Client> clientes = clienteDAO.listarClientes();
        adapters = new ClientAdapter(clientes);
        recyclerView.setAdapter(adapters);
    }
}
