package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText forNamn,efterNamn, telNR, mailAdress;
    Button btnRead,btnWrite;
    TextView viewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forNamn = findViewById(R.id.fornamn);
        efterNamn = findViewById(R.id.efternamn);
        telNR = findViewById(R.id.telnr);
        mailAdress = findViewById(R.id.mailadress);
        btnRead = findViewById(R.id.btn_read);
        btnWrite = findViewById(R.id.btn_write);
        viewAll = findViewById(R.id.viewAll);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BTN", "btn read clicked");
            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BTN", "btn write clicked");

            }
        });
    }
}
