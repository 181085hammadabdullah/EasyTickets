package com.example.easy_tickets;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.sql.SQLException;

public class AdminEditProfile extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_edit_profile, container, false);
        String email = getArguments().getString("email");
        EditText inputPassword=rootView.findViewById(R.id.inputPassword);
        EditText inputEmail=rootView.findViewById(R.id.inputEmail);
        EditText inputName=rootView.findViewById(R.id.inputName);
        EditText inputphone=rootView.findViewById(R.id.inputphone);
        EditText inputaddress=rootView.findViewById(R.id.inputaddress);

        Customer obj=new Customer(getActivity());

        try {
            Customer obj1 =  obj.getAdminprofile(email);
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
                Toast.makeText(getActivity().getBaseContext(), "saving", Toast.LENGTH_SHORT).show();
                int result=0;
                if(inputEmail.getText().toString().length()>0 && inputPassword.getText().toString().length()>0 && inputName.getText().toString().length()>0 && inputphone.getText().toString().length()>0 && inputaddress.getText().toString().length()>0)
                {
                    Customer obj2=new Customer(inputName.getText().toString(),inputEmail.getText().toString(),inputPassword.getText().toString(),inputphone.getText().toString(),inputaddress.getText().toString());
                    obj2.setContext(getActivity());
                    try {
                        result=obj2.UpdateAdminProfile();
                        Log.i("Result",Integer.toString(result));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if (result==1){
                        Log.i("pppp","kkkkk");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Fragment Edit_profileFragment = new AdminProfile();
                                Bundle bundle = new Bundle();
                                bundle.putString("email",email);
                                Edit_profileFragment.setArguments(bundle);
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.fragment_container, Edit_profileFragment );
                                transaction.addToBackStack(null);
                                transaction.commit();
                            }
                        }, 3000);

                    }
                }


            }
        });
        return rootView;
    }

}