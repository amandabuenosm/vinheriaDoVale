package com.example.vinheria;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClientDetailActivity extends AppCompatActivity {

    private TextView tvName, tvLocation, tvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);

        tvName = findViewById(R.id.tvDetailClientName);
        tvLocation = findViewById(R.id.tvDetailClientLocation);
        tvContact = findViewById(R.id.tvDetailClientContact);

        // visualizar dados enviados da tela anterior
        String name = getIntent().getStringExtra("clientName");
        String location = getIntent().getStringExtra("clientLocation");
        String contact = getIntent().getStringExtra("clientContact");

        // preenchimento dos dados na tela
        tvName.setText(name);
        tvLocation.setText(location);
        tvContact.setText(contact);
    }
}
