package com.example.nikan.task3;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private static final String ID_KEY = "ID_KEY";

    public static Intent getIntent(final Context context, final long id) {
        final Intent intent = new Intent(context, ProfileActivity.class);
        intent.putExtra(ID_KEY, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final long id = getIntent().getLongExtra(ID_KEY, -1);
        final Person person = PersonRepository.getPersonById(id);

        final TextView textView = findViewById(R.id.textView);
        final ImageView imageView = findViewById(R.id.imageView);
        textView.setText(person.getName());
        imageView.setImageResource(R.drawable.face_small);
    }


}
