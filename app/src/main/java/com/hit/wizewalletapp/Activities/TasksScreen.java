package com.hit.wizewalletapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hit.wizewalletapp.R;

public class TasksScreen extends AppCompatActivity {


    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_screen);

        backArrow = findViewById(R.id.topuparrow);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TasksScreen.this, ChildBalanceScreen.class);
                startActivity(intent);
            }
        });
    }


}