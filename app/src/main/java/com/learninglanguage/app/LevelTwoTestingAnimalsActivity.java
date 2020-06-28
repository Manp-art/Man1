package com.learninglanguage.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class LevelTwoTestingAnimalsActivity extends AppCompatActivity {

    private ImageView voice, lion, bear, horse, parrot, owl;
    private int[] voice_clips = {
            R.raw.cat,
            R.raw.dog,
            R.raw.giraffe,
            R.raw.parrot,
            R.raw.tiger
    };
    private String name;
    private int count = 0;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_testing_animals);
    }
}