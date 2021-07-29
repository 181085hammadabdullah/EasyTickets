package com.example.easy_tickets;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = "BroadCast receiver Received the update";
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        Log.i("jjj","receiver");
    }
}
