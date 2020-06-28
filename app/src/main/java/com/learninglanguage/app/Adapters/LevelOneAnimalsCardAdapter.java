package com.learninglanguage.app.Adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.learninglanguage.app.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class LevelOneAnimalsCardAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public LevelOneAnimalsCardAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.sample_dog,
            R.drawable.sample_parrot,
            R.drawable.sample_bear,
            R.drawable.sample_giraffe,
            R.drawable.sample_tiger,
            R.drawable.sample_cat,
            R.drawable.sample_elephant,
            R.drawable.sample_horse,
            R.drawable.sample_lion,
            R.drawable.sample_owl
    };

    public int[] voice_clips = {
            R.raw.dog,
            R.raw.parrot,
            R.raw.bear,
            R.raw.giraffe,
            R.raw.tiger,
            R.raw.cat,
            R.raw.elephant,
            R.raw.horse,
            R.raw.lion,
            R.raw.owl
    };

    public String[] names = {
            "Dog",
            "Parrot",
            "Bear",
            "Giraffe",
            "Tiger",
            "Cat",
            "Elephant",
            "Horse",
            "Lion",
            "Owl"
    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.learn_slide_layout, container, false);

        ImageView card = view.findViewById(R.id.card);
        TextView cardname = view.findViewById(R.id.card_name);
        ImageView voice = view.findViewById(R.id.sound);

        card.setImageResource(slide_images[position]);
        cardname.setText(names[position]);

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer.create(context,voice_clips[position]).start();
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
