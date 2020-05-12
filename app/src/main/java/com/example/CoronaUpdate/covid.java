package com.example.CoronaUpdate;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class covid extends AppCompatActivity {

    String msg=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);
        Intent intent=getIntent();
        msg=intent.getStringExtra(menu.msg);
        data();
    }
    public void back(View view){
        finish();
    }
    public void data(){
        if(msg.equals("covid")) {
            TextView head = findViewById(R.id.head);
            head.setText("COVID-19");
            head.setBackgroundResource(R.drawable.cus_but1);
            TextView data1 = findViewById(R.id.data1);
            data1.setText("COVID-19 is a new strain of coronavirus that has not been previously identified in humans. The COVID-19 is the cause of an outbreak of respiratory illness first detected in Wuhan, Hubei province, China.\n" +
                    "\n" +
                    "Since December 2019, cases have been identified in a growing number of countries.\n" +
                    "\n" +
                    "Coronaviruses are a large family of viruses that are known to cause illness ranging from the common cold to more severe diseases such as Severe Acute Respiratory syndrome (SARS) and Middle East Respiratory Syndrome (MERS).\n" +
                    "\n" +
                    "Public health authorities are learning more every day. We will continue to update as we learn more.");

            TextView data2 = findViewById(R.id.data2);
            data2.setVisibility(View.VISIBLE);
            TextView head2 = findViewById(R.id.head2);
            head2.setVisibility(View.VISIBLE);
            data2.setText("Reported illnesses have ranged from mild symptoms to severe illness and death for confirmed coronavirus disease 2019 (COVID-19) cases.\n" +
                    "\n\n" +
                    "Symptoms may appear 2-14 days after exposure:\n" +
                    "\n" +
                    "-Cough\n" +
                    "-Fever\n" +
                    "-Headache\n" +
                    "-(New)Loss of taste or smell\n" +
                    "-Repeated shaking with chills\n" +
                    "-Sore throat\n" +
                    "-Shortness of breath\n" +
                    "-Muscle pain");
            data1.setPadding(0,0,0,0);
        }
        else if(msg.equals("prev")){
            TextView head1= findViewById(R.id.head);
            head1.setText("PREVENTION");
            head1.setBackgroundResource(R.drawable.cus_but);
            TextView data1 = findViewById(R.id.data1);
            data1.setText("The symptoms that are currently being seen with COVID-19 are cough, fever, headache, new loss of taste or smell, repeated shaking with chills, sore throat, shortness of breath, and muscle pain. To help prevent the spread of germs, you should:\n\n" +
                    "\n\n" +
                    "-Multiple times a day, wash your hands often with soap and water for at least 20 seconds, especially after going to the bathroom, before eating, and after blowing your nose, coughing, or sneezing.\n\n" +
                    "-Avoid close contact with people who are sick.\n\n" +
                    "-Avoid touching your eyes, nose, and mouth with unwashed hands.\n\n" +
                    "-Clean and disinfect frequently touched objects and surfaces.\n\n" +
                    "-Use an alcohol-based hand sanitizer with at least 60% alcohol if you have symptoms of acute respiratory illness.\n\n" +
                    "-Stay home from work or school until you are free of fever, signs of a fever, and any other symptoms for at least 24 hours and without the use of fever-reducing or other symptom-altering medications.\n\n" +
                    "-Seek medical attention if you have reason to believe you have been exposed to coronavirus or influenza. Call your healthcare provider before visiting a healthcare facility.\n\n" +
                    "You play an important role in stopping the spread of germs.\n\n\n");
            data1.setPadding(0,0,0,30);

            TextView data2 = findViewById(R.id.data2);
            data2.setVisibility(View.GONE);
            TextView head2 = findViewById(R.id.head2);
            head2.setVisibility(View.GONE);

        }
        else if(msg.equals("myths")){
            TextView head1= findViewById(R.id.head);
            head1.setText("MYTH BUSTER");
            head1.setBackgroundResource(R.drawable.cus_but3);
            TextView data1 = findViewById(R.id.data1);
            data1.setText("-Adding pepper to your soup or other meals DOES NOT prevent or cure COVID-19 \n\n" +
                    "-Spraying and introducing bleach or another disinfectant into your body WILL NOT protect you against COVID-19 and can be dangerous\n\n" +
                    "-Drinking methanol, ethanol or bleach DOES NOT prevent or cure COVID-19 and can be extremely dangerous\n\n" +
                    "-Exposing yourself to the sun or to temperatures higher than 25C degrees DOES NOT prevent the coronavirus disease (COVID-19)\n\n" +
                    "-You can recover from the coronavirus disease (COVID-19). Catching the new coronavirus DOES NOT mean you will have it for life.\n\n" +
                    "-Being able to hold your breath for 10 seconds or more without coughing or feeling discomfort DOES NOT mean you are free from the coronavirus disease (COVID-19) or any other lung disease.\n\n" +
                    "-Drinking alcohol does not protect you against COVID-19 and can be dangerous\n\n" +
                    "-COVID-19 virus can be transmitted in areas with hot and humid climates\n\n" +
                    "-Cold weather and snow CANNOT kill the new coronavirus.\n\n" +
                    "-Taking a hot bath does not prevent the new coronavirus disease\n\n" +
                    "-Ultra-violet (UV) lamps should not be used to disinfect hands or other areas of your skin\n\n" );
            data1.setPadding(0,0,0,30);

            TextView data2 = findViewById(R.id.data2);
            data2.setVisibility(View.GONE);
            TextView head2 = findViewById(R.id.head2);
            head2.setVisibility(View.GONE);

        }

    }
}
