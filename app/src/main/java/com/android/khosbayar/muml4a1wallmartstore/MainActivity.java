package com.android.khosbayar.muml4a1wallmartstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.khosbayar.muml4a1wallmartstore.model.User;
import com.android.khosbayar.muml4a1wallmartstore.model.Userdata;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int REQCODE_CREATE_NEW = 64;
    private EditText mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.etEmailAddress);
        mPassword = findViewById(R.id.etPassword);


    }

    public void performForgotPassword(View view) {
        Toast.makeText(this, "You clicked forgot password, okay got it!", Toast.LENGTH_SHORT).show();
    }

    public void performSignIn(View view) {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();
        if (username.length() > 1 && password.length() > 1) {
            User user = Userdata.findUserByUserName(username);
            if (user != null && user.getPassword().equals(password)) {
                Intent i = new Intent(MainActivity.this, ShoppingCategoryActivity.class);
                i.putExtra("name", user.getFirstName() + " " + user.getLastName());
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter the username or password!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void performCreateNew(View view) {
        Intent iCreateNew = new Intent(MainActivity.this, CreateNewActivity.class);
        startActivityForResult(iCreateNew, REQCODE_CREATE_NEW);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQCODE_CREATE_NEW) {
            if (resultCode == RESULT_OK) {
                String registeredUsername = data.getStringExtra("username");

                if (registeredUsername != null) {
                    Toast.makeText(this, "User registered successfully, now you can login.", Toast.LENGTH_SHORT).show();
                    mUsername.setText(registeredUsername);
                }
            }
        }
    }
}
