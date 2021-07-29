package com.example.easy_tickets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BusTicketAdapter extends RecyclerView.Adapter<BusTicketAdapter.ExampleViewHolder> {
    private ArrayList<com.example.easy_tickets.BusTicketItem> BusTicketList;
    private com.example.easy_tickets.BusTicketAdapter.onItemClickListener mListener;
    public interface onItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(com.example.easy_tickets.BusTicketAdapter.onItemClickListener listener)
    {
        mListener=listener;
    }
    public BusTicketAdapter(ArrayList<com.example.easy_tickets.BusTicketItem> BusTripList1)
    {
        BusTicketList=BusTripList1;
    }

    @NonNull
    @Override
    public com.example.easy_tickets.BusTicketAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.busticket_item,parent,false);
        com.example.easy_tickets.BusTicketAdapter.ExampleViewHolder evh=new com.example.easy_tickets.BusTicketAdapter.ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.easy_tickets.BusTicketAdapter.ExampleViewHolder holder, int position) {
        com.example.easy_tickets.BusTicketItem current=BusTicketList.get(position);
        holder.bus.setImageResource(current.getBus());
        holder.source.setText(current.getSource());
        holder.destination.setText(current.getDestination());
        holder.date.setText(current.getDate());
        holder.time.setText(current.getTime());
        holder.totalfare.setText(Integer.toString(current.getTotalfare()));
    }

    @Override
    public int getItemCount() {
        return BusTicketList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView bus;
        private TextView source;
        private TextView destination;
        private TextView date;
        private TextView time;
        private TextView totalfare;


        public ExampleViewHolder(@NonNull View itemView, BusTicketAdapter.onItemClickListener listener) {
            super(itemView);
            bus=itemView.findViewById(R.id.busicon);
            source=itemView.findViewById(R.id.source1);
            destination=itemView.findViewById(R.id.dest1);
            date=itemView.findViewById(R.id.date1);
            time=itemView.findViewById(R.id.time1);
            totalfare=itemView.findViewById(R.id.totalfare1);
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
