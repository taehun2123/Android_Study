package kr.ac.uc.implicit_intent_test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnDial,btnWeb,btnMap,btnContact;

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

        btnDial = findViewById(R.id.btnDial);
        btnContact = findViewById(R.id.btnContact);
        btnMap = findViewById(R.id.btnMap);
        btnWeb = findViewById(R.id.btnWeb);

        btnDial.setOnClickListener(this::moveNext);
        btnContact.setOnClickListener(this::moveNext);
        btnMap.setOnClickListener(this::moveNext);
        btnWeb.setOnClickListener(this::moveNext);

    }
    private void moveNext(View v){
        int id = v.getId();
        Intent intent = null;
        if(id == R.id.btnDial){
            intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:010-3343-8636"));
        }
        if(id == R.id.btnContact){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
        }
        if(id == R.id.btnWeb){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com/"));
        }
        if(id == R.id.btnMap){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:27.30,127.2?z=10"));
        }
        startActivity(intent);
    }
}