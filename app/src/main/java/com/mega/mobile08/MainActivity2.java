package com.mega.mobile08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Chronometer chro;
    TimePicker timeP;
    CalendarView cal;
    Button btns, btne, day, time, next;

    String total, timetotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        chro = findViewById(R.id.chronometer2);
        timeP = findViewById(R.id.timePicker2);
        cal = findViewById(R.id.calendarView2);
        btns = findViewById(R.id.btns);
        btne = findViewById(R.id.btne);
        day = findViewById(R.id.day);
        time = findViewById(R.id.time);
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chro.setBase(SystemClock.elapsedRealtime());
                chro.start();
                chro.setTextColor(Color.CYAN);
            }
        });

        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chro.stop();
                chro.setTextColor(Color.RED);
            }
        });

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfmonth) {
                total = year + "년 " + (month + 1) + "월 " + dayOfmonth + "일";
            }
        });

        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("가지고온 날짜");
                alert.setMessage(total);
                alert.setPositiveButton("닫기",null);
                alert.show();

                    }

        });


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = timeP.getCurrentHour();
                int min = timeP.getCurrentMinute();
                timetotal = hour + "시 " + min + "분";
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("가지고온 날짜");
                alert.setMessage(timetotal);
                alert.setPositiveButton("닫기",null);
                alert.show();
            }
        });

    }

}