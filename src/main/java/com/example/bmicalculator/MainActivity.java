package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.icu.text.DecimalFormat;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod(){
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView height = (TextView)findViewById(R.id.height);
                TextView weight = (TextView)findViewById(R.id.weight);
                TextView result = (TextView)findViewById(R.id.result);
                double h = Double.valueOf(height.getText().toString());
                double w = Double.valueOf(weight.getText().toString());

                double BMI = w/(h*h);

                result.setText(String.valueOf(BMI).substring(0,4));
                String BMI_Cat ="";

                if (BMI < 15)
                    BMI_Cat = "Very severely underweight";
                else if (BMI < 16)
                    BMI_Cat = "Severely underweight";
                else if (BMI < 18.5) {
                    BMI_Cat = "Underweight";
                }
                else if (BMI < 25) {
                    BMI_Cat = "Normal";
                }
                else if (BMI < 30) {
                    BMI_Cat = "Overweight";
                }
                else if (BMI < 35) {
                    BMI_Cat = "Obese Class 1 – Moderately Obese";
                }
                else if (BMI < 40) {
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                }
                else {
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";
                }final TextView BMICategory = (TextView)
                            findViewById(R.id.BMICategory);
                    BMICategory.setText(BMI_Cat);


            }
        });
    }
}
