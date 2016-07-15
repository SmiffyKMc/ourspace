package fragments.viewpager;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.foxwing.kieranmcc.ourspace.R;

import beans.Planet;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatsViewPagerFragment extends Fragment {
    private ImageView image;
    private TextView statsText;
    private Planet planet;


    public StatsViewPagerFragment() {
        // Required empty public constructor
    }

    public static StatsViewPagerFragment newInstance(Planet planet) {
        StatsViewPagerFragment fragment = new StatsViewPagerFragment();
        Bundle args = new Bundle();
        System.out.println(planet.getPlanetName());
        args.putSerializable("planet", planet);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        planet = (Planet)getArguments().getSerializable("planet");
        //setStatistics(planetName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.viewpager_stats, container, false);
        statsText = (TextView)v.findViewById(R.id.stats_text);
        image = (ImageView)v.findViewById(R.id.comparison_image);

        statsText.setText(planet.getPlanetStats());
        image.setBackgroundResource(planet.getPlanetCompImage());
        return v;
    }
}
