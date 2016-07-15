package fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.foxwing.kieranmcc.ourspace.MoonInfoActivity;
import com.foxwing.kieranmcc.ourspace.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import adapters.ExpandableListAdapter;
import beans.Moon;


public class MoonsFragment extends Fragment {
    private List<String> titles;
    private HashMap<String, List<Moon>> items;
    private List<Moon> moons;

    public MoonsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_moons, container, false);

        this.prepareItems();

        ExpandableListView expandableListView = (ExpandableListView)v.findViewById(R.id.expListView);
        ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(getActivity(), titles, items);

        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnChildClickListener(new ChildClickListener());

        return v;
    }

    private void prepareItems(){

        titles = new ArrayList<String>();
        items = new HashMap<String, List<Moon>>();

        titles.add("Earth");
        titles.add("Mars");
        titles.add("Jupiter");
        titles.add("Saturn");
        titles.add("Uranus");
        titles.add("Neptune");

        List<Moon> earthsMoons = new ArrayList<Moon>();
        earthsMoons.add(new Moon("Earth", "Moon", "Nothing", R.drawable.phobos));

        List<Moon> marsMoons = new ArrayList<Moon>();
        marsMoons.add(new Moon("Mars", "Phobos", getResources().getString(R.string.mars_phobos), R.drawable.phobos));
        marsMoons.add(new Moon("Mars", "Deimos", getResources().getString(R.string.mars_deimos), R.drawable.deimos));

        List<Moon> jupitersMoons = new ArrayList<Moon>();
        jupitersMoons.add(new Moon("Jupiter", "IO", getResources().getString(R.string.jupiter_io), R.drawable.io));
        jupitersMoons.add(new Moon("Jupiter", "Europa", getResources().getString(R.string.jupiter_europa), R.drawable.europa));
        jupitersMoons.add(new Moon("Jupiter", "Ganymede", getResources().getString(R.string.jupiter_ganymede), R.drawable.ganymede));
        jupitersMoons.add(new Moon("Jupiter", "Callisto", getResources().getString(R.string.jupiter_callisto), R.drawable.callisto));

        List<Moon> saturnsMoons = new ArrayList<Moon>();
        saturnsMoons.add(new Moon("Saturn", "Mimas", getResources().getString(R.string.saturn_mimas), R.drawable.mimas));
        saturnsMoons.add(new Moon("Saturn", "Enceladus", getResources().getString(R.string.saturn_enceladus), R.drawable.enceladus));
        saturnsMoons.add(new Moon("Saturn", "Tethys", getResources().getString(R.string.saturn_tethys), R.drawable.tethys));
        saturnsMoons.add(new Moon("Saturn", "Dione", getResources().getString(R.string.saturn_dione), R.drawable.dione));
        saturnsMoons.add(new Moon("Saturn", "Rhea", getResources().getString(R.string.saturn_rhea), R.drawable.rhea));
        saturnsMoons.add(new Moon("Saturn", "Titan", getResources().getString(R.string.saturn_titan), R.drawable.titan));
        saturnsMoons.add(new Moon("Saturn", "Hyperion", getResources().getString(R.string.saturn_hyperion), R.drawable.hyperion));
        saturnsMoons.add(new Moon("Saturn", "Iapetus",getResources().getString(R.string.saturn_iapetus), R.drawable.iapetus));
        saturnsMoons.add(new Moon("Saturn", "Phoebe", getResources().getString(R.string.saturn_phoebe), R.drawable.phoebe));

        List<Moon> uranusMoons = new ArrayList<Moon>();
        uranusMoons.add(new Moon("Uranus", "Miranda", getResources().getString(R.string.uranus_miranda), R.drawable.miranda));

        List<Moon> neptunesMoons = new ArrayList<Moon>();
        neptunesMoons.add(new Moon("Neptune", "Triton", getResources().getString(R.string.neptune_triton), R.drawable.triton));


        items.put(titles.get(0), earthsMoons);
        items.put(titles.get(1), marsMoons);
        items.put(titles.get(2), jupitersMoons);
        items.put(titles.get(3), saturnsMoons);
        items.put(titles.get(4), uranusMoons);
        items.put(titles.get(5), neptunesMoons);
    }

    private class ChildClickListener implements ExpandableListView.OnChildClickListener {

        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            Toast.makeText(getActivity(), items.get(titles.get(groupPosition)).get(childPosition).getMoonName().toString(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getActivity(), MoonInfoActivity.class);

            switch (items.get(titles.get(groupPosition)).get(childPosition).getMoonName().toString()){
                case "Moon":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Phobos":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Deimos":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "IO":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Europa":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Ganymede":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Callisto":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Mimas":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Enceladus":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Tethys":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Dione":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Rhea":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Titan":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Hyperion":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Iapetus":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Phoebe":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Miranda":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                case "Triton":
                    i.putExtra("moon", (Moon)items.get(titles.get(groupPosition)).get(childPosition));
                    startActivity(i);
                    break;
                default:
                    startActivity(i);
            }

            return false;
        }
    }


}
