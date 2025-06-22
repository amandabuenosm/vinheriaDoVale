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
