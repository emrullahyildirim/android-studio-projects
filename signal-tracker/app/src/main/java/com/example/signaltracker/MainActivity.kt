package com.example.signaltracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupButton(R.id.btn_accelerometer, "Accelerometer")
        setupButton(R.id.btn_compass, "Compass")
        setupButton(R.id.btn_gyroscope, "Gyroscope")
        setupButton(R.id.btn_humidity, "Humidity")
        setupButton(R.id.btn_light, "Light")
        setupButton(R.id.btn_magnometer, "Magnometer")
        setupButton(R.id.btn_pressure, "Pressure")
        setupButton(R.id.id_proximity, "Proximity")
        setupButton(R.id.btn_thermometer, "Thermometer")
    }

    private fun setupButton(buttonId: Int, sensorName: String) {
        findViewById<Button>(buttonId)?.setOnClickListener {
            val intent = Intent(this, SensorDetailActivity::class.java)
            intent.putExtra("sensor_name", sensorName)
            startActivity(intent)
        }
    }
}
