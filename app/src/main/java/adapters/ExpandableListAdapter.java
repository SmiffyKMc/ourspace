package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.foxwing.kieranmcc.ourspace.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import beans.Moon;

/**
 * Created by KieranMcc on 17/10/2015.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> titles;
    private HashMap<String, List<Moon>> items;
    private List<Integer> planetImages, moonImages;
    private int moons = 0;

    public ExpandableListAdapter(Context context, List<String> titles, HashMap<String, List<Moon>> items){
        this.context = context;
        this.titles = titles;
        this.items = items;
        this.setPlanetImages();
        this.setMoonImages();
    }

    private void setMoonImages(){
        moonImages = new ArrayList<>();
        moonImages.add(R.drawable.phobos);
        moonImages.add(R.drawable.phobos);
        moonImages.add(R.drawable.deimos);
        moonImages.add(R.drawable.io);
        moonImages.add(R.drawable.europa);
        moonImages.add(R.drawable.ganymede);
        moonImages.add(R.drawable.callisto);
        moonImages.add(R.drawable.mimas);
        moonImages.add(R.drawable.enceladus);
        moonImages.add(R.drawable.tethys);
        moonImages.add(R.drawable.dione);
        moonImages.add(R.drawable.rhea);
        moonImages.add(R.drawable.titan);
        moonImages.add(R.drawable.hyperion);
        moonImages.add(R.drawable.iapetus);
        moonImages.add(R.drawable.phoebe);
        moonImages.add(R.drawable.miranda);
        moonImages.add(R.drawable.triton);

    }

    private void setPlanetImages(){
        planetImages = new ArrayList<>();
        planetImages.add(R.drawable.earth_home_picture);
        planetImages.add(R.drawable.mars_home_picture);
        planetImages.add(R.drawable.jupiter_home_picture);
        planetImages.add(R.drawable.saturn_home_picture);
        planetImages.add(R.drawable.uranus_home_picture);
        planetImages.add(R.drawable.neptune_home_picture);
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.items.get(this.titles.get(groupPosition)).get(childPosition);
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //final String childText = (String) getChild(groupPosition, childPosition);
        //final int childNum = (Integer)getChild(groupPosition, childPosition);
        final Moon moon = (Moon)getChild(groupPosition, childPosition);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.exp_listview_item, parent, false);
        }

        TextView text = (TextView)convertView.findViewById(R.id.item_text);
        text.setText(moon.getMoonName());

        ImageView moonImage = (ImageView)convertView.findViewById(R.id.moon_image);
        Picasso.with(context).load(moon.getMoonImage())
                .resize(80,80)
                .into(moonImage);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.items.get(this.titles.get(groupPosition))
                .size();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.titles.get(groupPosition);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.exp_listview_group, parent, false);
        }

        TextView headerText = (TextView)convertView.findViewById(R.id.planet_name);
        headerText.setText(headerTitle);
        ImageView planetImage = (ImageView)convertView.findViewById(R.id.planet_image);

        Picasso.with(context).load(planetImages.get(groupPosition))
                .resize(800, 800)
                .into(planetImage);

        return convertView;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public int getGroupCount() {
        return this.titles.size();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
