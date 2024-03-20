package com.example.vscontractorcalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private EditText laborCntEditText;
    private EditText materialsCntEditText;
    private Button calculateButton;
    private TextView readonlyOutputSubTotal;
    private TextView readonlyOutputTax;
    private TextView readonlyOutputTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        laborCntEditText = findViewById(R.id.laborCntEditText);
        materialsCntEditText = findViewById(R.id.materialsCntEditText);
        calculateButton = findViewById(R.id.calculateButton);
        readonlyOutputSubTotal = findViewById(R.id.readonlyOutputSubTotal);
        readonlyOutputTax = findViewById(R.id.readonlyOutputTax);
        readonlyOutputTotal = findViewById(R.id.readonlyOutputTotal);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double taxPercent = 0.05;
                String laborCnt = laborCntEditText.getText().toString();
                String materialCnt = materialsCntEditText.getText().toString();
                double subTotal = (Double.parseDouble(laborCnt) + Double.parseDouble(materialCnt));
                double calculatedTax = (subTotal*taxPercent);
                double calculatedTotal = (subTotal + calculatedTax);
                String outputStr = String.format("%.2f", subTotal);
                String taxStr = String.format("%.2f", calculatedTax);
                String totalStr = String.format("%.2f", calculatedTotal);
                readonlyOutputSubTotal.setText(outputStr);
                readonlyOutputTax.setText(taxStr);
                readonlyOutputTotal.setText(totalStr);
            }
        });



    }
}