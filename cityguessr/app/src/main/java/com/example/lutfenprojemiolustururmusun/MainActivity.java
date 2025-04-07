package com.example.lutfenprojemiolustururmusun;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public int     red_val = 0;
    public int     green_val = 0;
    public int     blue_val = 0;

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
        SeekBar sb_red = (SeekBar) findViewById(R.id.sb_red);
        SeekBar sb_green = (SeekBar) findViewById(R.id.sb_green);
        SeekBar sb_blue = (SeekBar) findViewById(R.id.sb_blue);

        TextView text_red = (TextView) findViewById(R.id.tw_red);
        TextView text_green = (TextView) findViewById(R.id.tw_green);
        TextView text_blue = (TextView) findViewById(R.id.tw_blue);

        ConstraintLayout bgColor = (ConstraintLayout) findViewById(R.id.layout);


        sb_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_red.setMax(255);
                text_red.setText("Red: " + String.valueOf(progress));
                red_val = progress;
                int val = android.graphics.Color.rgb(red_val, green_val, blue_val);
                bgColor.setBackgroundColor(val);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        sb_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_green.setMax(255);
                text_green.setText("Green: " + String.valueOf(progress));
                green_val = progress;
                int val = android.graphics.Color.rgb(red_val, green_val, blue_val);
                bgColor.setBackgroundColor(val);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb_blue.setMax(255);
                text_blue.setText("Blue: " + String.valueOf(progress));
                blue_val = progress;
                int val = android.graphics.Color.rgb(red_val, green_val, blue_val);
                bgColor.setBackgroundColor(val);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}