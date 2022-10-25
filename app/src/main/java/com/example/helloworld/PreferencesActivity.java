package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        //このアプリの情報を保存するファイル
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);

        //画面のパーツを宣言
        EditText thoughtsText = findViewById(R.id.thoughtsText_1);
        Button saveBt = findViewById(R.id.saveButton);
        Button cancelBt = findViewById(R.id.cancelButton);
        Button resetBt = findViewById(R.id.resetButton);
        //カレーごとにブリファレンスを分ける
        String menu[] = {"dry","cutlet","cheese","soup","memo"};

        //前画面からの情報を受け取る
        Intent intent = getIntent();
        int curry = intent.getIntExtra("curry",4);

        //String thoughtsText_1 = pref.getString("memo","");
        String thoughtsText_1 = pref.getString(menu[curry],"");
        thoughtsText.setText(thoughtsText_1);

        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(menu[curry],thoughtsText.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(), "保存しました", Toast.LENGTH_SHORT).show();
            }
        });
        cancelBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
           //     Toast.makeText(getApplicationContext(), "終了します", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        resetBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("memo",null);
                editor.apply();
            //    Toast.makeText(getApplicationContext(), "リセットしました", Toast.LENGTH_SHORT).show();

                //thoughtsText.setText();
            }
        });
    }
}