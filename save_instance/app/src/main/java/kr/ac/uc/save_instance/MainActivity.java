package kr.ac.uc.save_instance;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_CNT = "count";

    Button btnInc, btnDec;
    TextView tvResult;

    int cnt;

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

        btnDec = findViewById(R.id.btnDec);
        btnInc = findViewById(R.id.btnInc);
        tvResult = findViewById(R.id.tvResult);
        if(savedInstanceState == null){
            cnt = 0;
        } else {
            cnt = savedInstanceState.getInt(KEY_CNT);
        }
        displayCount();

        btnInc.setOnClickListener(v->{
            cnt+=1;
            displayCount();
        });

        btnDec.setOnClickListener(v->{
            cnt-=1;
            displayCount();
        });
    }
    private void displayCount(){
        tvResult.setText("현재 값 : " + cnt);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY_CNT, cnt);
        super.onSaveInstanceState(outState);
    }
}