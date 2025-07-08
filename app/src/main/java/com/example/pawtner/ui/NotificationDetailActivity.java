package com.example.pawtner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pawtner.R;


public class NotificationDetailActivity extends AppCompatActivity {

    TextView titleText, messageText, dateTimeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_detail);

        titleText = findViewById(R.id.detail_title);
        messageText = findViewById(R.id.detail_message);
        dateTimeText = findViewById(R.id.detail_date_time);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String message = intent.getStringExtra("message");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        titleText.setText(title);
        messageText.setText(message);
        dateTimeText.setText(date + " • " + time);

        findViewById(R.id.backButton).setOnClickListener(v -> finish());
    }
}
