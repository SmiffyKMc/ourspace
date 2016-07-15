package com.foxwing.kieranmcc.ourspace;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import adapters.MissionSpaceCrewAdapter;
import beans.Crew;
import beans.SpaceMission;

public class SpaceMissionActivity extends AppCompatActivity {
    private ArrayList<Crew> crew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_mission);

        crew = new ArrayList<>();

        SpaceMission mission = (SpaceMission)getIntent().getSerializableExtra("mission");

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        TextView missionText = (TextView)findViewById(R.id.insigniaName);
        ImageView missionImage = (ImageView)findViewById(R.id.insigniaImage);

        missionText.setText(mission.getMissionName());
        missionImage.setImageResource(mission.getInsigniaImage());

        // Recycler View section

        RecyclerView crewMembers = (RecyclerView)findViewById(R.id.crewRecyclerView);
        MissionSpaceCrewAdapter missionSpaceCrewAdapter = new MissionSpaceCrewAdapter(mission.getCrew());
        crewMembers.setAdapter(missionSpaceCrewAdapter);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        crewMembers.setLayoutManager(layoutManager);

        // End Recycler View section

        TextView missionDetail = (TextView)findViewById(R.id.mission_detail);
        missionDetail.setText(R.string.jupiter_callisto);

    }

}
