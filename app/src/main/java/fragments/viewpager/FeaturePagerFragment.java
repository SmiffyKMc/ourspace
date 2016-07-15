package fragments.viewpager;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
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
public class FeaturePagerFragment extends Fragment {
    private Planet planet;
    private ImageView featureImage;
    private TextView featureInformation;

    public FeaturePagerFragment() {
        // Required empty public constructor
    }

    public static FeaturePagerFragment newInstance(Planet planet) {

        Bundle args = new Bundle();
        args.putSerializable("planet", planet);
        FeaturePagerFragment fragment = new FeaturePagerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.viewpager_feature, container, false);

        planet = (Planet)getArguments().getSerializable("planet");

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout)v.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(planet.getPlanetFeatName());
        collapsingToolbar.setBackgroundResource(android.R.color.transparent);

        featureImage = (ImageView)v.findViewById(R.id.feature_picture);
        featureInformation = (TextView)v.findViewById(R.id.feature_information);

        featureImage.setImageResource(planet.getPlanetFeatImage());
        featureInformation.setText(planet.getPlanetFeature());

        return v;
    }


}
