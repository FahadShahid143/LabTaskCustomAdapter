package com.example.fahadshahid.customadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button start;
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        start = (Button) findViewById(R.id.btnStartService);
        stop = (Button) findViewById(R.id.btnStopService);

        final Intent intent = new Intent(Main2Activity.this, MyService.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopService(intent);
            }
        });



        //startService(new Intent(getBaseContext(), MyService.class));
    }
}
