package com.example.pawtner.ui;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pawtner.R;

public class ProfileEditActivity extends AppCompatActivity {

    EditText nameInput, genderInput, phoneInput, emailInput, addressInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        nameInput = findViewById(R.id.nameInput);
        genderInput = findViewById(R.id.genderInput);
        phoneInput = findViewById(R.id.phoneInput);
        emailInput = findViewById(R.id.emailInput);
        addressInput = findViewById(R.id.addressInput);

        // Contoh pengisian awal
        nameInput.setText("Jason Amanda Hezkiel");

        findViewById(R.id.saveBtn).setOnClickListener(v -> {
            // Simpan perubahan jika perlu
            finish(); // kembali ke ProfileActivity
        });
    }
}
