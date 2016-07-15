package fragments.viewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foxwing.kieranmcc.ourspace.R;

import beans.Planet;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoViewPagerFragment extends Fragment {
    private String planetName, informationText;
    private TextView infoText;
    private Planet planet;


    public InfoViewPagerFragment() {
        // Required empty public constructor
    }

    public static InfoViewPagerFragment newInstance(Planet planet) {

        Bundle args = new Bundle();
        InfoViewPagerFragment fragment = new InfoViewPagerFragment();
        args.putSerializable("planet", planet);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        planetName = getArguments().getString("planetName");
        planet = (Planet)getArguments().getSerializable("planet");

        //setInfoText(planetName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.viewpager_info, container, false);

        infoText = (TextView)v.findViewById(R.id.info_text);
        infoText.setText(planet.getPlanetInfo());

        return v;
    }
}
