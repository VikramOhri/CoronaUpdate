package com.example.CoronaUpdate;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;

public class World extends AppCompatActivity {

    TextView cases,active,recovered,deaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        cases =findViewById(R.id.cases1);
        active =findViewById(R.id.active);
        recovered=findViewById(R.id.recovered);
        deaths =findViewById(R.id.deaths);
        downloadtask downloadtask=new downloadtask();

        downloadtask.execute("https://covid19.mathdro.id/api");

    }
    public void back(View v){
        finish();
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
                return "result";
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

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }



        }

    }
}
