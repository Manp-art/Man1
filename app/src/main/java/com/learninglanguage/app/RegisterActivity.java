package com.learninglanguage.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.learninglanguage.app.Classes.Func;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText email, fname, lname, password;
    private Button register;
    private TextView alreadyhave;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponets();
        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText())) {
                    email.setError("Email address required!");
                } else if (TextUtils.isEmpty(fname.getText())) {
                    fname.setError("Fisrt name required!");
                } else if (TextUtils.isEmpty(lname.getText())) {
                    lname.setError("Last name required!");
                } else if (TextUtils.isEmpty(password.getText())) {
                    password.setError("Password required!");
                } else {
                    if (!Func.isValidemail(email.getText().toString())) {
                        email.setError("Invalid email address!");
                    } else if (password.getText().toString().length() <= 6) {
                        password.setError("Password ");
                    } else {
                        register(email.getText().toString(), password.getText().toString());
                    }
                }
            }
        });

        alreadyhave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private void register(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            saveUser(user);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void saveUser(FirebaseUser user) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users").child(user.getUid());

        HashMap<String, String> data = new HashMap<>();
        data.put("uid", user.getUid());
        data.put("email", email.getText().toString());
        data.put("fname", fname.getText().toString());
        data.put("lname", lname.getText().toString());
        data.put("password", password.getText().toString());

        myRef.setValue(data).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
            }
        });
    }

    private void initComponets() {

        email = findViewById(R.id.email);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        alreadyhave = findViewById(R.id.haveaccount);

    }
}
