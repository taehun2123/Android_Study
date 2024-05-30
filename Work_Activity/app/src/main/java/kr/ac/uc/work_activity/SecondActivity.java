package kr.ac.uc.work_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView tvResult;
    Button btnBack;

    boolean flag;

    public static final String KEY_RESULT = "result";
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
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        if(intent != null){
            String nameData = intent.getStringExtra(MainActivity.NAME_KEY);
            String passwdData = intent.getStringExtra(MainActivity.PASSWD_KEY);
            if(nameData.equals("abc") && passwdData.equals("1234")){
                tvResult.setText("성공!");
                flag = true;
            } else {
                tvResult.setText("실패ㅜ");
                flag = false;
            }
        }
        btnBack.setOnClickListener(this::onClickBackBtn);
    }

    private void onClickBackBtn(View view) {
        Intent intent = new Intent();
        intent.putExtra(KEY_RESULT, tvResult.getText().toString());
        setResult(flag ? RESULT_OK : RESULT_CANCELED, intent);
        finish();
    }
}