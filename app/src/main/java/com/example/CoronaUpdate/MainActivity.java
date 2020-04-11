package com.example.CoronaUpdate;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String countryName=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadtask download=new downloadtask();
        download.execute("https://covid19.mathdro.id/api");
        textView=findViewById(R.id.list);
    }
    public void search (View v){
        downloadtask downloadtask=new downloadtask();
        EditText Country=findViewById(R.id.Country);
        countryName=Country.getText().toString();
        Country.setText(null);
        downloadtask.execute("https://covid19.mathdro.id/api/countries/" + countryName);
    }
    public void world(View v){
        downloadtask downloadtask=new downloadtask();
        downloadtask.execute("https://covid19.mathdro.id/api");
        countryName=null;
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
                return "result";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("data from url :", s);
            try {

                JSONObject j= new JSONObject(s);
                String things=null;
                things = "Cases : " + j.getJSONObject("confirmed").getString("value")+  "\n" + "Recovered : " +j.getJSONObject("recovered").getString("value") + "\n" +"Deaths : " + j.getJSONObject("deaths").getString("value");
                textView.setText(things);
                if(countryName!=null){
                    TextView status=findViewById(R.id.Status);

                    countryName=countryName.toLowerCase();
                    String c=countryName.substring(0,1);
                    c=c.toUpperCase() + countryName.substring(1);
                    status.setText(c + " Status");

                }
                else {
                    TextView status=findViewById(R.id.Status);
                    status.setText("World Status");
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();

            }



        }

    }


}
