package com.learninglanguage.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LevelOneTestingShapesActivity extends AppCompatActivity {

    private CardView oval,star,circle,pentagon,rectangle;
    private ImageView voice;
    private int[] voice_clips = {
            R.raw.oval,
            R.raw.star,
            R.raw.circle,
            R.raw.pentagon,
            R.raw.rectangle
    };
    private String name;
    private int count = 0;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one_testing_shapes);
        initComponents();
        mAuth = FirebaseAuth.getInstance();
        loadWord();

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voice();
            }
        });

        oval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Oval")) {
                    //pass
                    new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 01 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0);
                                    startActivity(new Intent(LevelOneTestingShapesActivity.this, SplashScreenActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelOneTestingShapesActivity.this, LevelOneLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Star")) {
                    //pass
                    new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 01 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0);
                                    startActivity(new Intent(LevelOneTestingShapesActivity.this, SplashScreenActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelOneTestingShapesActivity.this, LevelOneLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Circle")) {
                    //pass
                    new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 01 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    System.out.println(">>>>>>>>>>>");
                                    FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0);
                                    startActivity(new Intent(LevelOneTestingShapesActivity.this,SplashScreenActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelOneTestingShapesActivity.this, LevelOneLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        pentagon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Pentagon")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 01 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0);
                                    startActivity(new Intent(LevelOneTestingShapesActivity.this, SplashScreenActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelOneTestingShapesActivity.this, LevelOneLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Rectangle")) {
                    //pass
                    new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 01 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0);
                                    startActivity(new Intent(LevelOneTestingShapesActivity.this, SplashScreenActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level01").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelOneTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelOneTestingShapesActivity.this, LevelOneLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });
    }

    private void voice() {
        if (name.equals("Oval")) {
            MediaPlayer.create(LevelOneTestingShapesActivity.this, voice_clips[0]).start();
        } else if (name.equals("Star")) {
            MediaPlayer.create(LevelOneTestingShapesActivity.this, voice_clips[1]).start();
        } else if (name.equals("Circle")) {
            MediaPlayer.create(LevelOneTestingShapesActivity.this, voice_clips[2]).start();
        } else if (name.equals("Pentagon")) {
            MediaPlayer.create(LevelOneTestingShapesActivity.this, voice_clips[3]).start();
        } else {
            MediaPlayer.create(LevelOneTestingShapesActivity.this, voice_clips[4]).start();
        }
    }

    private void loadNextWord() {
        FirebaseDatabase.getInstance().getReference("Test").child("level01").child("shapes").child("second").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name = (String) dataSnapshot.getValue();
                    voice();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void loadWord() {
        FirebaseDatabase.getInstance().getReference("Test").child("level01").child("shapes").child("first").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name = (String) dataSnapshot.getValue();
                    voice();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LevelOneTestingShapesActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initComponents() {
        voice = findViewById(R.id.sound);
        oval = findViewById(R.id.oval);
        star = findViewById(R.id.star);
        circle = findViewById(R.id.circle);
        pentagon = findViewById(R.id.pentagon);
        rectangle = findViewById(R.id.rectangle);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,HomeActivity.class));
    }

}