package kr.ac.uc.view_practice_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button btnGen;
    Button btnRst;
    TextView tvResult;
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
        btnGen = findViewById(R.id.btnGen);
        btnRst = findViewById(R.id.btnRst);
        tvResult = findViewById(R.id.tvResult);
        btnGen.setOnClickListener(v -> tvResult.setText("난수 : " + new Random().nextInt(100))); //anonymous Class & Ramda
        btnRst.setOnClickListener(v -> tvResult.setText("난수 : " + 0));
    }





}