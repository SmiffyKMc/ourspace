package com.foxwing.kieranmcc.ourspace;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.foxwing.kieranmcc.ourspace.R;

import java.util.ArrayList;

import adapters.PlanetViewPagerAdapter;
import beans.Planet;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseViewPagerFragment extends AppCompatActivity {
    private Planet planet;


    public BaseViewPagerFragment() {
        // Required empty public constructor

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_base);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        planet = (Planet)getIntent().getSerializableExtra("planet");


        ViewPager planetPager = (ViewPager)findViewById(R.id.viewPager);
        PlanetViewPagerAdapter planetViewPagerAdapter = new PlanetViewPagerAdapter(getSupportFragmentManager(), planet);
        planetPager.setAdapter(planetViewPagerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }


}
