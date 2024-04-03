package kr.ac.uc.eventpractice;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnRed, btnGreen, btnBlue;

    ImageView ivImage;

    BtnColorClickListener btnColorClickListener = new BtnColorClickListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);
        ivImage = findViewById(R.id.ivImage);
        btnBlue.setOnClickListener(btnColorClickListener);
        btnRed.setOnClickListener(btnColorClickListener);
        btnGreen.setOnClickListener(v -> ivImage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green)));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    class BtnColorClickListener implements View.OnClickListener {

        @SuppressLint("UseCompatLoadingForDrawables")
        @Override
        public void onClick(View v) {
//            v.getId(); // 클릭된 뷰의 아이디 값
            if (v.getId() == R.id.btnBlue) {
                ivImage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
            }
            if (v.getId() == R.id.btnRed) {
                ivImage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
            }
        }

    }
}