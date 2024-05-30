package kr.ac.uc.dicee;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "DEBUGGING";
    Button btnRoll;
    ImageView ivLeft, ivRight;
    final int[] arrDice = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnRoll = findViewById(R.id.btnRoll);
        ivLeft = findViewById(R.id.ivLeft);
        ivRight = findViewById(R.id.ivRight);

        btnRoll.setOnClickListener(v -> {
            // 우선 랜덤값을 가져 옵시다.. 1 부터 6까지..
            Log.d(TAG, "onCreate: "+new Random().nextInt(6));
            ivLeft.setImageResource(arrDice[new Random().nextInt(6)]);
            ivRight.setImageResource(arrDice[new Random().nextInt(6)]);
            // 아주 쉬운 과제입니다.
            // 오른쪽 주사위도 랜덤 값에 따라 맞는 이미지 ( 0 이면 1 주사위, 5 이면 6 주사위 ) 가 나타나도록 코드를 완성하세요.
            // 왼쪽 주사위와 오른쪽 주사위는 다른 랜덤값에 의해서 출력이 되어야 합니다.

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}