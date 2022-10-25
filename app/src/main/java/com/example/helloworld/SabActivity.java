package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SabActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //    setContentView(R.layout.activity_sab);
        setContentView(R.layout.activity_const);

        //    setContentView(R.layout.activity_const2);
        //   setTitle("Sub Activity");
        //画面上のパーツ宣言
        TextView nameLabel = findViewById(R.id.nameLabel);
        EditText nameText = findViewById(R.id.nameText2);
        Button clearBotton = findViewById(R.id.clearButton);
        Button confirmButton = findViewById(R.id.confirmButton);
        Button sendButton = findViewById(R.id.sendButto);

        nameLabel.setText("Name");

        sendButton.setOnClickListener(this);
        confirmButton.setOnClickListener(this);

        clearBotton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                nameText.setText("");
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, EventActivity.class);

        setTitle("Botton Clicked");

        switch (view.getId()) {
            case R.id.confirmButton:
                setTitle("確認Botton Clicked");
                Toast.makeText(this, "確認クリック", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sendButto:
                setTitle("送信Botton Clicked");
                Toast.makeText(this, "送信クリック", Toast.LENGTH_SHORT).show();
                //intent.putExtra("age",19);
                startActivity(intent);
                break;
        }
    }
}




