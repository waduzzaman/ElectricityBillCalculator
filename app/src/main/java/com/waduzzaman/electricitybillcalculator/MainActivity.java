package com.waduzzaman.electricitybillcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edText;
    Button btnCal;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText=findViewById(R.id.edText);
        btnCal=findViewById(R.id.btnCal);
        tvResult=findViewById(R.id.tvResult);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sUnit=edText.getText().toString();
                float unit=Float.parseFloat(sUnit);
                float bill=0;


                if (unit<=50){
                    bill= (float) (unit*0.50);            
                } else if (unit<=150) {
                    bill= (float) (25+(unit-50)*0.75);
                } else if (unit<=250) {
                    bill= (float) (25+75+(unit-150*0.120));
                } else {
                    bill= (float) (25+75+120+(unit-250)*1.50);
                }
                bill= (float) (bill+bill*0.20);
                tvResult.setText("Total Eelectricy Bill = $"+bill);


            }
        });
    }
}