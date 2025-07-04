package com.example.pawtner.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pawtner.R;

public class ProfileActivity extends AppCompatActivity {

    EditText nameInput, genderInput, phoneInput, emailInput, addressInput, nikInput;
    Button editProfileBtn; // ✅ deklarasi tombol

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Ambil data dari intent register
        Intent intent = getIntent();
        String fullName = intent.getStringExtra("name");
        String gender = intent.getStringExtra("gender");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String address = intent.getStringExtra("address");
        String nik = intent.getStringExtra("nik");

        nameInput = findViewById(R.id.nameInput);
        genderInput = findViewById(R.id.genderInput);
        phoneInput = findViewById(R.id.phoneInput);
        emailInput = findViewById(R.id.emailInput);
        addressInput = findViewById(R.id.addressInput);
        nikInput = findViewById(R.id.nikInput);

        editProfileBtn = findViewById(R.id.editProfileBtn); // ✅ inisialisasi
        editProfileBtn.setOnClickListener(v -> {
            Intent editIntent = new Intent(ProfileActivity.this, ProfileEditActivity.class);
            startActivity(editIntent);
        });

        findViewById(R.id.logoutBtn).setOnClickListener(v -> showLogoutDialog());
    }

    private void showLogoutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Logout Confirmation")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    startActivity(new Intent(ProfileActivity.this, RegisterActivity.class));
                    finish();
                })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
