package com.example.juzamma;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView textDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //tanggal today
        textDate = findViewById(R.id.dateDisplay);
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                @SuppressLint("SimpleDateFormat")

                DateFormat dateFormat = new SimpleDateFormat("EEE,dd MMM yyy");

                textDate.setText(dateFormat.format(new Date()));

                //interval
                handler.postDelayed(this, 1000);

            }
        });
        //end tanggal



    }
}