package kr.ac.uc.todolist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etTodo;
    Button btnAdd;

    LinearLayout panel;

    CheckBox todo;
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

        etTodo = findViewById(R.id.etTodo);
        btnAdd = findViewById(R.id.btnAdd);
        panel = findViewById(R.id.createCheckBoxPanel);
        
        btnAdd.setOnClickListener(this::createTodoList);

    }

    private void doneTodo(CompoundButton compoundButton, boolean b) {
        if(compoundButton.isChecked()) {
            compoundButton.setTextColor(compoundButton.getResources().getColor(R.color.red));
        } else {
            compoundButton.setTextColor(compoundButton.getResources().getColor(R.color.black));
        }
    }

    private void createTodoList(View view) {
        String buttonText = etTodo.getText().toString();
        if(!buttonText.isEmpty()) {
            todo = new CheckBox(MainActivity.this);
            panel.addView(todo);
            todo.setText(etTodo.getText());
            etTodo.setText("");
            todo.setOnCheckedChangeListener(this::doneTodo);
        } else {
            Toast.makeText(this, "할 일을 작성 후 추가해 주세요!", Toast.LENGTH_SHORT).show();
        }

    }


}