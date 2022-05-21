package com.example.tp2gares;

import android.annotation.SuppressLint;
import android.app.backup.BackupAgent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    ListView ls;

    ArrayList<HashMap<String, String>> values = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls = findViewById(R.id.lst);


        map = new HashMap<String, String>();
        map.put("Name", "Monastir");
        map.put("subtitle", "Gares");
        map.put("img", String.valueOf(R.mipmap.monastir));
        values.add(map);

        map = new HashMap<String, String>();
        map.put("Name", "Mahdia");
        map.put("subtitle", "Gares");
        map.put("img", String.valueOf(R.mipmap.mahdia));
        values.add(map);

        map = new HashMap<String, String>();
        map.put("Name", "Sousse");
        map.put("subtitle", "Gares");
        map.put("img", String.valueOf(R.mipmap.sousse));
        values.add(map);

        map = new HashMap<String, String>();
        map.put("Name", "Sfax");
        map.put("subtitle", "Gares");
        map.put("img", String.valueOf(R.mipmap.sfax));
        values.add(map);

        map = new HashMap<String, String>();
        map.put("Name", "Tunis");
        map.put("subtitle", "Gares");
        map.put("img", String.valueOf(R.mipmap.tunis));
        values.add(map);


        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, values, R.layout.custom, new String[]{"Name", "subtitle", "img"}, new int[]{R.id.Name, R.id.subtitle, R.id.img});

        ls.setAdapter(adapter);

        registerForContextMenu(ls);
        View inst = findViewById(R.id.snfctaction);


        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView t = view.findViewById(R.id.Name);
                Intent i = new Intent(MainActivity.this, GareActivity.class);
                i.putExtra("name", t.getText().toString());

                startActivity(i);


            }


        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.setHeaderTitle("Select Action");

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.snfctaction:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sncft.com.tn/"));
                startActivity(i);
                return true;
            case R.id.gareaction:
                Intent a = new Intent(getApplicationContext(), GareActivity.class);
                startActivity(a);
                return true;
        }
        return super.onContextItemSelected(item);
    }

}
