package adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.foxwing.kieranmcc.ourspace.R;
import com.foxwing.kieranmcc.ourspace.SpaceMissionActivity;

import java.util.ArrayList;

import beans.SpaceMission;

/**
 * Created by KieranMcc on 24/10/2015.
 */
public class SpaceFlightAdapter extends RecyclerView.Adapter<SpaceFlightAdapter.ViewHolder> {
    private ArrayList<SpaceMission> missions;

    public SpaceFlightAdapter (ArrayList<SpaceMission> missions){
        this.missions = missions;
    }

    @Override
    public SpaceFlightAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View contentView = LayoutInflater.from(context).inflate(R.layout.adapter_spaceflight_recyclerview, parent, false);

        ViewHolder viewHolder = new ViewHolder(context, contentView, getMissions());

        return viewHolder;
    }

    public ArrayList<SpaceMission> getMissions(){
        return missions;
    }

    @Override
    public void onBindViewHolder(SpaceFlightAdapter.ViewHolder viewHolder, int position) {
        SpaceMission spaceMission = missions.get(position);

        TextView insigniaText = viewHolder.insigniaText;
        ImageView insigniaImage = viewHolder.insigniaImage;

        insigniaText.setText(spaceMission.getMissionName());
        insigniaImage.setImageResource(spaceMission.getInsigniaImage());
    }

    @Override
    public int getItemCount() {
        return missions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView insigniaImage;
        public TextView insigniaText;
        private Context context;
        private ArrayList<SpaceMission> missions;

        public ViewHolder (Context context, View itemView, ArrayList<SpaceMission> missions){
            super(itemView);
            this.context = context;
            this.missions = missions;
            insigniaImage = (ImageView)itemView.findViewById(R.id.insigniaImage);
            insigniaText = (TextView)itemView.findViewById(R.id.insigniaText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            SpaceMission spaceMission = missions.get(position);
            Intent i = new Intent(context, SpaceMissionActivity.class);
            i.putExtra("mission", spaceMission);
            context.startActivity(i);
            Toast.makeText(context, spaceMission.getMissionName().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
