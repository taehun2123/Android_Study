package kr.ac.uc.extra_data_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_INT_DATA = "int_data";
    public static final String KEY_DOUBLE_DATA = "double_data";
    public static final String KEY_STRING_DATA = "string_data";
    public static final String TAG = "DEBUGGING...";

    EditText etInt, etDouble, etString;
    Button btnSubmit;

    ActivityResultLauncher<Intent> launcher;
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

        etInt = findViewById(R.id.etInt);
        etDouble = findViewById(R.id.etDouble);
        etString = findViewById(R.id.etString);
        btnSubmit = findViewById(R.id.btnSubmit);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        assert data != null;
                        Log.d(TAG, "OK - " + data.getStringExtra(SecondActivity.KEY_RESULT));
                    } else {
                        Log.d(TAG, "onActivity : Canceled..!");
                    }
                });

        btnSubmit.setOnClickListener(this::moveToSecond);

    }

    private void moveToSecond(View view) {
        try {
            int myInt = Integer.parseInt(etInt.getText().toString());
            double myDouble = Double.parseDouble(etDouble.getText().toString());
            String myString = etString.getText().toString();
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(KEY_INT_DATA, myInt);
            intent.putExtra(KEY_DOUBLE_DATA, myDouble);
            intent.putExtra(KEY_STRING_DATA, myString);
            launcher.launch(intent);
        } catch(NumberFormatException e){
        }
    }
}