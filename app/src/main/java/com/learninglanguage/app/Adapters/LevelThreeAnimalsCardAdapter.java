package com.learninglanguage.app.Adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.learninglanguage.app.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class LevelThreeAnimalsCardAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;
    MediaController mdeiaC;

    public LevelThreeAnimalsCardAdapter(Context context) {
        this.context = context;
    }

    public int[] videos = {
            R.raw.l3_bird,
            R.raw.l3_butterfly,
            R.raw.l3_cat,
            R.raw.l3_bear,
            R.raw.l3_dog,
            R.raw.l3_deer,
            R.raw.l3_fish,
            R.raw.l3_parrot,
            R.raw.l3_snake,
            R.raw.l3_squirrel
    };

    public int[] voice_clips = {
            R.raw.bird,
            R.raw.butterfly,
            R.raw.cat,
            R.raw.bear,
            R.raw.dog,
            R.raw.deer,
            R.raw.fish,
            R.raw.parrot,
            R.raw.snake,
            R.raw.squirrel
    };

    public String[] names = {
            "Bird",
            "Butterfly",
            "Cat",
            "Bear",
            "Dog",
            "Deer",
            "Fish",
            "Parrot",
            "Snake",
            "Squirrel"
    };

    @Override
    public int getCount() {
        return videos.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.video_slide_layout, container, false);

        VideoView card = view.findViewById(R.id.videoview);
        TextView cardname = view.findViewById(R.id.card_name);
        ImageView voice = view.findViewById(R.id.sound);

        Uri uri = Uri.parse("android.resource://com.learninglanguage.app/" + videos[position]);
        card.setVideoURI(uri);
        mdeiaC = new MediaController(context);
        card.setMediaController(mdeiaC);
        mdeiaC.setAnchorView(card);
        card.start();
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
