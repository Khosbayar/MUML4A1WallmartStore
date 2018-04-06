package com.android.khosbayar.muml4a1wallmartstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingCategoryActivity extends AppCompatActivity {

    TextView mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_category);
        mUsername = findViewById(R.id.tvUsername);
        mUsername.setText(getIntent().getStringExtra("name"));

    }

    public void performBeauty(View view) {
        Toast.makeText(this, "You clicked Beauty category", Toast.LENGTH_SHORT).show();
    }

    public void performFood(View view) {
        Toast.makeText(this, "You clicked Food category", Toast.LENGTH_SHORT).show();
    }

    public void performClothing(View view) {
        Toast.makeText(this, "You clicked Clothing category", Toast.LENGTH_SHORT).show();
    }

    public void performElectronics(View view) {
        Toast.makeText(this, "You clicked Electronics category", Toast.LENGTH_SHORT).show();
    }

    public void performLogout(View view) {
        Intent i = new Intent(ShoppingCategoryActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
