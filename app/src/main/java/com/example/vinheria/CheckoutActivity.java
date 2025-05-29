package com.example.vinheria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    EditText editTextAddress, editTextPayment;
    Button buttonFinishOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        editTextAddress = findViewById(R.id.editTextAddress);
        editTextPayment = findViewById(R.id.editTextPayment);
        buttonFinishOrder = findViewById(R.id.buttonFinishOrder);

        buttonFinishOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextAddress.getText().toString().isEmpty() || editTextPayment.getText().toString().isEmpty()) {
                    Toast.makeText(CheckoutActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(CheckoutActivity.this, OrderConfirmationActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
