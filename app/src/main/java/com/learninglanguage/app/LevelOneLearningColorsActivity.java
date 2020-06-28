package com.learninglanguage.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.learninglanguage.app.Adapters.LevelOneColorsCardAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class LevelOneLearningColorsActivity extends AppCompatActivity {

    private ViewPager slideview;
    private LinearLayout slideNav;
    private LevelOneColorsCardAdapter adapter;
    private TextView[] mDots;

    private Button previous, next;
    private int currentPage;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelonelearningcolors);
        initComponents();

        adapter = new LevelOneColorsCardAdapter(this);
        slideview.setAdapter(adapter);
        dotsViewIndicator(0);

        slideview.addOnPageChangeListener(viewListner);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideview.setCurrentItem(currentPage - 1);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (next.getText().toString().equals("Next Lesson")){
                    startActivity(new Intent(LevelOneLearningColorsActivity.this,LevelOneLearningShapesActivity.class));
                }else{
                    slideview.setCurrentItem(currentPage + 1);
                }
            }
        });

    }

    private void dotsViewIndicator(int position) {
        mDots = new TextView[10];
        slideNav.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            slideNav.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            MediaPlayer.create(LevelOneLearningColorsActivity.this,voice_clips[position]).start();
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    private void initComponents() {
        slideview = findViewById(R.id.learn_slideView);
        slideNav = findViewById(R.id.learn_slideviewNavigation);
        previous = findViewById(R.id.prevButton);
        next = findViewById(R.id.nextButton);
    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            dotsViewIndicator(position);
            currentPage = position;

            if (position == 0) {

                next.setEnabled(true);
                previous.setEnabled(false);
                previous.setText("");
                next.setText("Next");

            } else if (position == mDots.length - 1) {

                next.setEnabled(true);
                previous.setEnabled(true);
                next.setText("Next Lesson");
                previous.setText("Previous");

            } else {

                next.setEnabled(true);
                previous.setEnabled(true);
                next.setText("Next");
                previous.setText("Previous");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
