package kr.ac.uc.danguen_clone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView[] ivReview;
    RatingBar rb;
    Button btnReset, btnSubmit;
    EditText etReview;
    CheckBox[] cb;

    LinearLayout listPanel;

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

        ivReview = new ImageView[]{
                findViewById(R.id.ivBad),
                findViewById(R.id.ivNotBad),
                findViewById(R.id.ivSoso),
                findViewById(R.id.ivGood),
                findViewById(R.id.ivLove)
        };

        ivReview[0].setImageResource(R.drawable.bad);
        ivReview[1].setImageResource(R.drawable.notbad);
        ivReview[2].setImageResource(R.drawable.soso);
        ivReview[3].setImageResource(R.drawable.good);
        ivReview[4].setImageResource(R.drawable.love);


        rb = findViewById(R.id.rb);
        btnReset = findViewById(R.id.btnReset);
        btnSubmit = findViewById(R.id.btnSubmit);
        etReview = findViewById(R.id.etReview);
        cb = new CheckBox[]{
                findViewById(R.id.cbSame),
                findViewById(R.id.cbSpeed),
                findViewById(R.id.cbTime),
                findViewById(R.id.cbGood)
        };
        listPanel = findViewById(R.id.listPanel);

        initImage(); // 이미지 초기화


        rb.setOnRatingBarChangeListener(this::changeImageForRatingbar);
        btnSubmit.setOnClickListener(this::submitReview);
        btnReset.setOnClickListener(this::resetItems);

    }

    private void resetItems(View view) {
        for(CheckBox check: cb){
            check.setChecked(false);
        }
        etReview.setText("");
        rb.setRating(0);
        listPanel.removeAllViews();
    }

    private void resetInner(View view){
        for(CheckBox check: cb){
            check.setChecked(false);
        }
        etReview.setText("");
        rb.setRating(0);
    }

    private void submitReview(View view) {
        LinearLayout list = new LinearLayout(MainActivity.this);
        TextView star = new TextView(MainActivity.this);
        TextView listReview = new TextView(MainActivity.this);
        TextView review = new TextView(MainActivity.this);

        listPanel.addView(list);

        list.setOrientation(LinearLayout.VERTICAL);
        list.addView(star);
        list.addView(listReview);
        list.addView(review);

        String starRating = "";
        for(int i = 0; i<(int)rb.getRating(); i++){
            starRating += "\uD83D\uDC9B";
        }

        String listReviewString = "";
        star.setText(starRating);
        for(CheckBox check:cb){
            listReviewString += check.isChecked() ? check.getText() + "\n" : "";
        }
        listReview.setText(listReviewString);
        review.setText(etReview.getText() + "\n");

        resetInner(view);
    }

    private void initImage(){
        for(ImageView iv: ivReview)
            iv.setVisibility(View.GONE);
    }

    private void changeImageForRatingbar(RatingBar ratingBar, float v, boolean b) {
            int rating = (int) rb.getRating();
            for (int i = 0; i < ivReview.length; i++) {
                if ((rating - 1) == i)
                    ivReview[i].setVisibility(View.VISIBLE);
                else
                    ivReview[i].setVisibility(View.GONE);
            }
        }
    }

