package com.example.pawtner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;


import androidx.appcompat.app.AppCompatActivity;

import com.example.pawtner.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.register);

//        TextView signInText = findViewById(R.id.signinText);

        // 👉 Redirect untuk Sign In Text
        TextView signInText = findViewById(R.id.signinText);
        // Buat kalimat
        String baseText = "Already have an account? Sign in";
        SpannableString spannable = new SpannableString(baseText);

        // Cari posisi "Sign in"
        int start = baseText.indexOf("Sign in");
        int end = start + "Sign in".length();

        // Tambahkan warna biru dan underline hanya ke "Sign in"
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#5D9BFF")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new UnderlineSpan(), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        signInText.setText(spannable);
        signInText.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });


        // ✅ Validasi untuk tombol Sign Up
        Button signUpButton = findViewById(R.id.signupButton);

        EditText fullNameInput = findViewById(R.id.fullNameInput);
        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        EditText phoneInput = findViewById(R.id.phoneInput);
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        EditText addressInput = findViewById(R.id.addressInput);
        EditText nikInput = findViewById(R.id.nikInput);
        TextView errorMessage = findViewById(R.id.errorMessage); // 🔴 Tambahkan ini

        signUpButton.setOnClickListener(v -> {
            String fullName = fullNameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            String phone = phoneInput.getText().toString().trim();
            int selectedGenderId = genderGroup.getCheckedRadioButtonId();
            String address = addressInput.getText().toString().trim();
            String nik = nikInput.getText().toString().trim();

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()
                    || phone.isEmpty() || selectedGenderId == -1
                    || address.isEmpty() || nik.isEmpty()) {
                errorMessage.setText("Please complete all fields."); // 🔴 Munculkan pesan error
                errorMessage.setVisibility(TextView.VISIBLE);
            } else {
                errorMessage.setVisibility(TextView.GONE); // ✅ Sembunyikan pesan jika valid
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // 👉 Google & Facebook buttons
        MaterialButton googleButton = findViewById(R.id.googleButton);
        MaterialButton facebookButton = findViewById(R.id.facebookButton);

        googleButton.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });

        facebookButton.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}
