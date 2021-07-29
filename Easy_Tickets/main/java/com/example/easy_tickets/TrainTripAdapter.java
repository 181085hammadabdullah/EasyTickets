package com.example.easy_tickets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainTripAdapter extends RecyclerView.Adapter<TrainTripAdapter.ExampleViewHolder> {
    private ArrayList<TrainTripItem> TrainTripList;
    private onItemClickListener mListener;
    public interface onItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener)
    {
        mListener=listener;
    }
    public TrainTripAdapter(ArrayList<TrainTripItem> TrainTripList1)
    {
        TrainTripList=TrainTripList1;
    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.traintrip_item,parent,false);
        ExampleViewHolder evh=new ExampleViewHolder(v,mListener);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
       TrainTripItem currentitem = TrainTripList.get(position);
        holder.train.setImageResource(currentitem.getTrain());
        holder.source.setText(currentitem.getSource());
        holder.destination.setText(currentitem.getDestination());
        holder.date.setText(currentitem.getDate());
        holder.time.setText(currentitem.getTime());
        holder.Agency.setText(currentitem.getAgency());
    }

    @Override
    public int getItemCount() {
        return TrainTripList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView train;
        private TextView source;
        private TextView destination;
        private TextView date;
        private TextView time;
        private TextView Agency;
        public ExampleViewHolder(@NonNull View itemView,onItemClickListener listener) {
            super(itemView);
             train=itemView.findViewById(R.id.trainicon);
             source=itemView.findViewById(R.id.source2);
             destination=itemView.findViewById(R.id.dest2);
             date=itemView.findViewById(R.id.date2);
             time=itemView.findViewById(R.id.time2);
             Agency=itemView.findViewById(R.id.Agency2);
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
