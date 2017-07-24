package com.example.malek.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Adapter.ProductAdapter;

/**
 * Created by malek on 18/07/17.
 */

public class ActivityHome extends AppCompatActivity {
private ImageView img ;

    private ListView ProductListView;
    private  List<Product> productL ;


     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
                img = (ImageView) findViewById(R.id.img1);
       // Picasso.with(ActivityHome.this).load("http://i.imgur.com/DvpvklR.png").into(img);

        button = (Button) findViewById(R.id.Camera);


        ProductListView = (ListView) findViewById(R.id.list_item);
        productL = new ArrayList<Product>();

        fillProductItems(productL);

        ProductAdapter adapter = new ProductAdapter(productL);

        ProductListView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);
            }
        });

}


private  void  fillProductItems (List<Product> productL ){
    for(int i = 0; i < 10; i++){
        Product product = new Product("Product ","", "http://www.tunisie-voyages.com/assets/images/theme-pics/tunisia.jpg", "Description");

        productL.add(product);
    }

}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        img.setImageBitmap(bitmap);
    }
}
