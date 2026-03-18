package com.example.form_and_navigate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    private TextView tvSummary;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        tvSummary = findViewById(R.id.tv_display_recap);
        btnBack = findViewById(R.id.btn_go_back);

        Intent incomingIntent = getIntent();

        String name    = incomingIntent.getStringExtra("USER_NAME");
        String email   = incomingIntent.getStringExtra("USER_EMAIL");
        String phone   = incomingIntent.getStringExtra("USER_PHONE");
        String address = incomingIntent.getStringExtra("USER_ADDRESS");
        String city    = incomingIntent.getStringExtra("USER_CITY");

        StringBuilder sb = new StringBuilder();
        sb.append("Nom : ").append(formatValue(name)).append("\n");
        sb.append("Email : ").append(formatValue(email)).append("\n");
        sb.append("Téléphone : ").append(formatValue(phone)).append("\n");
        sb.append("Adresse : ").append(formatValue(address)).append("\n");
        sb.append("Ville : ").append(formatValue(city));

        tvSummary.setText(sb.toString());

        btnBack.setOnClickListener(v -> finish());
    }

    private String formatValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            return "Non renseigné";
        }
        return value.trim();
    }
}