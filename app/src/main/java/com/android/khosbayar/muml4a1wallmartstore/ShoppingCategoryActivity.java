package com.android.khosbayar.muml4a1wallmartstore;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingCategoryActivity extends AppCompatActivity {

    TextView mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Shopping categories");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_category);
        mUsername = findViewById(R.id.tvUsername);
        mUsername.setText(getIntent().getStringExtra("username"));

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
                i = new Intent(ShoppingCategoryActivity.this, BeautyActivity.class);
                startActivity(i);
                return true;
            case R.id.miClothing:
                i = new Intent(ShoppingCategoryActivity.this, ClothingActivity.class);
                startActivity(i);
                return true;
            case R.id.miFood:
                i = new Intent(ShoppingCategoryActivity.this, FoodActivity.class);
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
                            Intent i = new Intent(ShoppingCategoryActivity.this, MainActivity.class);
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

    public void performBeauty(View view) {
//        Toast.makeText(this, "You clicked Beauty category", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ShoppingCategoryActivity.this, BeautyActivity.class);
        startActivity(i);
    }

    public void performFood(View view) {
//        Toast.makeText(this, "You clicked Food category", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ShoppingCategoryActivity.this, FoodActivity.class);
        startActivity(i);
    }

    public void performClothing(View view) {
//        Toast.makeText(this, "You clicked Clothing category", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ShoppingCategoryActivity.this, ClothingActivity.class);
        startActivity(i);

    }

    public void performElectronics(View view) {
//        Toast.makeText(this, "You clicked Electronics category", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, ElectronicsActivity.class);
        startActivity(i);
    }

    public void performLogout(View view) {
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
                    Intent i = new Intent(ShoppingCategoryActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };

        builder.setPositiveButton("Yes", listener);
        builder.setNegativeButton("No", listener);
        builder.show();
    }
}
