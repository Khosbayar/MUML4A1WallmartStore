package com.android.khosbayar.muml4a1wallmartstore;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.khosbayar.muml4a1wallmartstore.adapter.FoodAdapter;
import com.android.khosbayar.muml4a1wallmartstore.model.Food;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    private ListView mFoodList;
    private static ArrayList<Food> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Foods");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        foods = new ArrayList<>();
        mFoodList = (ListView) findViewById(R.id.lvFoodList);
        populateArrayList();

        mFoodList.setAdapter(new FoodAdapter(foods, this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.miElectronics:
                i = new Intent(this, ElectronicsActivity.class);
                startActivity(i);
                return true;
            case R.id.miBeauty:
                i = new Intent(this, BeautyActivity.class);
                startActivity(i);
                return true;
            case R.id.miClothing:
                i = new Intent(this, ClothingActivity.class);
                startActivity(i);
                return true;
            case R.id.miFood:
                i = new Intent(this, FoodActivity.class);
                startActivity(i);
                return true;
            case R.id.miLogout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.drawable.electronics);
                builder.setTitle("Log out");
                builder.setMessage("Are you really want logout?");

                AlertDialog.OnClickListener listener = new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == dialog.BUTTON_NEGATIVE) {
                            dialog.dismiss();
                        } else if (which == dialog.BUTTON_POSITIVE) {
                            dialog.dismiss();
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }
                };

                builder.setPositiveButton("Yes", listener);
                builder.setNegativeButton("No", listener);
                builder.show();
                return true;
            default:
                Log.e("OptionMenu", "No options");
                return super.onOptionsItemSelected(item);
        }

    }

    private static void populateArrayList() {
        foods.add(new Food("Cheese", R.drawable.cheese, 12));
        foods.add(new Food("Chili", R.drawable.chili, 10));
        foods.add(new Food("Fish", R.drawable.fish, 54));
        foods.add(new Food("Wine", R.drawable.glass, 4));
        foods.add(new Food("Lemon", R.drawable.lemon, 65));
        foods.add(new Food("Orange", R.drawable.orange, 12));
        foods.add(new Food("Beer", R.drawable.pint, 44));
        foods.add(new Food("Raspberry", R.drawable.raspberry, 7));
        foods.add(new Food("Strawberry", R.drawable.strawberry, 9));
        foods.add(new Food("Turkey", R.drawable.turkey, 95));
        foods.add(new Food("Watermelon", R.drawable.watermelon, 4));

    }
}
