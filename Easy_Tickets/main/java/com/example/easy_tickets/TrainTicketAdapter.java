package com.example.easy_tickets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainTicketAdapter extends RecyclerView.Adapter<TrainTicketAdapter.ExampleViewHolder> {
    private ArrayList<TrainTicketItem> TrainTicketList;
    private TrainTicketAdapter.onItemClickListener mListener;
    public interface onItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(TrainTicketAdapter.onItemClickListener listener)
    {
        mListener=listener;
    }
    public TrainTicketAdapter(ArrayList<TrainTicketItem> TrainTripList1)
    {
        TrainTicketList=TrainTripList1;
    }
    @NonNull
    @Override
    public TrainTicketAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.trainticket_item,parent,false);
       TrainTicketAdapter.ExampleViewHolder evh=new TrainTicketAdapter.ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull TrainTicketAdapter.ExampleViewHolder holder, int position) {
       TrainTicketItem current=TrainTicketList.get(position);
        holder.train.setImageResource(current.getTrain());
        holder.source.setText(current.getSource());
        holder.destination.setText(current.getDestination());
        holder.date.setText(current.getDate());
        holder.time.setText(current.getTime());
        holder.totalfare.setText(Integer.toString(current.getTotalfare()));
    }

    @Override
    public int getItemCount() {
        return TrainTicketList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView train;
        private TextView source;
        private TextView destination;
        private TextView date;
        private TextView time;
        private TextView totalfare;
        public ExampleViewHolder(@NonNull View itemView, TrainTicketAdapter.onItemClickListener listener) {
            super(itemView);
            train=itemView.findViewById(R.id.trainicon);
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
