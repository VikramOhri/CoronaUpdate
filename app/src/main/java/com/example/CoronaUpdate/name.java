package com.example.CoronaUpdate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public void jeet(View v){
        Intent intent=new Intent(name.this,country.class);

        EditText msg=findViewById(R.id.country);
        String country=msg.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, country);
        startActivity(intent);
        finish();

    }
    public void back(View v){
        finish();
    }
}
