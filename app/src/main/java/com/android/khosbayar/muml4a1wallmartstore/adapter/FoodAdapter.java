package com.android.khosbayar.muml4a1wallmartstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.khosbayar.muml4a1wallmartstore.R;
import com.android.khosbayar.muml4a1wallmartstore.model.Food;

import java.util.ArrayList;

/**
 * Created by khosbayar on 4/6/18.
 */

public class FoodAdapter extends BaseAdapter {

    private ArrayList<Food> foods = new ArrayList<>();
    private Context mContext;
    private static LayoutInflater inflater = null;

    public class ViewHolder {
        ImageView mFoodImg;
        TextView mFoodTitle;
        TextView mFoodPrice;

    }

    public FoodAdapter(ArrayList<Food> foods, Context context) {
        mContext = context;
        this.foods = foods;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        View view = inflater.inflate(R.layout.listview_food, null);
        viewHolder.mFoodImg = (ImageView) view.findViewById(R.id.ivFoodImage);
        viewHolder.mFoodTitle = (TextView) view.findViewById(R.id.tvFoodTitle);
        viewHolder.mFoodPrice = (TextView) view.findViewById(R.id.tvFoodPrice);

        viewHolder.mFoodImg.setImageResource(foods.get(position).getImage());
        viewHolder.mFoodTitle.setText(foods.get(position).getTitle());
        viewHolder.mFoodPrice.setText(foods.get(position).getPrice() + "$");

        return view;
    }
}
