package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.foxwing.kieranmcc.ourspace.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import beans.Planet;

/**
 * Created by KieranMcc on 08/10/2015.
 */
public class PlanetListAdapter extends ArrayAdapter {
    private ArrayList<Planet> planets;

    public PlanetListAdapter(Context context, ArrayList<Planet> planet){
        super(context, 0, planet);
        this.planets = planet;
        //collectPlanets(planet);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_planetlist, parent, false);

            viewHolder.planetImage = (ImageView)convertView.findViewById(R.id.planet_image);
            viewHolder.planetName = (TextView)convertView.findViewById(R.id.planet_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.planetName.setText(planets.get(position).getPlanetName());
        //viewHolder.planetImage.setBackgroundResource(planets.get(position).getPlanetHomeImage());

        Picasso.with(getContext()).load(planets.get(position).getPlanetHomeImage())
                .resize(800,800)
                .into(viewHolder.planetImage);

        return convertView;
    }

    private static class ViewHolder {
        ImageView planetImage;
        TextView planetName;
    }
}
