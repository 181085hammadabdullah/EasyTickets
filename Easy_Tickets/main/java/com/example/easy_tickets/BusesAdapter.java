package com.example.easy_tickets;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BusesAdapter extends RecyclerView.Adapter<BusesAdapter.ExampleViewHolder> {
    private ArrayList<BusItem> BusTicketList;
    private onItemClickListener mListener;

    public interface onItemClickListener
    {
        void onItemClick(int position);

    }
    public void setOnItemClickListener(onItemClickListener listener)
    {
        mListener=listener;
    }
    public BusesAdapter( ArrayList<BusItem> BusTripList1)
    {
        BusTicketList=BusTripList1;

    }

    @NonNull
    @Override
    public BusesAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_item,parent,false);
        ExampleViewHolder evh=new BusesAdapter.ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull BusesAdapter.ExampleViewHolder holder, int position) {
        BusItem current=BusTicketList.get(position);
        holder.bus.setImageResource(current.getBus());
        holder.company.setText(current.getCompany());
        holder.model.setText(current.getModel());
        holder.color.setText(current.getColor());
        holder.registration.setText(current.getRegistration());
        holder.seats.setText(Integer.toString(current.getSeats()));
    }

    @Override
    public int getItemCount() {
        return BusTicketList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView bus;
        private TextView company;
        private TextView model;
        private TextView color;
        private TextView registration;
        private TextView seats;

        public ExampleViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);
            bus = itemView.findViewById(R.id.busicon);
            company = itemView.findViewById(R.id.company);
            model = itemView.findViewById(R.id.model);
            color = itemView.findViewById(R.id.color);
            registration = itemView.findViewById(R.id.reg);
            seats = itemView.findViewById(R.id.seats);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
    }






