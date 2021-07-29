package com.example.easy_tickets;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;

import androidx.core.app.ActivityCompat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection extends Activity {
    private static String ip="192.168.1.190";
    private static String port="1433";
    private static String Classes="net.sourceforge.jtds.jdbc.Driver";
    private static String Database="project5";
    private static String username="sa";
    private static String password="hammad123";
    private static String url="jdbc:jtds:sqlserver://"+ip+":"+port+"/"+Database;
    public static Connection connection=null;
    public Context context;
    DB_Connection(Context c)
    {
        context=c;
    }
    void makeconnection()
    {
        ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
