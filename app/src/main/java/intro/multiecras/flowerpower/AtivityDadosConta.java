package intro.multiecras.flowerpower;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import intro.multiecras.flowerpower.InfoUtilizador;

public class AtivityDadosConta extends AppCompatActivity {

    private EditText novoNomeUtilizador;
    private EditText novoEmail;
    private ImageButton dataDeAniversario;
    private EditText dataDeNascimento;
    private Button updateProfile;
    private ProgressBar progressIndicator;

    private boolean isUpdating = false;
    private boolean hasErrors = false;
    private InfoUtilizador userToEdit;

    /*private Calendar birthDayCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = (DatePicker view, int year, int month, int dayOfMonth) -> {
        birthDayCalendar.set(Calendar.YEAR, year);
        birthDayCalendar.set(Calendar.MONTH, month);
        birthDayCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        onUpdateNewBirthday();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        this.userToEdit = InfoUtilizador.getByEmail(Container.authStateContainer.getState().email);

        this.novoNomeUtilizador = findViewById(R.id.newUsername);
        this.novoNomeUtilizador.setText(this.userToEdit.username);

        this.novoEmail = findViewById(R.id.newEmail);
        this.novoEmail.setText(this.userToEdit.email);

        this.dataDeAniversario = findViewById(R.id.newBirthDay);
        this.dataDeNascimento = findViewById(R.id.data_nascimento_input);
        this.dataDeNascimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(this.userToEdit.dataNascimento)));

        this.updateProfile = findViewById(R.id.updateProfile);
        this.progressIndicator = findViewById(R.id.progressIndicator);

        this.updateProfile.setOnClickListener(this::onUpdateProfile);
        this.dataDeAniversario.setOnClickListener(this::onSetNewBirthday);

        this.watchInputs();
    }

    private void watchInputs() {
        this.novoNomeUtilizador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() <= 0) novoNomeUtilizador.setError(getString(R.string.empty_username_error_msg));
                else novoNomeUtilizador.setError(null);

            }
        });

        this.novoEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() <= 0) novoEmail.setError(getString(R.string.empty_email_error_msg));
                else novoEmail.setError(null);
            }
        });
        this.dataDeNascimento.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() <= 0) dataDeNascimento.setError(getString(R.string.empty_data_nasc_error_msg));
                else dataDeNascimento.setError(null);
            }
        });
    }

    private void onSetNewBirthday(View view) {
        new DatePickerDialog(
                this,
                date,
                this.birthDayCalendar.get(Calendar.YEAR),
                this.birthDayCalendar.get(Calendar.MONTH),
                this.birthDayCalendar.get(Calendar.DAY_OF_MONTH)
        ).show();
    }

    private void onUpdateNewBirthday() {
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(this);
        this.dataDeNascimento.setText(dateFormat.format(this.birthDayCalendar.getTime()));

    }

    private void onUpdateProfile(View view) {

        if (this.isUpdating) return;

        this.hasErrors = false;

        try{
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            View currentFocusedView = this.getCurrentFocus();
            if (currentFocusedView != null) {
                inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        this.isUpdating = true;

        updateProfile.setVisibility(View.GONE);
        progressIndicator.setVisibility(View.VISIBLE);

        String username = this.novoNomeUtilizador.getText().toString();
        String email = this.novoEmail.getText().toString();
        String nTelemovel = this.newPhoneNumber.getText().toString();
        String dataNasc = this.dataDeNascimento.getText().toString();

        if (email.length() <= 0) {
            this.novoEmail.setError(this.getString(R.string.empty_email_error_msg));
            this.isUpdating = false;
            this.hasErrors = true;
        }

        if (username.length() <= 0) {
            this.novoNomeUtilizador.setError(this.getString(R.string.empty_name_error_msg));
            this.isUpdating = false;
            this.hasErrors = true;
        }

        if (nTelemovel.length() <= 0) {
            this.newPhoneNumber.setError(this.getString(R.string.empty_numero_error_msg));
            this.isUpdating = false;
            this.hasErrors = true;
        }

        if (dataNasc.length() <= 0) {
            this.dataDeNascimento.setError(this.getString(R.string.empty_data_nasc_error_msg));
            this.isUpdating = false;
            this.hasErrors = true;
        }

        if (this.hasErrors) {
            Toast.makeText(this, getString(R.string.error_update_profile_msg), Toast.LENGTH_LONG).show();
            updateProfile.setVisibility(View.VISIBLE);
            progressIndicator.setVisibility(View.GONE);
            return;
        }

        AsyncTask.execute(() -> {
            try {
                this.userToEdit.email = email;
                this.userToEdit.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNasc).getTime();
                this.userToEdit.nTelemovel = nTelemovel;
                this.userToEdit.username = username;

                if (!this.userToEdit.update())
                    throw new Exception("Could not update user information");

                SessionManager.getSessionManager().login(userToEdit.username, userToEdit.email);

                runOnUiThread(() -> {
                    Container.authStateContainer.setState(ps -> new AuthState(true, userToEdit.username, userToEdit.email));
                    isUpdating = false;
                    updateProfile.setVisibility(View.VISIBLE);
                    progressIndicator.setVisibility(View.GONE);
                    finish();
                });

            } catch (Exception e) {
                runOnUiThread(() -> {
                    isUpdating = false;
                    updateProfile.setVisibility(View.VISIBLE);
                    progressIndicator.setVisibility(View.GONE);
                    Toast.makeText(this, getString(R.string.error_update_profile_msg), Toast.LENGTH_LONG).show();
                });
            }
        });
    }
    */
}

