public class ProfileActivity extends AppCompatActivity {
    Button btnEditSave, btnCancelLogout, btnConfirmLogout;
    ImageView btnLogout;
    LinearLayout logoutPopup;
    EditText etName, etPhone, etEmail, etAddress, etNIK;
    Spinner spinnerGender;
    boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Init
        btnEditSave = findViewById(R.id.btnEditSave);
        btnLogout = findViewById(R.id.btnLogout);
        logoutPopup = findViewById(R.id.logoutPopup);
        btnCancelLogout = findViewById(R.id.btnCancelLogout);
        btnConfirmLogout = findViewById(R.id.btnConfirmLogout);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        etNIK = findViewById(R.id.etNIK);
        spinnerGender = findViewById(R.id.spinnerGender);

        btnEditSave.setOnClickListener(v -> {
            if (isEditMode) {
                disableEdit();
                btnEditSave.setText("Edit Profile");
                // TODO: Save changes logic
            } else {
                enableEdit();
                btnEditSave.setText("Save Changes");
            }
            isEditMode = !isEditMode;
        });

        btnLogout.setOnClickListener(v -> logoutPopup.setVisibility(View.VISIBLE));
        btnCancelLogout.setOnClickListener(v -> logoutPopup.setVisibility(View.GONE));
        btnConfirmLogout.setOnClickListener(v -> {
            // TODO: Perform logout
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
        });

        disableEdit();
    }

    private void enableEdit() {
        etName.setEnabled(true);
        etPhone.setEnabled(true);
        etEmail.setEnabled(true);
        etAddress.setEnabled(true);
        spinnerGender.setEnabled(true);
    }

    private void disableEdit() {
        etName.setEnabled(false);
        etPhone.setEnabled(false);
        etEmail.setEnabled(false);
        etAddress.setEnabled(false);
        etNIK.setEnabled(false);
        spinnerGender.setEnabled(false);
    }
}
