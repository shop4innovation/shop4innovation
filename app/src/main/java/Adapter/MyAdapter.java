package Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.malek.myapplication.MyViewHolder;
import com.example.malek.myapplication.Product;
import com.example.malek.myapplication.R;

import java.util.List;

/**
 * Created by malek on 19/07/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Product> list;
    private Activity activity;

    //ajouter un constructeur prenant en entrée une liste
    public MyAdapter(List<Product> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recycler_view,viewGroup,false);

        return new MyViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        final Product myObject = list.get(position);
        myViewHolder.bind(myObject, activity);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}

