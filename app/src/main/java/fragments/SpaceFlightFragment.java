package fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foxwing.kieranmcc.ourspace.R;

import java.util.ArrayList;

import adapters.SpaceFlightAdapter;
import beans.Astronaut;
import beans.Crew;
import beans.SpaceMission;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpaceFlightFragment extends Fragment {
    private ArrayList<SpaceMission> missions;
    private ArrayList<Crew> crew;

    public SpaceFlightFragment() {
        missions = new ArrayList<>();
        crew = new ArrayList<>();
        this.createCrew();
        this.setMissions();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_spaceflight, container, false);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);

        SpaceFlightAdapter spaceFlightAdapter = new SpaceFlightAdapter(missions);

        recyclerView.setAdapter(spaceFlightAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return v;
    }

    private ArrayList<Crew> getCrew(){
        return crew;
    }

    // Sets the Missions to be seen in the Space Fragment.
    private void setMissions(){
        missions.add(new SpaceMission("Apollo", R.drawable.insignia_apollo_1, this.crew.get(0)));
        missions.add(new SpaceMission("Mercury", R.drawable.insignia_mercury_1, this.crew.get(1)));
        missions.add(new SpaceMission("Vostok", R.drawable.insignia_vostok_1, this.crew.get(2)));
        missions.add(new SpaceMission("Space Shuttle", R.drawable.insignia_spaceshuttle_1, this.crew.get(3)));
        missions.add(new SpaceMission("Voskhod", R.drawable.insignia_apollo_1, this.crew.get(4)));
        missions.add(new SpaceMission("Gemini", R.drawable.insignia_gemini_1, this.crew.get(5)));
        missions.add(new SpaceMission("Soyuz", R.drawable.insignia_soyuz_1, this.crew.get(6)));
        missions.add(new SpaceMission("Sky Lab", R.drawable.insignia_skylab_1, this.crew.get(7)));
        missions.add(new SpaceMission("Shenzhou", R.drawable.insignia_apollo_1, this.crew.get(8)));
    }

    // Creates the Crew of the space mission to be seen in SpaceActivity
    private void createCrew(){
        Crew crew1 = new Crew();
        crew1.addCrewMember(new Astronaut("Buzz Aldrin", "American", 10, R.drawable.astronaut_buzz_aldrin));
        crew1.addCrewMember(new Astronaut("Neil Armstrong", "American", 908, R.drawable.astronaut_neil_armstrong));
        crew1.addCrewMember(new Astronaut("Michael Collins", "American", 908, R.drawable.astronaut_michael_collins));
        this.getCrew().add(crew1);

        Crew crew2 = new Crew();
        crew2.addCrewMember(new Astronaut("Malcolm Scott Carpenter", "American", 10, R.drawable.astronaut_malcolm_carpenter));
        crew2.addCrewMember(new Astronaut("Alan Bartlett Shepard, Jr.", "American", 908, R.drawable.astronaut_alan_shepard));
        crew2.addCrewMember(new Astronaut("John Herschel Glenn, Jr.", "American", 908, R.drawable.astronaut_john_glenn));
        this.getCrew().add(crew2);

        Crew crew3 = new Crew();
        crew3.addCrewMember(new Astronaut("Yuri Gagarin", "Russian", 10, R.drawable.astronaut_yuri_gagarin));
        this.getCrew().add(crew3);

        Crew crew4 = new Crew();
        crew4.addCrewMember(new Astronaut("Thomas Akers", "American", 10, R.drawable.astronaut_thomas_akers));
        crew4.addCrewMember(new Astronaut("Kathryn C. Thornton", "American", 908, R.drawable.astronaut_kathryn_thornton));
        this.getCrew().add(crew4);

        Crew crew5 = new Crew();
        crew5.addCrewMember(new Astronaut("Aldrin", "American", 10, R.drawable.astronaut_buzz_aldrin));
        crew5.addCrewMember(new Astronaut("Lightyear", "Toy", 908, R.drawable.astronaut_buzz_lightyear));
        this.getCrew().add(crew5);

        Crew crew6 = new Crew();
        crew6.addCrewMember(new Astronaut("Aldrin", "American", 10, R.drawable.astronaut_buzz_aldrin));
        crew6.addCrewMember(new Astronaut("Lightyear", "Toy", 908, R.drawable.astronaut_buzz_lightyear));
        this.getCrew().add(crew6);

        Crew crew7 = new Crew();
        crew7.addCrewMember(new Astronaut("Aldrin", "American", 10, R.drawable.astronaut_buzz_aldrin));
        crew7.addCrewMember(new Astronaut("Lightyear", "Toy", 908, R.drawable.astronaut_buzz_lightyear));
        this.getCrew().add(crew7);

        Crew crew8 = new Crew();
        crew8.addCrewMember(new Astronaut("Aldrin", "American", 10, R.drawable.astronaut_buzz_aldrin));
        crew8.addCrewMember(new Astronaut("Lightyear", "Toy", 908, R.drawable.astronaut_buzz_lightyear));
        this.getCrew().add(crew8);

        Crew crew9 = new Crew();
        crew9.addCrewMember(new Astronaut("Aldrin", "American", 10, R.drawable.astronaut_buzz_aldrin));
        crew9.addCrewMember(new Astronaut("Lightyear", "Toy", 908, R.drawable.astronaut_buzz_lightyear));
        this.getCrew().add(crew9);
    }


}
