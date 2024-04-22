package kr.ac.uc.tempconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnConvert;
    EditText etInput;
    RadioButton btnF, btnC;
    RadioGroup rgUnit;

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

        btnConvert = findViewById(R.id.btnConvert);
        etInput = findViewById(R.id.etInput);
        btnF = findViewById(R.id.btnF);
        btnC = findViewById(R.id.btnC);

        rgUnit.findViewById(R.id.rgUnit);



        btnConvert.setOnClickListener(v-> {
            try {
                Float prevTemp = Float.parseFloat(String.valueOf(etInput.getText()));

//                if (btnC.isChecked()) {
//                    etInput.setText(String.valueOf(convertFToC(prevTemp)));
//                    btnC.setChecked(false);
//                    btnF.setChecked(true);
//                } else {
//                    etInput.setText(String.valueOf(convertCToF(prevTemp)));
//                    btnC.setChecked(true);
//                    btnF.setChecked(false);
//                }
                int unitId = rgUnit.getCheckedRadioButtonId();

                if(unitId == -1){
                    Toast.makeText(this, "선택해야합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(unitId == btnC.getId()){
                    etInput.setText(String.valueOf(convertFToC(prevTemp)));
                    btnC.setChecked(false);
                    btnF.setChecked(true);
                } else {
                    etInput.setText(String.valueOf(convertCToF(prevTemp)));
                    btnF.setChecked(false);
                    btnC.setChecked(true);
                }

            } catch(NumberFormatException e){
                Toast.makeText(this, "숫자 값만 입력이 가능합니다.", Toast.LENGTH_SHORT).show();
            } catch (Exception e ) {
                Toast.makeText(this, "알 수 없는 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    };
    private Float convertFToC(Float f){
        return (float) ((f-32) * 5 / 9.0);
    }

    private Float convertCToF(Float c){
        return (float) (((c * 9) / 5) +32.0);
    }
    }