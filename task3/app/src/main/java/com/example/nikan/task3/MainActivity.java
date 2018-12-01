package com.example.nikan.task3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendEmail = findViewById(R.id.button_send_email);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendEmailActivity();
                //Toast.makeText(MainActivity.this, "Send email button pressed", Toast.LENGTH_LONG).show();
            }
        });

        Button btnPeopleList = findViewById(R.id.button_people_list);
        btnPeopleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPeopleList();
            }
        });
    }

    public void SendEmailActivity(){
        /* Create the Intent */ 
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        /* Fill it with Data */
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"to@email.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Отправлено из ...");
        /* Send it off to the Activity-Chooser */
        startActivity(emailIntent);
    }

    public void OpenPeopleList(){
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }

}
