package com.example.sharedpreferences_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.emailin);

        SharedPreferences sh = getSharedPreferences("data" , Context.MODE_PRIVATE);
        input.setText(sh.getString("mail", ""));
    }

    public void saveData (View view){
        SharedPreferences sh = getSharedPreferences("data" , Context.MODE_PRIVATE);
        SharedPreferences.Editor she = sh.edit();
        she.putString("mail" , input.getText().toString());
        she.commit();
        //Closes application once the input is saved
        finish();
    }
}