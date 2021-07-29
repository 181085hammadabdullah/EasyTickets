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

import com.google.android.material.navigation.NavigationView;

import java.sql.SQLException;

public class AdminHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private  String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        setContentView(R.layout.activity_admin_home);
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
                Fragment profile = new AdminProfile();
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

                Bundle bundle2 = new Bundle();
                bundle2.putInt("custid",0);
                Fragment BusTicketFragment = new BusTicketFragment();
                BusTicketFragment.setArguments(bundle2);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        BusTicketFragment).commit();
                break;
            case R.id.nav_customer_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CustomerProfiles()).commit();
                break;
            case R.id.nav_agency_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AgencyProfiles()).commit();
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