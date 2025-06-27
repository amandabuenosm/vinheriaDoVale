package com.example.vinheria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MetasComissoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manutencaocomissoes);

        Button buttonSair = findViewById(R.id.buttonSairMetas);

        buttonSair.setOnClickListener(v -> {
            finish();
        });
    }
}
