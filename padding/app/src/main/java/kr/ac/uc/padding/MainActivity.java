package kr.ac.uc.padding;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "DEBUGGING";
    Button btn1, btn2, btn3;
    TextView tv1, tv2, tv3;

    MyClickListener myClickListener = new MyClickListener();
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
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        btn1.setOnClickListener(myClickListener);
        btn2.setOnClickListener(myClickListener);
        btn3.setOnClickListener(myClickListener);






    }

    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            tv1.setVisibility(View.INVISIBLE);
            tv2.setVisibility(View.INVISIBLE);
            tv3.setVisibility(View.INVISIBLE);

            if(v.getId() == R.id.btn1){
                tv1.setVisibility(View.VISIBLE);
            } else if(v.getId() == R.id.btn2) {
                tv2.setVisibility(View.VISIBLE);
            } else {
                tv3.setVisibility(View.VISIBLE);
            }
//            Button btn = (Button) v; comment out
//            //logd
//            Log.d(TAG, "onClick: " +btn.getText());
        }
    }
}