package com.example.pawtner.ui;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pawtner.R;
import android.content.Intent;


public class ProfileEditActivity extends AppCompatActivity {

    EditText nameInput, genderInput, phoneInput, emailInput, addressInput, nikInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        nameInput = findViewById(R.id.nameInput);
        genderInput = findViewById(R.id.genderInput);
        phoneInput = findViewById(R.id.phoneInput);
        emailInput = findViewById(R.id.emailInput);
        addressInput = findViewById(R.id.addressInput);
        nikInput = findViewById(R.id.nikInput); // <- ini penting

        // Ambil data dari intent
        nameInput.setText(getIntent().getStringExtra("name"));
        genderInput.setText(getIntent().getStringExtra("gender"));
        phoneInput.setText(getIntent().getStringExtra("phone"));
        emailInput.setText(getIntent().getStringExtra("email"));
        addressInput.setText(getIntent().getStringExtra("address"));
        nikInput.setText(getIntent().getStringExtra("nik")); // <- ini juga penting

        // Jadikan field editable (kecuali gender dan nik)
        nameInput.setEnabled(true);
        phoneInput.setEnabled(true);
        emailInput.setEnabled(true);
        addressInput.setEnabled(true);

        // Gender dan NIK tetap non-editable (dari XML sudah benar)

        // Ubah warna teks NIK jadi abu-abu
        nikInput.setTextColor(getResources().getColor(android.R.color.darker_gray));

        findViewById(R.id.saveBtn).setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", nameInput.getText().toString());
            resultIntent.putExtra("phone", phoneInput.getText().toString());
            resultIntent.putExtra("email", emailInput.getText().toString());
            resultIntent.putExtra("address", addressInput.getText().toString());

            setResult(RESULT_OK, resultIntent);
            finish();

        });

    }


}
