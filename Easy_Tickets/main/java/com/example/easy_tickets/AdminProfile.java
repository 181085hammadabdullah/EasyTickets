package com.example.easy_tickets;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.sql.SQLException;

public class AdminProfile extends Fragment {
    private String email;
    private TextView inputPassword,inputEmail,inputName,inputphone,inputaddress,inputbalance;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_profile, container, false);
        email = getArguments().getString("email");
        inputPassword=rootView.findViewById(R.id.inputPassword);
        inputEmail=rootView.findViewById(R.id.inputEmail);
        inputName=rootView.findViewById(R.id.inputName);
        inputphone=rootView.findViewById(R.id.inputphone);
        inputaddress=rootView.findViewById(R.id.inputaddress);

        Customer obj=new Customer(getActivity());
        try {
            Customer obj1=obj.getAdminprofile(email);
            inputPassword.setText(obj1.getPassword());
            inputEmail.setText(obj1.getEmail());
            inputaddress.setText(obj1.getAddress());
            inputName.setText(obj1.getName());
            inputphone.setText(obj1.getPhone());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Button b1 = (Button) rootView.findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Fragment Edit_profileFragment = new AdminEditProfile();
                Bundle bundle = new Bundle();
                bundle.putString("email",email);
                Edit_profileFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, Edit_profileFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rootView;
    }
}
