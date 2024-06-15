package com.example.myapplicationforsensors

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.ListView
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

        val listView: ListView = findViewById(R.id.listView)

        val sensorManager: SensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorList: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        val sensorDetailsList: MutableList<SensorDetails> = mutableListOf()
        for (sensor in sensorList) {
            sensorDetailsList.add(
                SensorDetails(
                    sensor.name,
                    sensor.vendor,
                    sensor.version,
                    sensor.type
                )
            )
        }

        val adapter = SendorAdapter(this, R.layout.item_view, sensorDetailsList)
        listView.adapter = adapter
    }
}