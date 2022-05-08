package com.example.tp2gares;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.*;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

import java.util.HashMap;

public class GareActivity extends AppCompatActivity {
    TextView t1, t2;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gare);
        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
        }

        if (name.equals("Monastir")) {
            t1.setText(name);
            t2.setText("Gare 5020 Jemmel - MONASTIR");
        } else if (name.equals("Mahdia")) {
            t1.setText(name);
            t2.setText("mahdia zone touristique");
        } else if (name.equals("Sousse")) {
            t1.setText(name);
            t2.setText("sousse 4000 ");
        } else if (name.equals("Sfax")) {
            t1.setText(name);
            t2.setText("sfax centre-ville");
        } else if (name.equals("Tunis")) {
            t1.setText(name);
            t2.setText(" Farhat Hached tunis ");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,1,0,"remove");
        menu.add(0,2,0,"call");
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:



                break;
            case R.id.item2:
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:71334444"));
                startActivity(i);


                return super.onOptionsItemSelected(item);

        }
        return false;
    }




}
