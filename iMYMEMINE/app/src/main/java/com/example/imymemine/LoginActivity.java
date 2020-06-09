package com.example.imymemine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imymemine.Identify.IdentifyActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    //@param
    private EditText mPassword;
    private EditText mEmailAddress;
    private Button mButton;
    private Button mRegister;
    private ProgressBar mProgressbar;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = mFirebaseAuth.getInstance();

        mEmailAddress = findViewById(R.id.signin_email_address);
        mPassword = findViewById(R.id.signin_password);
        mButton = findViewById(R.id.submit_password);
        mRegister = findViewById(R.id.register);
        mProgressbar = findViewById(R.id.progress_login);
        mProgressbar.setVisibility(View.INVISIBLE);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressbar.setVisibility(View.VISIBLE);

                String email = mEmailAddress.getText().toString().trim();
                String pwd = mPassword.getText().toString().trim();

                mFirebaseAuth.signInWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    mProgressbar.setVisibility(View.GONE);
                                    Intent intent = new Intent(LoginActivity.this, IdentifyActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent1);
            }
        });
    }
}
