package com.example.vinheria.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vinheria.DetalheClienteActivity;
import com.example.vinheria.R;
import com.example.vinheria.models.Client;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {

    private final List<Client> listaClientes;

    public ClientAdapter(List<Client> lista) {
        this.listaClientes = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nome, cidadeEstado;

        public ViewHolder(View view) {
            super(view);
            nome = view.findViewById(R.id.textNomeCliente);
            cidadeEstado = view.findViewById(R.id.textCidadeEstado);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cliente, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Client cliente = listaClientes.get(position);
        holder.nome.setText(cliente.getNome());
        holder.cidadeEstado.setText(cliente.getCidade() + ", " + cliente.getEstado());

        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetalheClienteActivity.class);
            intent.putExtra("nome", cliente.getNome());
            intent.putExtra("cpf_cnpj", cliente.getCpf_cnpj());
            intent.putExtra("telefone", cliente.getTelefone());
            intent.putExtra("email", cliente.getEmail());
            intent.putExtra("endereco", cliente.getEndereco());
            intent.putExtra("cidade", cliente.getCidade());
            intent.putExtra("estado", cliente.getEstado());
            intent.putExtra("cep", cliente.getCep());
            intent.putExtra("observacoes", cliente.getObservacoes());
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }
}
