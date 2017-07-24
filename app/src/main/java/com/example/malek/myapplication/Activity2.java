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

public class Activity2 extends AppCompatActivity {
    private EditText nom;
    private EditText emailedit;
    private EditText passwordedit;
    private Button okButton;
    private Button CancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity2);
        nom = (EditText) findViewById(R.id.Edittextnom);
        emailedit = (EditText) findViewById(R.id.Edittext);
        passwordedit = (EditText) findViewById(R.id.Edittext1);
        okButton = (Button) findViewById(R.id.B1);
       okButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(), ActivityHome.class);
               startActivity(i);
           }
       });


}

}
