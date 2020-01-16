package com.kingjaehee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> Adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("current_Time");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        items=new ArrayList<String>();

        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        listview = (ListView)findViewById(R.id.listview);
        listview.setAdapter(Adapter);


    }
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.ac_button) {
            long now = System.currentTimeMillis();
            Date mDate = new Date(now);
            SimpleDateFormat simpledata = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String gettime = simpledata.format(mDate);
            items.add(gettime);
            Adapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
