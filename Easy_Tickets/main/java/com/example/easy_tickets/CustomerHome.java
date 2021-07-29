package com.example.easy_tickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.navigation.NavigationView;

import java.sql.SQLException;

public class CustomerHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private  String email;
    int id;
    Customer obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
        Toast.makeText(this, "saving", Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
         obj=new Customer(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_profile:
                Bundle bundle = new Bundle();
                bundle.putString("email",email);
                Fragment profile = new CustomerProfile();
                profile.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       profile).commit();
                break;
            case R.id.nav_bus_trip:
                Bundle bundle1 = new Bundle();
                bundle1.putString("email",email);
                Fragment BusTripFragment = new BusTripFragment();
                BusTripFragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        BusTripFragment).commit();
                break;
            case R.id.nav_bus_ticket:

                try {
                    id= obj.GetCustid(email);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("custid",id);
                Fragment BusTicketFragment = new BusTicketFragment();
                BusTicketFragment.setArguments(bundle2);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        BusTicketFragment).commit();
                break;
            case R.id.nav_bus_gallery:

                Fragment Cust_Gallery = new Customer_Gallery();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        Cust_Gallery).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}