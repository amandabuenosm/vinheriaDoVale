package com.example.vinheria.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vinheria.R;
import com.example.vinheria.models.Client;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {

    private List<Client> listaClientes;

    public ClientAdapter(List<Client> lista) {
        this.listaClientes = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nome, email;

        public ViewHolder(View view) {
            super(view);
            nome = view.findViewById(R.id.textNomeCliente);
            email = view.findViewById(R.id.textEmailCliente);
        }
    }

    @Override
    public ClientAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Client cliente = listaClientes.get(position);
        holder.nome.setText(cliente.getNome());
        holder.email.setText(cliente.getEmail());
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }
}
