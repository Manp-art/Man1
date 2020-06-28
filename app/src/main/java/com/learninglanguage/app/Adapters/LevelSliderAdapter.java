package com.learninglanguage.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.learninglanguage.app.HomeActivity;
import com.learninglanguage.app.LevelOneLearningAnimalsActivity;
import com.learninglanguage.app.LevelOneTestingActivity;
import com.learninglanguage.app.LevelThreeLearningAnimalsActivity;
import com.learninglanguage.app.LevelTwoLearningAnimalsActivity;
import com.learninglanguage.app.R;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

public class LevelSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public LevelSliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.lvl1,
            R.drawable.lvl2,
            R.drawable.lvl3
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
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout, container, false);

        ImageView slider_image = view.findViewById(R.id.level_icon);
        final Button start = view.findViewById(R.id.start);

        FirebaseDatabase.getInstance().getReference("Level").child("level" + position + 1).child(HomeActivity.user).child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    if ((long) dataSnapshot.getValue() == 1) {
                        start.setText("Continue");
                    } else {
                        start.setText("Start Again");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        slider_image.setImageResource(slide_images[position]);
        container.addView(view);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("---------" + position);
                if (position == 0) {
                    FirebaseDatabase.getInstance().getReference("Level").child("level01").child(HomeActivity.user).child("status").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                if ((long) dataSnapshot.getValue() == 1) {
                                    ContextCompat.startActivity(context, new Intent(context, LevelOneTestingActivity.class), null);
                                } else {
                                    ContextCompat.startActivity(context, new Intent(context, LevelOneLearningAnimalsActivity.class), null);
                                }
                            } else {
                                ContextCompat.startActivity(context, new Intent(context, LevelOneLearningAnimalsActivity.class), null);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                } else if (position == 1) {

                    FirebaseDatabase.getInstance().getReference("Level").child("level01").child(HomeActivity.user).child("status").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                if ((long) dataSnapshot.getValue() == 0) {
                                    //ok
                                    System.out.println("ok");
                                    FirebaseDatabase.getInstance().getReference("Level").child("level02").child(HomeActivity.user).child("status").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            if (dataSnapshot.exists()) {
                                                System.out.println(">>>>>>>>>>>>>");
                                                if ((long) dataSnapshot.getValue() == 1) {
                                                    //testing
                                                } else {
                                                    //begining
                                                    ContextCompat.startActivity(context, new Intent(context, LevelTwoLearningAnimalsActivity.class), null);
                                                }
                                            } else {
                                                ContextCompat.startActivity(context, new Intent(context, LevelTwoLearningAnimalsActivity.class), null);
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                } else {
                                    Toast.makeText(context, "Please complete level 01!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(context, "Please complete level 01!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                } else {

                    FirebaseDatabase.getInstance().getReference("Level").child("level02").child(HomeActivity.user).child("status").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                if ((long) dataSnapshot.getValue() == 0) {

                                    FirebaseDatabase.getInstance().getReference("Level").child("level02").child(HomeActivity.user).child("status").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            if (dataSnapshot.exists()) {
                                                if ((long) dataSnapshot.getValue() == 1) {
                                                    //testing
                                                } else {
                                                    //begining
                                                    ContextCompat.startActivity(context, new Intent(context, LevelThreeLearningAnimalsActivity.class), null);
                                                }
                                            } else {
                                                ContextCompat.startActivity(context, new Intent(context, LevelThreeLearningAnimalsActivity.class), null);
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });

                                } else {
                                    Toast.makeText(context, "Please complete level 02!", Toast.LENGTH_SHORT).show();
                                    ContextCompat.startActivity(context, new Intent(context, LevelThreeLearningAnimalsActivity.class), null);
                                }
                            } else {
                                Toast.makeText(context, "Please complete level 02!", Toast.LENGTH_SHORT).show();
                                ContextCompat.startActivity(context, new Intent(context, LevelThreeLearningAnimalsActivity.class), null);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }


            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
