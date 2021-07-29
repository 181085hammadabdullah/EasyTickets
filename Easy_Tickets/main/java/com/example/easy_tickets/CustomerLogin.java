package com.example.easy_tickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerLogin extends AppCompatActivity {

    private EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        TextView btn=findViewById(R.id.textViewSignUp);
        Button btn1=findViewById(R.id.btnlogin);
         email=findViewById(R.id.inputEmail);
         password=findViewById(R.id.inputPassword);
        password.setTransformationMethod(new PasswordTransformationMethod());
        TextView error=findViewById(R.id.forgotPassword);
        Customer obj=new Customer(this);
        if (savedInstanceState != null) {
            email.setText(savedInstanceState.getString("email"));
            password.setText(savedInstanceState.getString("password"));
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().length()>0 && password.getText().toString().length()>0)
                {
                    int result= 0;
                    try {

                        result = obj.Login(email.getText().toString(),password.getText().toString());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if (result==1) {
                        Intent intent = new Intent(CustomerLogin.this, CustomerHome.class);
                        intent.putExtra("email",email.getText().toString());
                        startActivity(intent);

                    }
                    else
                    {
                        error.setText("Invalid Email or Password");
                    }
                    }
                else
                {
                    error.setText("Email or Password Required*");
                }
                Intent intent = new Intent(CustomerLogin.this, CustomerHome.class);
                intent.putExtra("email",email.getText().toString());
                startActivity(intent);


            }
        });        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerLogin.this,CustomerSignUp.class));
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("email",email.getText().toString());
        outState.putString("password",password.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        email.setText(savedInstanceState.getString("email"));
        password.setText(savedInstanceState.getString("password"));
    }
}