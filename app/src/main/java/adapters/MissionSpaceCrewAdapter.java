package adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.foxwing.kieranmcc.ourspace.R;

import java.util.ArrayList;

import beans.Astronaut;
import beans.Crew;

/**
 * Created by KieranMcc on 25/10/2015.
 */
public class MissionSpaceCrewAdapter extends RecyclerView.Adapter<MissionSpaceCrewAdapter.ViewHolder> {
    private Crew crew;

    public MissionSpaceCrewAdapter(Crew crew){
        this.crew = crew;
    }

    @Override
    public MissionSpaceCrewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_spacemission_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Astronaut astronaut = crew.getCrew().get(position);

        ImageView crewImage = holder.crewImage;
        TextView crewText = holder.crewText;

        crewImage.setImageResource(astronaut.getAstronautImage());
        crewText.setText(astronaut.getName());
    }

    @Override
    public int getItemCount() {
        return crew.getCrew().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView crewImage;
        public TextView crewText;

        public ViewHolder(View itemView){
            super(itemView);

            crewImage = (ImageView)itemView.findViewById(R.id.crewImage);
            crewText = (TextView)itemView.findViewById(R.id.crewText);
        }
    }
}
