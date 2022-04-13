package com.hit.wizewalletapp.Activities.Parent_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.hit.wizewalletapp.Activities.Child_Activities.ChildBalanceScreen;
import com.hit.wizewalletapp.R;

public class ParentTasksScreen extends AppCompatActivity {


    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_parent_screen);

        backArrow = findViewById(R.id.topuparrow);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParentTasksScreen.this, ChildBalanceScreen.class);
                startActivity(intent);
            }
        });
    }


}