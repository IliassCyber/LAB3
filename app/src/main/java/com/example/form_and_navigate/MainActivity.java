package com.example.form_and_navigate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etFullName, etEmail, etPhone, etAddress, etCity;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des vues
        etFullName = findViewById(R.id.et_full_name);
        etEmail    = findViewById(R.id.et_email_address);
        etPhone    = findViewById(R.id.et_phone_number);
        etAddress  = findViewById(R.id.et_home_address);
        etCity     = findViewById(R.id.et_city);
        btnSubmit  = findViewById(R.id.btn_send_data);

        btnSubmit.setOnClickListener(v -> {
            String name    = etFullName.getText().toString().trim();
            String email   = etEmail.getText().toString().trim();
            String phone   = etPhone.getText().toString().trim();
            String address = etAddress.getText().toString().trim();
            String city    = etCity.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir le nom et l'email.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, Screen2Activity.class);
            intent.putExtra("USER_NAME", name);
            intent.putExtra("USER_EMAIL", email);
            intent.putExtra("USER_PHONE", phone);
            intent.putExtra("USER_ADDRESS", address);
            intent.putExtra("USER_CITY", city);

            startActivity(intent);
        });
    }
}