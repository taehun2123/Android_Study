package kr.ac.uc.mystudy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvGrade, tvInfo;
    EditText etName;

    ImageView iv;

    RadioButton grade1, grade2, grade3;
    Button btnReset, btnMenu;
    @SuppressLint("SetTextI18n")
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
        tvGrade = findViewById(R.id.tvGrade);
        tvInfo = findViewById(R.id.tvInfo);
        etName = findViewById(R.id.etName);
        iv = findViewById(R.id.iv);
        grade1 = findViewById(R.id.grade1);
        grade2 = findViewById(R.id.grade2);
        grade3 = findViewById(R.id.grade3);
        btnReset = findViewById(R.id.btnReset);
        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(v->{
            tvInfo.setText(etName.getText() + "은 "
                    + (grade1.isChecked()
                    ? grade1.getText()
                    : grade2.isChecked()
                    ? grade2.getText()
                    : grade3.getText()) + "입니다.");
            iv.setImageResource(R.drawable.jjajan);
        });

        btnReset.setOnClickListener(v -> {
            etName.setText("");
            tvInfo.setText("");
            grade1.setChecked(false);
            grade2.setChecked(false);
            grade3.setChecked(false);
            iv.setImageResource(0);
        });
    }
}