package com.example.CoronaUpdate;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadtask download=new downloadtask();
        download.execute("https://corona.lmao.ninja/all");
        textView=findViewById(R.id.list);

    }
    public class downloadtask extends AsyncTask<String, Void ,String>{



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
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("data from url :", s);
            try {
                JSONObject j= new JSONObject(s);
                String things="";
                things = "Cases : " + j.getString("cases")+  "\n" + "Deaths : " +j.getString("deaths") + "\n" +"Recovered : " + j.getString("recovered") + "\n" + "Updated : " + j.getString("updated")+ "\n" +"Active : "+ j.getString("active") + "\n" +"Affected Countries : " + j.getString("affectedCountries");
                textView.setText(things);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }



        }
    }


}
