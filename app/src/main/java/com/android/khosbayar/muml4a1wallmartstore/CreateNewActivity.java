package com.android.khosbayar.muml4a1wallmartstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.khosbayar.muml4a1wallmartstore.model.Userdata;

public class CreateNewActivity extends AppCompatActivity {

    EditText mFirstName, mLastName, mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        mFirstName = findViewById(R.id.etFirstName);
        mLastName = findViewById(R.id.etLastName);
        mEmail = findViewById(R.id.etEmailAddress);
        mPassword = findViewById(R.id.etPassword);
    }

    public void performCreateAccount(View view) {
        String fname = mFirstName.getText().toString();
        String lname = mLastName.getText().toString();
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        if (fname.length() > 0 && lname.length() > 0 && email.length() > 0 && password.length() > 0) {
            Userdata.addUser(fname, lname, email, password);
            Intent intent = new Intent();
            intent.putExtra("username", email);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Please fill all required fields!", Toast.LENGTH_SHORT).show();
        }
    }
}
