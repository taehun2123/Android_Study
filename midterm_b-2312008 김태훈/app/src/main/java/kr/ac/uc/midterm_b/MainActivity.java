package kr.ac.uc.midterm_b;

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

public class MainActivity extends AppCompatActivity {
    EditText etOperand1, etOperand2;
    Button btnPlus, btnMinus, btnMultiply, btnDivision, btnReset;
    TextView tvResult;

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

        etOperand1 = findViewById(R.id.etOperand1);
        etOperand2 = findViewById(R.id.etOperand2);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivision = findViewById(R.id.btnDivision);
        btnReset = findViewById(R.id.btnReset);

        tvResult = findViewById(R.id.tvResult);

        btnPlus.setOnClickListener(this::doCalculate);
        btnMinus.setOnClickListener(this::doCalculate);
        btnMultiply.setOnClickListener(this::doCalculate);
        btnDivision.setOnClickListener(this::doCalculate);
        btnReset.setOnClickListener(this::doReset);
    }

    private void doReset(View view) {
        etOperand1.setText("");
        etOperand2.setText("");
        tvResult.setText("2개의 피연산자를 입력한 후 연산자 버튼을 클릭하세요.");
    }

    private void doCalculate(View view) {
        if((etOperand1.getText().length() > 0) && (etOperand2.getText().length() > 0)){
            float a = Float.parseFloat(String.valueOf(etOperand1.getText()));
            float b = Float.parseFloat(String.valueOf(etOperand2.getText()));
            if (view.getId() == R.id.btnPlus){
                tvResult.setText(String.format("%.2f", a)+" + "+String.format("%.2f", b)+" = "+String.format("%.2f", a+b));
            } else if(view.getId() == R.id.btnMinus){
                tvResult.setText(String.format("%.2f", a)+" - "+String.format("%.2f", b)+" = "+String.format("%.2f", a-b));
            } else if (view.getId() == R.id.btnMultiply){
                tvResult.setText(String.format("%.2f", a)+" * "+String.format("%.2f", b)+" = "+String.format("%.2f", a*b));
            } else if (view.getId() == R.id.btnDivision){
                if(b==0)
                    tvResult.setText("Error : Division zero.");
                else
                    tvResult.setText(String.format("%.2f", a)+" / "+String.format("%.2f", b)+" = "+String.format("%.2f", a/b));
            }
        } else {
            tvResult.setText("2개의 피연산자를 모두 입력해 주세요");
        }
    }


}