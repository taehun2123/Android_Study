package kr.ac.uc.work_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPasswd;
    Button btnSubmit;
    TextView tvResult;
    ActivityResultLauncher<Intent> launcher;

    public static final String NAME_KEY = "name";
    public static final String PASSWD_KEY = "passwd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        etPasswd = findViewById(R.id.etPasswd);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent data = result.getData();
                    assert data != null;
                    tvResult.setText(data.getStringExtra(SecondActivity.KEY_RESULT));
                });

        btnSubmit.setOnClickListener(this::goToSecond);
    }

    private void goToSecond(View view) {
        String name = etName.getText().toString();
        String passwd = etPasswd.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(NAME_KEY, name);
        intent.putExtra(PASSWD_KEY, passwd);
        launcher.launch(intent);
    }
}