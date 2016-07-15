package com.foxwing.kieranmcc.ourspace;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import beans.Moon;

public class MoonInfoActivity extends AppCompatActivity {
    private Moon moon;
    private ImageView moonImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon_info);

        if(getIntent().getExtras() != null){
            moon = (Moon)getIntent().getSerializableExtra("moon");
        } else {
            moon = new Moon();
            moon.setMoonName("Moon");
            moon.setMoonInfo("Moon");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(moon.getMoonName());
        collapsingToolbar.setBackgroundResource(android.R.color.transparent);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        moonImage = (ImageView)findViewById(R.id.moon_picture);
        moonImage.setImageResource(moon.getMoonImage());

        TextView moonText = (TextView)findViewById(R.id.moon_information);
        moonText.setText(moon.getMoonInfo());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
