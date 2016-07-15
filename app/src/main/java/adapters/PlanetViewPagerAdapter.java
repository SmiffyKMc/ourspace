package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import beans.Planet;
import fragments.viewpager.FeaturePagerFragment;
import fragments.viewpager.InfoViewPagerFragment;
import fragments.viewpager.StatsViewPagerFragment;

/**
 * Created by KieranMcc on 09/10/2015.
 */
public class PlanetViewPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_OF_PAGES = 3;
    private String planetName;
    private Planet planet;

    public PlanetViewPagerAdapter(FragmentManager fragmentManager, Planet planet){
        super(fragmentManager);
        this.planetName = planetName;
        this.planet = planet;
    }

    @Override
    public int getCount() {
        return NUM_OF_PAGES;
    }

    // Fragments to slide left or right for content
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                return StatsViewPagerFragment.newInstance(planet);
            case 1:
                return InfoViewPagerFragment.newInstance(planet);
            case 2:
                return FeaturePagerFragment.newInstance(planet);
        }
        return null;
    }
}
