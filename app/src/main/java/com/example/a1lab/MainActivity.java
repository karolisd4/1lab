package com.example.a1lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

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

        int[] textColors = {
                ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.blue),
                ContextCompat.getColor(this, R.color.purple)
        };

        int[] bgColors = {
                ContextCompat.getColor(this, R.color.yellow),
                ContextCompat.getColor(this, R.color.orange),
                ContextCompat.getColor(this, R.color.cyan)
        };

        Button textButton = findViewById(R.id.tekstoKnopke);
        Button colorButton = findViewById(R.id.spalvosKnopke);
        Button bgButton = findViewById(R.id.fonoKnopke);
        TextView textView = findViewById(R.id.manoTekstas);

        final int[] colorIndex = {0};
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTextColor(textColors[colorIndex[0]]);
                colorIndex[0] = (colorIndex[0] + 1) % textColors.length;
            }
        });

        final int[] bgIndex = {0};
        bgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setBackgroundColor(bgColors[bgIndex[0]]);
                bgIndex[0] = (bgIndex[0] + 1) % bgColors.length;
            }
        });

        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getVisibility() == View.VISIBLE) {
                    textView.setVisibility(View.GONE);
                } else {
                    textView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}