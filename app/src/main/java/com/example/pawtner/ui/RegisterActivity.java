package com.example.pawtner.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pawtner.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sembunyikan Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        // Tampilkan layout activity_register.xml
        setContentView(R.layout.register);
    }
}
