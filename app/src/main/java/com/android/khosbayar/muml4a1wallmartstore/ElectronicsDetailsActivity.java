package com.android.khosbayar.muml4a1wallmartstore;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.khosbayar.muml4a1wallmartstore.model.Product;

public class ElectronicsDetailsActivity extends AppCompatActivity {


    private ImageView mProdcuctDetailsImg;
    private TextView mProductDetailsColor;
    private TextView mProductDetailsItemId;
    private TextView mProductDetailsDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_details);
        Bundle data = getIntent().getExtras();
        Product product = (Product) data.getParcelable("product");
        setTitle(product.getTitle());
        mProdcuctDetailsImg = findViewById(R.id.ivElectronicDetailsImage);
        mProdcuctDetailsImg.setImageResource(product.getImage());
        mProductDetailsColor = findViewById(R.id.tvElectronicDetailsColor);
        mProductDetailsColor.setText("Color : " + product.getColor());
        mProductDetailsItemId = findViewById(R.id.tvElectronicDetailsItemId);
        mProductDetailsItemId.setText("Walmart # : " + product.getItemId());
        mProductDetailsDescription = findViewById(R.id.tvElectronicDetailsDesc);
        mProductDetailsDescription.setText(product.getDesc());
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

}
