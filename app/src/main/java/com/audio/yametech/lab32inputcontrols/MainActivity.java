package com.audio.yametech.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox) findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView) findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void buttonCalculate(View view){
        int pos, gender, age, premium = 0;
        pos = spinnerAge.getSelectedItemPosition();
        gender = radioGroupGender.getCheckedRadioButtonId();
        switch(pos){
            case 0:
                premium+=50;
                break;
            case 1:
                premium+=55;
                break;
            case 2:
                premium+=60;
                break;
            case 3:
                premium+=70;
                break;
            case 4:
                premium+=120;
                break;
            case 5:
                premium+=160;
                break;
            case 6:
                premium+=200;
                break;
            case 7:
                premium+=250;
                break;
        }
        if(gender == R.id.radioButtonMale){
            switch(pos){
                case 2:
                    premium+=50;
                    break;
                case 3:
                    premium+=100;
                    break;
                case 4:
                    premium+=100;
                    break;
                case 5:
                    premium+=50;
                    break;
            }

        }
        if(checkBoxSmoker.isChecked()){
            switch(pos){
                case 3:
                    premium+=100;
                    break;
                case 4:
                    premium+=150;
                    break;
                case 5:
                    premium+=150;
                    break;
                case 6:
                    premium+=250;
                    break;
                case 7:
                    premium+=250;
                    break;
            }
        }
        textViewPremium.setText(getString(R.string.premium)+String.valueOf(premium));
    }
    public void buttonReset(View view){
        spinnerAge.setSelection(0);
        radioButtonMale.setChecked(true);
        radioButtonFemale.setChecked(false);
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText(getString(R.string.premium));
    }

}
