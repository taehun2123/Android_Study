package kr.ac.uc.extra_data_intent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    public static final String KEY_RESULT = "result";
    TextView tvResult;
    EditText etResult;
    Button btnOk, btnCancel;
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvResult = findViewById(R.id.tvResult);
        etResult = findViewById(R.id.etResult);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
        
        btnOk.setOnClickListener(this::onClickOkBtn);
        btnCancel.setOnClickListener(this::onClickCancelBtn);
        
        Intent intent = getIntent();
        if(intent != null){
            int intData = intent.getIntExtra(MainActivity.KEY_INT_DATA, 0);
            double doubleData = intent.getDoubleExtra(MainActivity.KEY_DOUBLE_DATA, 0.0);
            String stringData = intent.getStringExtra(MainActivity.KEY_STRING_DATA);
            tvResult.setText(String.format("int : %d, double : %.2f, String: %s", intData, doubleData, stringData));
        }
    }

    private void onClickCancelBtn(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    private void onClickOkBtn(View view) {
        Intent intent = new Intent();
        intent.putExtra(KEY_RESULT, etResult.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}