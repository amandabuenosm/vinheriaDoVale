package com.example.vinheria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vinheria.database.BancoHelper;
import com.example.vinheria.models.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    private BancoHelper dbHelper;

    public ClientDAO(Context context) {
        dbHelper = new BancoHelper(context);
    }

    // Inserir Cliente
    public void inserirCliente(Client cliente) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome", cliente.getNome());
        valores.put("cpf_cnpj", cliente.getCpf_cnpj());
        valores.put("telefone", cliente.getTelefone());
        valores.put("email", cliente.getEmail());
        valores.put("endereco", cliente.getEndereco());
        valores.put("cidade", cliente.getCidade());
        valores.put("estado", cliente.getEstado());
        valores.put("cep", cliente.getCep());
        valores.put("observacoes", cliente.getObservacoes());
        db.insert("clientes", null, valores);
        db.close();
    }

    // Listar Clientes
    public List<Client> listarClientes() {
        List<Client> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM clientes", null);

        if (cursor.moveToFirst()) {
            do {
                Client cliente = new Client();
                cliente.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                cliente.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
                cliente.setCpf_cnpj(cursor.getString(cursor.getColumnIndexOrThrow("cpf_cnpj")));
                cliente.setTelefone(cursor.getString(cursor.getColumnIndexOrThrow("telefone")));
                cliente.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
                cliente.setEndereco(cursor.getString(cursor.getColumnIndexOrThrow("endereco")));
                cliente.setCidade(cursor.getString(cursor.getColumnIndexOrThrow("cidade")));
                cliente.setEstado(cursor.getString(cursor.getColumnIndexOrThrow("estado")));
                cliente.setCep(cursor.getString(cursor.getColumnIndexOrThrow("cep")));
                cliente.setObservacoes(cursor.getString(cursor.getColumnIndexOrThrow("observacoes")));
                lista.add(cliente);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lista;
    }
}
