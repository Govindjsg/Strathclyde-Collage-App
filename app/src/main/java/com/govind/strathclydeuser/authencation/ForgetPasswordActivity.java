package com.govind.strathclydeuser.authencation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.govind.strathclydeuser.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button forgetBtn;
    private EditText textEmail;
    private String emil;
    private FirebaseAuth auth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);


        auth = FirebaseAuth.getInstance();

        textEmail = findViewById(R.id.forEmail);
        forgetBtn = findViewById(R.id.forgetBtn);
        progressBar = findViewById(R.id.pdfor);
        getSupportActionBar().hide();

        forgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                validateData();

            }
        });
    }

    private void validateData() {
        emil = textEmail.getText().toString();
        if (emil.isEmpty()){
            textEmail.setError("Required");

        }else {

            forgetpass();
        }
    }

    private void forgetpass() {
        auth.sendPasswordResetEmail(emil)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(ForgetPasswordActivity.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgetPasswordActivity.this,LoginActivity.class));
                            finish();
                        }else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(ForgetPasswordActivity.this, "Error : "+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}