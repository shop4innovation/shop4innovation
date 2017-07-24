package com.example.malek.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;

public class ActivityRes extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseDatabase database ;
    private DatabaseReference myRef;
    private MyAdapter adapter;
    private List<Product> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

       database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Products");
       // myRef.setValue("Hello Word");

        //remplir la ville
        //ajouterVilles();

        recyclerView = (RecyclerView) findViewById(R.id.myrecycleview);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(ActivityRes.this, LinearLayoutManager.VERTICAL, false);
        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(horizontalLayoutManagaer);

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
       adapter = new MyAdapter(cities, this);
       recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Product product = cities.get(position);

                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("product",product);
                startActivity(i);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.i("PARIS", "onDataChange: "+dataSnapshot.getChildrenCount());
                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    Product pro1 = productSnapshot.getValue(Product.class);
                    Log.i("PARIS", "pro1 data: "+pro1.getNom());
                    cities.add(pro1);
                }

                adapter.notifyDataSetChanged();

            }




            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("", "Failed to read value.", error.toException());
            }
        });
    }

    private void ajouterVilles() {

        String url = "http://www.tunisie-voyages.com/assets/images/theme-pics/tunisia.jpg";

        Product produc1 = new Product("Product", "",url , "Description");
        cities.add(produc1);
        myRef.push().setValue(produc1);

        Product produc2 = new Product("Product", "",url , "Description");
        cities.add(produc2);
        myRef.push().setValue(produc2);

        Product produc3 = new Product("Product", "",url , "Description");
        cities.add(produc3);
        myRef.push().setValue(produc3);

        Product produc4 = new Product("Product", "",url , "Description");
        cities.add(produc4);
        myRef.push().setValue(produc4);

    }

    private void writeNewUser(String name, String idp, String image, String description) {
        Product user = new Product(name,idp,image,description);

        myRef.child("users").child(name).setValue(user);
    }

}

