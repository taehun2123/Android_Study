package kr.ac.uc.ratingbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgSelect;

    ImageView iv1, iv2, iv3, iv4;
    RatingBar ratingBar;
    Button btnSubmit;
    TextView tvRate, tvRateItem1, tvRateItem2, tvRateItem3, tvRateItem4;

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

        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv4 = findViewById(R.id.iv4);
        iv1.setImageResource(R.drawable.image1);
        iv2.setImageResource(R.drawable.image2);
        iv3.setImageResource(R.drawable.image3);
        iv4.setImageResource(R.drawable.image4);


        rgSelect = findViewById(R.id.rgSelect);
        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvRate = findViewById(R.id.tvRate);
        tvRateItem1 = findViewById(R.id.tvRateItem1);
        tvRateItem2 = findViewById(R.id.tvRateItem2);
        tvRateItem3 = findViewById(R.id.tvRateItem3);
        tvRateItem4 = findViewById(R.id.tvRateItem4);

        RadioButton radioButton = findViewById(R.id.radioButton);
        radioButton.setChecked(true);
        setOnVisible(iv1);

        rgSelect.setOnCheckedChangeListener(this::showImage);
        btnSubmit.setOnClickListener(v->submitRate());
    }

    private void showImage(RadioGroup radioGroup, int i) {
        int selectRadio = radioGroup.getCheckedRadioButtonId();
        if(selectRadio == -1){
            Toast.makeText(this, "반드시 하나의 작품을 선택 해야 합니다!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(selectRadio == R.id.radioButton){
            setOnVisible(iv1);
        } else if(selectRadio == R.id.radioButton2){
            setOnVisible(iv2);
        } else if(selectRadio == R.id.radioButton3){
            setOnVisible(iv3);
        } else{
            setOnVisible(iv4);
        }
    }

    private void submitRate() {
        if(ratingBar.getRating() == 0.0){
            Toast.makeText(this,"별점은 반드시 0.5점부터 시작해야 합니다!", Toast.LENGTH_SHORT).show();
            return;
        }
        tvRate.setText("점수 : " + ratingBar.getRating() + "점");

        int selectRadio = rgSelect.getCheckedRadioButtonId();
        if(selectRadio == -1){
            Toast.makeText(this, "반드시 하나의 작품을 선택 해야 합니다!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(selectRadio == R.id.radioButton){
            tvRateItem1.setText("1번 작품 : " + ratingBar.getRating());
        } else if(selectRadio == R.id.radioButton2){
            tvRateItem2.setText("2번 작품 : " + ratingBar.getRating());
        } else if(selectRadio == R.id.radioButton3){
            tvRateItem3.setText("3번 작품 : " + ratingBar.getRating());
        } else{
            tvRateItem4.setText("4번 작품 : " + ratingBar.getRating());
        }
    }

    private void setOnVisible(ImageView id){
        if(id == iv1){
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.GONE);
            iv3.setVisibility(View.GONE);
            iv4.setVisibility(View.GONE);
        } else if(id == iv2){
            iv1.setVisibility(View.GONE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.GONE);
            iv4.setVisibility(View.GONE);
        } else if(id == iv3){
            iv1.setVisibility(View.GONE);
            iv2.setVisibility(View.GONE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.GONE);
        } else {
            iv1.setVisibility(View.GONE);
            iv2.setVisibility(View.GONE);
            iv3.setVisibility(View.GONE);
            iv4.setVisibility(View.VISIBLE);
        }
    }


}