package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.malek.myapplication.Product;
import com.example.malek.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by malek on 19/07/17.
 */

public class ProductAdapter extends BaseAdapter {

    private List<Product>  productList;
    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.listview, viewGroup, false);

        ImageView productImage = (ImageView) view1.findViewById(R.id.circle);
        TextView productName  = (TextView) view1.findViewById(R.id.TxtNom);
        TextView productDesc  = (TextView) view1.findViewById(R.id.txtDesc);
        TextView productPrice  = (TextView) view1.findViewById(R.id.txtPrice);

        Product P = productList.get(i);
        if (P !=null)
        {
            productName.setText(P.getNom());
            productDesc.setText(P.getDescription());
            productPrice.setText(P.getIdp());

            Picasso.with(viewGroup.getContext()).load(P.getImage()).into(productImage);
        }

        return view1 ;
    }


    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }
}
