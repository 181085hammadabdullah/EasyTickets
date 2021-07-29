package com.example.easy_tickets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AgencyProfileAdapterA extends RecyclerView.Adapter<AgencyProfileAdapterA.ExampleViewHolder> {
    private ArrayList<AgencyProfile_ItemA> Customers_list;
    private BusTripAdapter.onItemClickListener mListener;
    public interface onItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(BusTripAdapter.onItemClickListener listener)
    {
        mListener=listener;
    }
    public AgencyProfileAdapterA(ArrayList<AgencyProfile_ItemA> BusTripList1)
    {
       Customers_list=BusTripList1;
    }
    @NonNull
    @Override
    public AgencyProfileAdapterA.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_profile_item,parent,false);
        AgencyProfileAdapterA.ExampleViewHolder evh=new AgencyProfileAdapterA.ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull AgencyProfileAdapterA.ExampleViewHolder holder, int position) {
        AgencyProfile_ItemA currentitem = Customers_list.get(position);
        holder.image.setImageResource(currentitem.getImage());
        holder.name.setText(currentitem.getName());
        holder.email.setText(currentitem.getEmail());
        holder.phoneno.setText(currentitem.getPhoneno());

    }

    @Override
    public int getItemCount() {
       return Customers_list.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        private TextView name;
        private TextView email;
        private TextView phoneno;
        public ExampleViewHolder(@NonNull View itemView, BusTripAdapter.onItemClickListener listener) {
            super(itemView);
            image=itemView.findViewById(R.id.busicon);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            phoneno=itemView.findViewById(R.id.phone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
