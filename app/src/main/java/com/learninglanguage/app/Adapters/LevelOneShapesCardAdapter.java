package com.learninglanguage.app.Adapters;

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

public class LevelOneShapesCardAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public LevelOneShapesCardAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_shapes = {
            R.drawable.circle,
            R.drawable.square,
            R.drawable.star,
            R.drawable.triangle,
            R.drawable.hexagon,
            R.drawable.ellipse,
            R.drawable.pentagon,
            R.drawable.rhombus,
            R.drawable.octagon,
            R.drawable.rectangle
    };

    public int[] voice_clips = {
            R.raw.circle,
            R.raw.square,
            R.raw.star,
            R.raw.triangle,
            R.raw.hexagon,
            R.raw.oval,
            R.raw.pentagon,
            R.raw.rhombus,
            R.raw.octagon,
            R.raw.rectangle
    };

    public String[] names = {
            "Circle",
            "Square",
            "Star",
            "Triangle",
            "Hexagon",
            "Oval",
            "Pentagon",
            "Rhombus",
            "Octagon",
            "Rectangle"
    };

    @Override
    public int getCount() {
        return slide_shapes.length;
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

        card.setImageResource(slide_shapes[position]);
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
