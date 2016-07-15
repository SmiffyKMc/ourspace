package com.foxwing.kieranmcc.ourspace;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import fragments.AsteroidsFragment;
import fragments.MoonsFragment;
import fragments.PlanetsFragment;
import fragments.QuizFragment;
import fragments.SpaceFlightFragment;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerTitles;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String[] titles = new String[5];
        titles[0] = "Planets";
        titles[1] = "Moons";
        titles[2] = "Asteroids & Comets";
        titles[3] = "Space Flight";
        titles[4] = "Quiz";

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.abc_menu_hardkey_panel_mtrl_mult);
        ab.setDisplayHomeAsUpEnabled(true);

        drawerTitles = (ListView)findViewById(R.id.drawer);
        drawerTitles.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerTitles.setOnItemClickListener(new DrawerItemOnClickListener());

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setHomeButtonEnabled(true);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return false;
    }

    private class DrawerItemOnClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
            drawerLayout.closeDrawer(drawerTitles);
        }

        private void selectItem(int position){
            Fragment fragment;
            switch (position) {
                case 1:
                    fragment = new MoonsFragment();
                    break;
                case 2:
                    fragment = new AsteroidsFragment();
                    break;
                case 3:
                    fragment = new SpaceFlightFragment();
                    break;
                case 4:
                    fragment = new QuizFragment();
                    break;
                default:
                    fragment = new PlanetsFragment();

            }

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();


        }
    }
}
