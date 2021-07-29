package com.example.easy_tickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;

public class AdminLogin extends AppCompatActivity {
    private EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        Button btn1=findViewById(R.id.btnlogin);
        email=findViewById(R.id.inputEmail);
        password=findViewById(R.id.inputPassword);
        password.setTransformationMethod(new PasswordTransformationMethod());
        TextView error=findViewById(R.id.forgotPassword);
        Customer obj=new Customer(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().length()>0 && password.getText().toString().length()>0)
                {
                    int result= 0;
                    try {

                        result = obj.AdminLogin(email.getText().toString(),password.getText().toString());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if (result==1) {
                        Intent intent = new Intent(AdminLogin.this,AdminHome.class);
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

            }
        });
    }
}