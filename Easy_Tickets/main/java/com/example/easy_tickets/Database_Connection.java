package com.example.easy_tickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection extends AppCompatActivity {
    private TextView textView;
    private static String ip="192.168.1.190";
    private static String port="1433";
    private static String Classes="net.sourceforge.jtds.jdbc.Driver";
    private static String Database="project5";
    private static String username="sa";
    private static String password="hammad123";
    private static String url="jdbc:jtds:sqlserver://"+ip+":"+port+"/"+Database;
    public static Connection connection=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database__connection);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try{
            Class.forName(Classes);
            connection= DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException e)
        {

            e.printStackTrace();

        }catch ( SQLException e)
        {

            e.printStackTrace();

        }

    }
}