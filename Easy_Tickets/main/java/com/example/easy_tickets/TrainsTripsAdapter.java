package com.example.easy_tickets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainsTripsAdapter extends RecyclerView.Adapter<TrainsTripsAdapter.ExampleViewHolder> {
    private ArrayList<TrainsTrip_item> BusTripList;
    private onItemClickListener mListener;
    public interface onItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener)
    {
        mListener=listener;
    }
    public TrainsTripsAdapter(ArrayList<TrainsTrip_item> BusTripList1)
    {
        BusTripList=BusTripList1;
    }
    @NonNull
    @Override
    public TrainsTripsAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.buses_trips_item,parent,false);
        ExampleViewHolder evh=new TrainsTripsAdapter.ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull TrainsTripsAdapter.ExampleViewHolder holder, int position) {
        TrainsTrip_item currentitem = BusTripList.get(position);
        holder.train.setImageResource(currentitem.getTrain());
        holder.source.setText(currentitem.getSource());
        holder.destination.setText(currentitem.getDestination());
        holder.date.setText(currentitem.getDate());
        holder.time.setText(currentitem.getTime());
        holder.Train.setText(currentitem.getTrain2());
    }

    @Override
    public int getItemCount() {
        return BusTripList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView train;
        private TextView source;
        private TextView destination;
        private TextView date;
        private TextView time;
        private TextView Train;
        public ExampleViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);
            train=itemView.findViewById(R.id.busicon);
            source=itemView.findViewById(R.id.source1);
            destination=itemView.findViewById(R.id.dest1);
            date=itemView.findViewById(R.id.date1);
            time=itemView.findViewById(R.id.time1);
            Train=itemView.findViewById(R.id.Agency1);
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
