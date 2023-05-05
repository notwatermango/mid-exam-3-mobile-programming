package com.example.uts_no3_pendataan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private Button btSubmit;
    private EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btSubmit = findViewById(R.id.btLogin);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (isValidCredential(username, password)) {
                    Intent intent = new Intent(v.getContext(), FormActivity.class);
                    v.getContext().startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credential", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isValidCredential(String username, String password) {
        if (Objects.equals(username, "user") && Objects.equals(password, "user")) return true;
        if (Objects.equals(username, "admin") && Objects.equals(password, "admin")) return true;
        return false;
    }
}