package com.example.imymemine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imymemine.Identify.IdentifyActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mEmailAddress;
    private EditText mPassword;
    FirebaseAuth mFirebaseAuth;

    private static String TAG = "EmailActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mEmailAddress = (EditText) findViewById(R.id.editMail);
        mPassword = (EditText) findViewById(R.id.verifyNumber);
        mButton = (Button) findViewById(R.id.signup_submit);

        //firebase
        mFirebaseAuth = FirebaseAuth.getInstance();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = mEmailAddress.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                mFirebaseAuth.createUserWithEmailAndPassword(emailAddress, password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(SignUpActivity.this, "등록 에러", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
                System.out.println("send email button clicked!");
            }
        });
    }
}
