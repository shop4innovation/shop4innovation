package com.example.malek.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by malek on 18/07/17.
 */

public class Retour extends AppCompatActivity {
    private EditText nom;
    private Button button;
    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retour);
        button = (Button) findViewById(R.id.BtnRetour);
        nom = (EditText) findViewById(R.id.ETxt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Details.class);
                i.putExtra(EXTRA_LOGIN, nom.getText().toString());

                startActivityForResult(i,1);

            }
        });
}
}
