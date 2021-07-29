package com.example.easy_tickets;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class Customer_Gallery extends Fragment {
    ImageView i1;
    ImageView i2;
    ImageView i3;
    ImageView i4;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.customer_gallery, container, false);
        i1= view.findViewById(R.id.img1);
        i2= view.findViewById(R.id.img2);
        i3= view.findViewById(R.id.img3);
        i4= view.findViewById(R.id.img4);
        imagedownloader myTask1 = new imagedownloader();
        imagedownloader myTask2 = new imagedownloader();
        imagedownloader myTask3 = new imagedownloader();
        imagedownloader myTask4 = new imagedownloader();
        Bitmap bitmapImage;
        try {
            bitmapImage=myTask1.execute("https://www.sustainable-bus.com/wp-content/uploads/2019/11/img_9935-1-1024x768.jpg").get();
            i1.setImageBitmap(bitmapImage);
            bitmapImage=myTask2.execute("https://specials-images.forbesimg.com/imageserve/5f63a20a28a03215c0c57eaf/960x0.jpg").get();
            i2.setImageBitmap(bitmapImage);
            bitmapImage=myTask3.execute("https://innovationorigins.com/app/uploads/2018/05/VDL-Citea-SLFA-Electric-1004x671.jpg").get();
            i3.setImageBitmap(bitmapImage);
            bitmapImage=myTask4.execute("http://www.kamyonum.com.tr/haber_resim/Elazig-Receives-The-Domestic-Production-Electric-Bus-Sileo-32056.jpg").get();
            i4.setImageBitmap(bitmapImage);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return view;
    }

public class imagedownloader extends AsyncTask<String,Void, Bitmap>
{

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            URL url=new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream=connection.getInputStream();
            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
            return bitmap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
}
