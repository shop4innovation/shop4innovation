package com.example.malek.myapplication;

/**
 * Created by malek on 19/07/17.
 */

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;



/**
 * Created by malek on 19/07/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewView;
    private TextView textViewView1;
    private TextView textViewView2;

    private ImageView imageView;

    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView
        textViewView = (TextView) itemView.findViewById(R.id.text);
        textViewView1 = (TextView) itemView.findViewById(R.id.text1);
        textViewView2 = (TextView) itemView.findViewById(R.id.text2);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Product myObject, Activity activity){

        Log.i("PARIS", "name: "+myObject.getNom());
        Log.i("PARIS", "image: "+myObject.getImage());

        textViewView.setText(myObject.getNom());
        textViewView1.setText(myObject.getIdp());
        textViewView2.setText(myObject.getDescription());

        Picasso.with(activity).load(myObject.getImage()).into(imageView);


    }


}

