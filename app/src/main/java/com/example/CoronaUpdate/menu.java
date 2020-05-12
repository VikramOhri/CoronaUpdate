package com.example.CoronaUpdate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public static final String msg="covid";

    public void covid(View v){
        Intent intent=new Intent(menu.this,covid.class);
        intent.putExtra(msg,"covid");
        startActivity(intent);
    }


    public void world(View v){
        Intent intent=new Intent(menu.this,World.class);
        startActivity(intent);
    }


    public void country(View v){
        Intent intent=new Intent(menu.this,name.class);
        startActivity(intent);
    }


    public void prev(View v){
        Intent intent=new Intent(menu.this,covid.class);
        intent.putExtra(msg,"prev");
        startActivity(intent);

    }


    public void myths(View v){

        Intent intent=new Intent(menu.this,covid.class);
        intent.putExtra(msg,"myths");
        startActivity(intent);

    }
}
