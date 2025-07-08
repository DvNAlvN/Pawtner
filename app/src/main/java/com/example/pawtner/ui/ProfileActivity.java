package com.example.pawtner.ui;

import com.example.pawtner.R;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    EditText nameInput, genderInput, phoneInput, emailInput, addressInput, nikInput;
    Button editProfileBtn;

    private final ActivityResultLauncher<Intent> editProfileLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    nameInput.setText(data.getStringExtra("name"));
                    phoneInput.setText(data.getStringExtra("phone"));
                    emailInput.setText(data.getStringExtra("email"));
                    addressInput.setText(data.getStringExtra("address"));
                    // gender dan nik tidak berubah
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        nameInput = findViewById(R.id.nameInput);
        genderInput = findViewById(R.id.genderInput);
        phoneInput = findViewById(R.id.phoneInput);
        emailInput = findViewById(R.id.emailInput);
        addressInput = findViewById(R.id.addressInput);
        nikInput = findViewById(R.id.nikInput);

        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, NotificationActivity.class);
            startActivity(intent);
            finish(); // jika tidak ingin user kembali ke ProfileActivity
        });

        // Data awal
        nameInput.setText("Maritza Eka");
        genderInput.setText("Female");
        phoneInput.setText("089123456789");
        emailInput.setText("maritza@gmail.com");
        addressInput.setText("Jl. Mawar No. 123");
        nikInput.setText("1234567890123456");

        editProfileBtn = findViewById(R.id.editProfileBtn);
        editProfileBtn.setOnClickListener(v -> {
            Intent editIntent = new Intent(this, ProfileEditActivity.class);
            editIntent.putExtra("name", nameInput.getText().toString());
            editIntent.putExtra("gender", genderInput.getText().toString());
            editIntent.putExtra("phone", phoneInput.getText().toString());
            editIntent.putExtra("email", emailInput.getText().toString());
            editIntent.putExtra("address", addressInput.getText().toString());
            editIntent.putExtra("nik", nikInput.getText().toString());
            editProfileLauncher.launch(editIntent);
        });

        findViewById(R.id.logoutBtn).setOnClickListener(v -> showLogoutDialog());
    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.logout_dialog, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent); // biar rounded

        // Tombol-tombol
        Button yesBtn = dialogView.findViewById(R.id.yesBtn);
        Button noBtn = dialogView.findViewById(R.id.noBtn);
        ImageView closeBtn = dialogView.findViewById(R.id.closeBtn);

        // Action tombol
        yesBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            dialog.dismiss();
        });

        noBtn.setOnClickListener(v -> dialog.dismiss());
        closeBtn.setOnClickListener(v -> dialog.dismiss());

        // ✅ Pastikan ukurannya wrap dan posisinya di tengah
        dialog.show(); // panggil show() dulu sebelum setGravity
//        dialog.getWindow().setLayout(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        );
//        dialog.getWindow().setGravity(Gravity.CENTER); // ⬅️ Tambahkan ini agar benar-benar center
    }
}
