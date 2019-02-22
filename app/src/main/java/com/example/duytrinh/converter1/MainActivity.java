// Author: Khac Duy Trinh

package com.example.duytrinh.converter1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
	// Boolean flag to check if the convert mode is "USD to VND" or "VND to USD"
    boolean isUsd = true;	// By default, the convert mode is "USD to VND"
    boolean isVnd = false;
    TextView changeTV;
    TextView textView;
    EditText editText;
    RelativeLayout mainLayout;
    public void convert (View v) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
        float currency = Float.parseFloat(editText.getText().toString());
        float result = 0;
		
		// 1 USD dollar = 21.000 VND
        if(isUsd) {
            result = currency * 21000f;		
            textView.setText(Float.toString(result) + "Vnd");
        } else if(isVnd) {
            result = currency / 21000f;		// 
            textView.setText("$" + Float.toString(result));
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        changeTV = (TextView) findViewById(R.id.changeTextView);
        long usdF;
        long vndF;
        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
    }

    public void change(View view) {
        if(isUsd) {
            editText.setHint("Vnd");
            changeTV.setText("Vnd to Usd");
            isUsd = false;
            isVnd = true;
        } else if(isVnd) {
            isUsd = true;
            isVnd = false;
            changeTV.setText("Usd to Vnd");
            editText.setHint("Usd");
        }
    }
}
