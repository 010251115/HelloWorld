package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        //呼び元画面から送られてきたintent情報を入手
        Intent intent = getIntent();
        int age = intent.getIntExtra("age",25);
        //確認
        Toast.makeText(this,"年齢" + age, Toast.LENGTH_SHORT).show();

        //画面のパーツを登録
        TextView textProfile = findViewById(R.id.textProfile);
        EditText nameText = findViewById(R.id.nameText_2);
        EditText passText = findViewById(R.id.passsText);
        Button clear1 = findViewById(R.id.clear1);
        Button clear2 = findViewById(R.id.clear2);
        CheckBox check10 = findViewById(R.id.check10);
        CheckBox check20 = findViewById(R.id.check20);
        CheckBox check30 = findViewById(R.id.check30);
        RadioButton radioOtoko = findViewById(R.id.radioOtoko);
        RadioButton radioOnna = findViewById(R.id.radioOnna);
        Button kakunin = findViewById(R.id.kakunin);

        clear1.setOnClickListener(this);
        clear2.setOnClickListener(this);
        kakunin.setOnClickListener(this);

        clear2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setTitle(passText.getText());
                return false;
            }
        });

        kakunin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (radioOtoko.isChecked() == true){
                    Toast.makeText(getApplicationContext(), R.string.man, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), R.string.woman, Toast.LENGTH_SHORT).show();
                }
                finish();  //画面消える
                return false;
            }
        });

    }

    @Override
    public void onClick(View view) {
        EditText nameText = findViewById(R.id.nameText_2);
        EditText passText = findViewById(R.id.passsText);
        switch (view.getId()) {
            case R.id.clear1:  //名前
                nameText.setText("");
                break;
            case R.id.clear2:
                passText.setText("");
                setTitle(R.string.app_name);
                break;
            case R.id.kakunin:
                Toast.makeText(this, nameText.getText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
