package com.example.malek.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private EditText emailedit;
    private EditText passwordedit;
    public   String email ;
    public   String password ;
    private Button okButton;
    private ProgressBar firstBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstBar = (ProgressBar)findViewById(R.id.firstBar);

        emailedit = (EditText) findViewById(R.id.Edittext);
        passwordedit = (EditText) findViewById(R.id.Edittext1);
        okButton = (Button) findViewById(R.id.B1);
        mAuth = FirebaseAuth.getInstance();

        okButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (emailedit.getText().length() > 0 || passwordedit.getText().length() > 0){
                    email = emailedit.getText().toString();
                    password = passwordedit.getText().toString();
                    int i;
                    signUpUser(email,password);
                    Toast.makeText(Register.this, R.string.register_confirm, Toast.LENGTH_SHORT).show();

                    firstBar.setVisibility(View.VISIBLE);

                }
                else {

                    Toast.makeText(Register.this, R.string.register_error, Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    public void signUpUser(String email,String password) {

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("", "createUserWithEmail:onComplete:" + task.isSuccessful());
                Log.d("malek", "createUserWithEmail:onComplete:" + task.getException());


                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {
                    Toast.makeText(Register.this, R.string.register_error, Toast.LENGTH_SHORT).show();


                }

                // ...
            }
        }); }
}
