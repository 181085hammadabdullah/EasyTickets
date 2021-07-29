package com.example.easy_tickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;

public class CustomerSignUp extends AppCompatActivity {

    private EditText name,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);
        Customer obj=new Customer(this);
        TextView btn=findViewById(R.id.alreadyHaveAccount);
        Button btn1=findViewById(R.id.btnRegister);
         name=findViewById(R.id.inputUsername);
         email=findViewById(R.id.inputEmail);
        password=findViewById(R.id.inputPassword);
        password.setTransformationMethod(new PasswordTransformationMethod());
        TextView error =findViewById(R.id.Error);
        if (savedInstanceState != null) {
            email.setText(savedInstanceState.getString("email"));
            password.setText(savedInstanceState.getString("password"));
            name.setText(savedInstanceState.getString("name"));
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerSignUp.this,CustomerLogin.class));
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().length()>0 && email.getText().toString().length()>0 && password.getText().toString().length()>0) {

                    obj.set(name.getText().toString(), name.getText().toString(), email.getText().toString(), password.getText().toString());
                    int result = 0;
                    try {

                        result = obj.SignUp(obj);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if (result == 1) {
                        Intent intent = new Intent(CustomerSignUp.this, CustomerHome.class);
                        intent.putExtra("email",email.getText().toString());
                        startActivity(intent);

                    }
                    else
                    {
                        error.setText("This Email Already Exists!!!");
                    }
                }
                else
                {
                    error.setText("Please Fill Required Fields");
                }
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("email",email.getText().toString());
        outState.putString("password",password.getText().toString());
        outState.putString("name",name.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        email.setText(savedInstanceState.getString("email"));
        password.setText(savedInstanceState.getString("password"));
        name.setText(savedInstanceState.getString("name"));
    }
}