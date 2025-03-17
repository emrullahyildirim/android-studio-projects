package com.example.herhangibirproje;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText input_num1 = findViewById(R.id.input_num1);
        EditText input_num2 = findViewById(R.id.input_num2);
        Button btn_random = findViewById(R.id.btn_random);
        Button btn_faktoriyel = findViewById(R.id.btn_faktoriyel);
        TextView textRandom = findViewById(R.id.text_random);
        TextView textResult = findViewById(R.id.text_result);

        btn_random.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                int num1 = Integer.parseInt(input_num1.getText().toString());
                int num2 = Integer.parseInt(input_num2.getText().toString());
                if (num1 > num2) {
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                Random random = new Random();
                int randomNum = random.nextInt((num2 - num1) + 1) + num1;
                textRandom.setText(String.valueOf(randomNum));
            }
        });
        btn_faktoriyel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                int num = Integer.parseInt(textRandom.getText().toString());
                int result = 1;
                for (int i = 1; i <= num; i++) {
                    result *= i;
                }
                textResult.setText(String.valueOf(result));
            }
        });
    }
}
