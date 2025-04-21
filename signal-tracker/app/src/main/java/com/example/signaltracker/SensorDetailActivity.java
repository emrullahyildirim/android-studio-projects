package com.example.signaltracker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SensorDetailActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView sensorValueText;
    private String sensorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_data);

        sensorValueText = findViewById(R.id.tvSensorValue);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sensorName = getIntent().getStringExtra("sensor_name");
        TextView sensorNameText = findViewById(R.id.sensor_name);
        if (sensorName != null) {
            setTitle(sensorName + " Sensor");
            sensorNameText.setText(sensorName + " Sensorü");
        } else {
            sensorNameText.setText("Bilinmeyen Sensör");
            sensorValueText.setText("Sensör ismi alınamadı!");
            return;
        }
        sensorName = getIntent().getStringExtra("sensor_name");
        setTitle(sensorName + " Sensor");

        if (sensorName == null) {
            sensorValueText.setText("Sensör ismi alınamadı!");
            return;
        }

        switch (sensorName) {
            case "Accelerometer":
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                break;
            case "Gyroscope":
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
                break;
            case "Compass":
            case "Magnometer":
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
                break;
            case "Humidity":
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
                break;
            case "Light":
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
                break;
            case "Pressure":
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
                break;
            case "Proximity":
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
                break;
            case "Thermometer":
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
                break;
            default:
                sensorValueText.setText("Bilinmeyen sensör tipi");
                return;
        }

        if (sensor == null) {
            sensorValueText.setText("Bu sensör cihazda bulunamadı.");
        }

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (sensor != null) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        StringBuilder sb = new StringBuilder("Değerler:\n");
        for (float value : event.values) {
            sb.append(String.format("%.2f\n", value));
        }
        sensorValueText.setText(sb.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
