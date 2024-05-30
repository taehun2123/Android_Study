package kr.ac.uc.opinionpoll;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgAnswer;

    RadioButton selectButton;
    Button btnSubmit;
    ImageView iv2_3_3, iv4_1, iv4_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        iv2_3_3 = findViewById(R.id.iv2_3_3);
        iv4_1 = findViewById(R.id.iv4_1);
        iv4_4 = findViewById(R.id.iv4_4);
        rgAnswer = findViewById(R.id.rgAnswer);
        btnSubmit = findViewById(R.id.btnSubmit);
        iv2_3_3.setImageResource(R.drawable.iv2_3_3);
        iv4_1.setImageResource(R.drawable.iv4_1);
        iv4_4.setImageResource(R.drawable.iv4_4);

        initImage();

        rgAnswer.setOnCheckedChangeListener(this::showImage);
        btnSubmit.setOnClickListener(this::submitOpinion);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void submitOpinion(View view) {
        int getRadioId = rgAnswer.getCheckedRadioButtonId();
        if(getRadioId == -1){
            Toast.makeText(this
                            , "반드시 하나의 의견은 선택해야합니다!"
                            , Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        selectButton = findViewById(rgAnswer.getCheckedRadioButtonId());

        Toast.makeText(this, "성공적으로 제출되었습니다! 제출 : " + selectButton.getText(), Toast.LENGTH_SHORT).show();
    }

    private void showImage(RadioGroup radioGroup, int i) {
        int select = radioGroup.getCheckedRadioButtonId();
        if(select == R.id.radioButton){
            iv2_3_3.setVisibility(View.VISIBLE);
            iv4_1.setVisibility(View.GONE);
            iv4_4.setVisibility(View.GONE);
        } else if(select == R.id.radioButton2) {
            iv2_3_3.setVisibility(View.GONE);
            iv4_1.setVisibility(View.VISIBLE);
            iv4_4.setVisibility(View.GONE);
        } else {
            iv2_3_3.setVisibility(View.GONE);
            iv4_1.setVisibility(View.GONE);
            iv4_4.setVisibility(View.VISIBLE);
        }
    }
    private void initImage(){
        iv2_3_3.setVisibility(View.GONE);
        iv4_1.setVisibility(View.GONE);
        iv4_4.setVisibility(View.GONE);
    }
}