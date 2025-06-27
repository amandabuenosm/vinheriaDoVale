package com.example.vinheria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DispEstoqueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoqueproduto);

        Button buttonSair = findViewById(R.id.buttonSair);

        buttonSair.setOnClickListener(v -> {
            finish();
        });
    }
}
