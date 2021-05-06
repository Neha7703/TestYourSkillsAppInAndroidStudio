package com.example.testyourskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_c,btn_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_c=findViewById(R.id.button_c);
        btn_c.setOnClickListener(new clk());
        btn_p=findViewById(R.id.button_p);
        btn_p.setOnClickListener(new click());

    }

    class clk implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), QuestionC.class);
            startActivity(intent);
        }
    }
    class click implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), QuestionP.class);
            startActivity(intent);
        }
    }

}
