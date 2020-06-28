package com.learninglanguage.app.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learninglanguage.app.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class LevelOneColorsCardAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public LevelOneColorsCardAdapter(Context context) {
        this.context = context;
    }

    public String[] slide_colors = {
            "#e51400",
            "#0050ef",
            "#000000",
            "#FFFFFF",
            "#008a00",
            "#e3c800",
            "#fa6800",
            "#800080",
            "#f472d0",
            "#825a2c"
    };

    public int[] voice_clips = {
            R.raw.red,
            R.raw.blue,
            R.raw.black,
            R.raw.white,
            R.raw.green,
            R.raw.yellow,
            R.raw.orange,
            R.raw.purple,
            R.raw.pink,
            R.raw.brown
    };

    public String[] names = {
            "Red",
            "Blue",
            "Black",
            "White",
            "Green",
            "Yellow",
            "Orange",
            "Purple",
            "Pink",
            "Brown"
    };

    @Override
    public int getCount() {
        return slide_colors.length;
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

        card.setBackgroundColor(Color.parseColor(slide_colors[position]));
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
