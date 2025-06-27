package com.example.vinheria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_areavendedor);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // referenciar botão para abrir nova tela
        Button manutencaoClientes = findViewById(R.id.manutencaoClientes);

        manutencaoClientes.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ManutencaoClientesActivity.class);
            startActivity(intent);
        });

        Button dispEstoque = findViewById(R.id.dispEstoque);

        dispEstoque.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DispEstoqueActivity.class);
            startActivity(intent);
        });
    }
}
