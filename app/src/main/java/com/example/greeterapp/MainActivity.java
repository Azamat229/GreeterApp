package com.example.greeterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnClickHere;
    TextView textName;
    String name ="undefined";

    final static String nameVariableKey = "NAME_VARIABLE";
    final static String textViewTexKey = "TEXTVIEW_TEXT";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        editText = (EditText) findViewById(R.id.myEditText);
        textName = (TextView) findViewById(R.id.myTextName);
        btnClickHere = (Button) findViewById(R.id.myButton);

        btnClickHere.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                textName.setText("Hello, " + name);
            }
        });

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("count");
            textName.setText(String.valueOf("Hello, " + name));
        }
    }

    // сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(nameVariableKey, name);
        TextView nameView = (TextView) findViewById(R.id.myTextName);
        outState.putString(textViewTexKey, nameView.getText().toString());

        super.onSaveInstanceState(outState);
    }
    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        name = savedInstanceState.getString(nameVariableKey);
        String textViewText= savedInstanceState.getString(textViewTexKey);
        TextView nameView = (TextView) findViewById(R.id.myTextName);
        nameView.setText(textViewText);
    }


}
