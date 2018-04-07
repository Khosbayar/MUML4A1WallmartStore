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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.khosbayar.muml4a1wallmartstore.adapter.ProductAdapter;
import com.android.khosbayar.muml4a1wallmartstore.model.Product;

import java.util.ArrayList;

public class ElectronicsActivity extends AppCompatActivity {


    private ArrayList<Product> products;
    private ListView mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Products (Electronics)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);
        products = new ArrayList<>();
        populateProductList();
        mProductList = findViewById(R.id.lvElectronicsList);
        mProductList.setAdapter(new ProductAdapter(products, this));
        mProductList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) parent.getItemAtPosition(position);
//                Log.i("ElectronicsActivity", product.getTitle());
                Intent i = new Intent(getApplicationContext(), ElectronicsDetailsActivity.class);
                i.putExtra("product", product);
                startActivity(i);
            }
        });

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

    private void populateProductList() {
        products.add(new Product("Modern camera XZ-12", 433.23, "Purple", R.drawable.camera, "123-123-456", "Desc is good, camera itself is better, author is best"));
        products.add(new Product("Classic camera A-1", 200.23, "Yellow", R.drawable.camera2, "123-123-541", "Desc is good, camera itself is better, author is best"));
        products.add(new Product("Oracle Database 11c", 4100.99, "Black", R.drawable.database, "123-123-576", "Desc is good, camera itself is better, author is best"));
        products.add(new Product("Amazon AWS 9-S", 2000.00, "Blue", R.drawable.database2, "853-321-456", "Desc is good, camera itself is better, author is best"));
        products.add(new Product("Raspberry PI", 20, "Black", R.drawable.raspberry, "777-124-456", "Desc is good, camera itself is better, author is best"));
        products.add(new Product("Google Pixel 3L", 1100, "Black", R.drawable.smartphone, "285-124-456", "Desc is good, camera itself is better, author is best"));
        products.add(new Product("Samsung Ultra Inch TV - 50", 1500, "Black", R.drawable.tv, "927-621-456", "Desc is good, camera itself is better, author is best"));
    }
}
