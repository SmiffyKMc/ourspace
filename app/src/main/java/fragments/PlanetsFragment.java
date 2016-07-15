package fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.foxwing.kieranmcc.ourspace.R;

import adapters.PlanetListAdapter;
import beans.Planet;

import com.foxwing.kieranmcc.ourspace.BaseViewPagerFragment;

import java.util.ArrayList;

public class PlanetsFragment extends Fragment {
    private PlanetClickListener planetClickListener;
    private ArrayList<Planet> planets;

   /* public static PlanetsFragment newInstance(String param1, String param2) {
        PlanetsFragment fragment = new PlanetsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    } */

    public PlanetsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {
          //  mParam1 = getArguments().getString(ARG_PARAM1);
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        //}

        planets = new ArrayList<>();
        getPlanets();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_planets, container, false);

        ListView planetList = (ListView)v.findViewById(R.id.planets_list);

        PlanetListAdapter planetListAdapter = new PlanetListAdapter(getActivity(), planets);
        planetList.setAdapter(planetListAdapter);

        planetList.setOnItemClickListener(new PlanetClickListener());

        return v;
    }

    private void getPlanets(){
            planets.add(new Planet("Mercury", R.drawable.mercury_home_picture, R.drawable.comparison_mercury,
                    getResources().getString(R.string.stats_mercury), getResources().getString(R.string.information_mercury),
                    R.drawable.feature_mercury, "The Caloris Basin", getResources().getString(R.string.feature_mercury)));

            planets.add(new Planet("Venus", R.drawable.venus_home_picture, R.drawable.comparison_venus,
                    getResources().getString(R.string.stats_venus), getResources().getString(R.string.information_venus),
                    R.drawable.feature_venus, "Volcanic Sif Mons", getResources().getString(R.string.feature_venus)));

            planets.add(new Planet("Earth", R.drawable.earth_home_picture, R.drawable.earth_home_picture,
                    getResources().getString(R.string.stats_earth), getResources().getString(R.string.information_earth),
                    R.drawable.feature_earth, "Mount Everest", getResources().getString(R.string.feature_earth)));

            planets.add(new Planet("Mars", R.drawable.mars_home_picture, R.drawable.comparison_mars,
                    getResources().getString(R.string.stats_mars), getResources().getString(R.string.information_mars),
                    R.drawable.feature_mars, "Olympus Mons", getResources().getString(R.string.feature_mars)));

            planets.add(new Planet("Jupiter", R.drawable.jupiter_home_picture, R.drawable.comparison_jupiter,
                    getResources().getString(R.string.stats_jupiter), getResources().getString(R.string.information_jupiter),
                    R.drawable.feature_jupiter, "The Great Red Spot", getResources().getString(R.string.feature_jupiter)));

            planets.add(new Planet("Saturn", R.drawable.saturn_home_picture, R.drawable.comparison_saturn,
                    getResources().getString(R.string.stats_saturn), getResources().getString(R.string.information_saturn),
                    R.drawable.feature_saturn, "Saturn\'s Rings", getResources().getString(R.string.feature_saturn)));

            planets.add(new Planet("Uranus", R.drawable.uranus_home_picture, R.drawable.comparison_uranus,
                    getResources().getString(R.string.stats_uranus), getResources().getString(R.string.information_uranus),
                    R.drawable.feature_uranus, "Rings of Uranus", getResources().getString(R.string.feature_uranus)));

            planets.add(new Planet("Neptune", R.drawable.neptune_home_picture, R.drawable.comparison_neptune,
                    getResources().getString(R.string.stats_neptune), getResources().getString(R.string.information_neptune),
                    R.drawable.feature_neptune, "The Great Dark Spot", getResources().getString(R.string.feature_neptune)));

            // Needs to change
            planets.add(new Planet("Pluto", R.drawable.pluto_home_picture, R.drawable.pluto_home_picture,
                    "Null", "null", R.drawable.jupiter_home_picture, "The Caloris Basin", getResources().getString(R.string.feature_mercury)));
    }

    // Inner Class Listener for the Planets Fragment
    private class PlanetClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectPlanet(position);
        }

        // Finding which planet in the list view was clicked to be able to send to PlanetViewPager
        private void selectPlanet(int position){
            String planetName;
            Fragment fragment;
            Intent i = new Intent(getActivity(), BaseViewPagerFragment.class);
            i.putExtra("planet", planets.get(position));
            startActivity(i);

            Toast.makeText(getActivity(), planets.get(position).getPlanetName(), Toast.LENGTH_SHORT).show();
        }


    }
}
