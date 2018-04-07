package com.android.khosbayar.muml4a1wallmartstore.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.khosbayar.muml4a1wallmartstore.ElectronicsDetailsActivity;
import com.android.khosbayar.muml4a1wallmartstore.R;
import com.android.khosbayar.muml4a1wallmartstore.model.Product;

import java.util.ArrayList;

/**
 * Created by khosbayar on 4/6/18.
 */

public class ProductAdapter extends BaseAdapter {

    private ArrayList<Product> products;
    private Context mContext;
    private static LayoutInflater inflater = null;

    public class ViewHolder {
        ImageView mProductImg;
        TextView mProductTitle;
        TextView mProductPrice;
        TextView mProductColor;
    }

    public ProductAdapter(ArrayList<Product> products, Context mContext) {
        this.products = products;
        this.mContext = mContext;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        View view = inflater.inflate(R.layout.listview_electronics, null);
        viewHolder.mProductImg = (ImageView) view.findViewById(R.id.ivElectronicImage);
        viewHolder.mProductTitle = (TextView) view.findViewById(R.id.tvElectronicTitle);
        viewHolder.mProductPrice = (TextView) view.findViewById(R.id.tvElectronicPrice);
        viewHolder.mProductColor = (TextView) view.findViewById(R.id.tvElectronicColor);
        Product product = products.get(position);
        viewHolder.mProductImg.setImageResource(product.getImage());
        viewHolder.mProductTitle.setText(product.getTitle());
        viewHolder.mProductPrice.setText(String.valueOf(product.getPrice()) + "$");
        viewHolder.mProductColor.setText(product.getColor());

        return view;
    }
}
