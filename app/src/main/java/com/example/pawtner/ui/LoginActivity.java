package com.example.pawtner.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pawtner.R;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.login);
    }
}
