package com.example.vinheria.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinheria.ClientDetailActivity;
import com.example.vinheria.R;
import com.example.vinheria.models.Client;
import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {

    private final Context context;
    private final List<Client> clientList;

    public ClientAdapter(Context ctx, List<Client> clients) {
        this.context = ctx;
        this.clientList = clients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_client, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Client client = clientList.get(position);
        holder.name.setText(client.getName());
        holder.location.setText(client.getLocation());
        holder.contact.setText(client.getContact());

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, ClientDetailActivity.class);
            i.putExtra("clientName", client.getName());
            i.putExtra("clientLocation", client.getLocation());
            i.putExtra("clientContact", client.getContact());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, location, contact;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvClientName);
            location = itemView.findViewById(R.id.tvClientLocation);
            contact = itemView.findViewById(R.id.tvClientContact);
        }
    }
}
