package com.example.CoronaUpdate;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;

public class country extends AppCompatActivity {
    TextView cases,active,recovered,deaths;
    String countryName=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        TextView status=findViewById(R.id.status);

        cases =findViewById(R.id.cases1);
        active =findViewById(R.id.active);
        recovered=findViewById(R.id.recovered);
        deaths =findViewById(R.id.deaths);
        country.downloadtask downloadtask=new country.downloadtask();
        Intent intent=getIntent();
        countryName=intent.getStringExtra(name.EXTRA_MESSAGE);
        downloadtask.execute("https://covid19.mathdro.id/api/countries/" + countryName);
    }
    public void back(View v){

        finish();
    }

    public void search(View v){
        EditText country=findViewById(R.id.country);
        countryName=country.getText().toString();
        country.downloadtask downloadtask=new country.downloadtask();
        downloadtask.execute("https://covid19.mathdro.id/api/countries/" + countryName);
        country.setText("");
    }

    public class downloadtask extends AsyncTask<String, Void ,String> {



        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;

            try{
                url =new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in =urlConnection.getInputStream();
                InputStreamReader reader= new InputStreamReader(in);
                int data=reader.read();
                while(data != -1)
                {
                    char cur= (char) data;
                    result += cur;
                    data=reader.read();
                }
                return  result;
            }
            catch(Exception e){
                e.printStackTrace();
                return "failed";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("data from url :", s);
            try {

                JSONObject j= new JSONObject(s);
                String all=null,act=null,rec=null,death=null;
                NumberFormat myFormat = NumberFormat.getInstance();
                myFormat.setGroupingUsed(true);
                int Active=Integer.parseInt(j.getJSONObject("confirmed").getString("value"))-Integer.parseInt(j.getJSONObject("recovered").getString("value"))-Integer.parseInt(j.getJSONObject("deaths").getString("value"));
                int con=Integer.parseInt(j.getJSONObject("confirmed").getString("value"));
                int recov=Integer.parseInt(j.getJSONObject("recovered").getString("value"));
                int deat=Integer.parseInt(j.getJSONObject("deaths").getString("value"));
                all = myFormat.format(con);
                act=myFormat.format(Active);
                rec=myFormat.format(recov);
                death=myFormat.format(deat);
                cases.setText(all);
                active.setText(act);
                recovered.setText(rec);
                deaths.setText(death);
                if(countryName!=null){
                    TextView status=findViewById(R.id.status);
                    countryName=countryName.toLowerCase();
                    String c=countryName.substring(0,1);
                    c=c.toUpperCase() + countryName.substring(1);
                    status.setText(c + " Status");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                finish();

            }



        }

    }
}
