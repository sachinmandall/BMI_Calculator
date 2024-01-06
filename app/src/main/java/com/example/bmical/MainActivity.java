package com.example.bmical;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variable assignments (it can be anything you want, corresponding to the IDs of the respective widgets)
        EditText weight, Heightft, Heightcm;
        Button btn;
        TextView text_result;
        LinearLayout linearLayout;

        weight = findViewById(R.id.weight);
        Heightft = findViewById(R.id.Heightft);
        Heightcm = findViewById(R.id.Heightcm);
        btn = findViewById(R.id.btn);
        text_result = findViewById(R.id.text_result); // Corrected this line
        linearLayout=findViewById(R.id.lllayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(weight.getText().toString());
                int ft = Integer.parseInt(Heightft.getText().toString());
                int in = Integer.parseInt(Heightcm.getText().toString());


                // The formula for converting inches to centimeters is not accurate; it should be multiplied by 2.54
                // Conversion factor of 12:
                int Totalin = ft * 12 + in;

                // 1 inch = 2.54 meters
                double Totalcm = Totalin * 2.54;
                double Totalmtr = Totalcm / 100;

                double bmi = wt / (Totalmtr * Totalmtr);

                if (bmi > 25) {
                    text_result.setText("You Are Overweight");
                   linearLayout.setBackgroundColor(getResources().getColor(R.color.ov));

                } else if (bmi < 18) {
                    text_result.setText("You Are Underweight");
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.uw));
                } else {
                    text_result.setText("You Are Healthy");
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.h));
                }
            }
        });
    }
}
