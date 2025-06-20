package com.example.vinheria.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "vinheria.db";
    private static final int VERSAO = 1;

    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCliente = "CREATE TABLE clientes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(100) NOT NULL," +
                "cpf_cnpj VARCHAR(20) UNIQUE NOT NULL," +
                "telefone VARCHAR(20)," +
                "email VARCHAR(100)," +
                "endereco TEXT," +
                "cidade VARCHAR(50)," +
                "estado CHAR(2)," +
                "cep VARCHAR(10)," +
                "observacoes TEXT)";
        db.execSQL(sqlCliente);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS clientes");
        onCreate(db);
    }
}
