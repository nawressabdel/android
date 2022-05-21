package com.example.tp2gares;

import android.Manifest;
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

        menu.add(0,1,0,"numero-telephone");
        menu.add(0,2,0,"quitter");
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case 1 :
                if((ContextCompat.checkSelfPermission(GareActivity.this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)) {
                    requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, 5);
                }
                else{
                    Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:7134444"));
                    startActivity(i);
                break;}
            case 2:
                finish();
            }

            return super.onContextItemSelected(item);
        }
    }


