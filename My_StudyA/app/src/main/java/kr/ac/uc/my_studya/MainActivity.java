package kr.ac.uc.my_studya;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvAge, tvInfo, tvSelect;
    EditText etName, etAge;
    Button btnReset, btnSelect;

    RadioButton radio1, radio2, radio3;
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

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvInfo = findViewById(R.id.tvInfo);
        tvSelect = findViewById(R.id.tvSelect);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnReset = findViewById(R.id.btnReset);
        btnSelect = findViewById(R.id.btnSelect);

        radio1 = findViewById(R.id.radioButton1);
        radio2 = findViewById(R.id.radioButton2);
        radio3 = findViewById(R.id.radioButton3);

        btnSelect.setOnClickListener(v->{
            tvInfo.setText(etName.getText() + "은 " + etAge.getText()+ "살 입니다.");
        });

        btnReset.setOnClickListener(v->{
            etName.setText("");
            etAge.setText("");
            if(radio1.isChecked()){
                radio1.setChecked(false);
            } else if (radio2.isChecked()) {
                radio2.setChecked(false);
            } else {
                radio3.setChecked(false);
            }
        });
    }
}