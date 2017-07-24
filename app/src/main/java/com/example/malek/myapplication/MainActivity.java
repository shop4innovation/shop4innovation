package com.example.malek.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private EditText emailedit;
    private EditText passwordedit;
    public   String email ;
    public   String password ;
    private Button okButton;
    private Button CancelButton;
    private FirebaseAuth mAuth;
    CallbackManager callbackManager;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            } });


    //   setContentView(R.layout.activity2);


            emailedit = (EditText) findViewById(R.id.Edittext);
            passwordedit = (EditText) findViewById(R.id.Edittext1);
            okButton = (Button) findViewById(R.id.B1);
            CancelButton = (Button) findViewById(R.id.B2);
            mAuth = FirebaseAuth.getInstance();

            okButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if (emailedit.getText().length() > 0 || passwordedit.getText().length() > 0){
                        email = emailedit.getText().toString();
                        password = passwordedit.getText().toString();
                        SignIn(email,password);

                    }
                    else {

        System.out.println("**********************************");

                    }
                }
            });
            CancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Register.class);
                    startActivity(i);
                }
            });

        }



    public void SignIn(String email,String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("", "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("", "signInWithEmail:failed", task.getException());
                            Toast.makeText(MainActivity.this, R.string.register_error,
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, R.string.register_confirm,
                                    Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), ActivityRes.class);
                            startActivity(i);

                        }

                        // ...
                    }
                });}


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
