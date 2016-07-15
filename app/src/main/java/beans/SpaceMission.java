package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by KieranMcc on 24/10/2015.
 */
public class SpaceMission implements Serializable {
    private String missionName;
    private int years, flights, insigniaImage, cost;
    private Crew crew;
    private ArrayList<Rocket> rockets;

    public SpaceMission(){

    }

    public SpaceMission(String missionName, int insigniaImage, Crew crew){
        this.setMissionName(missionName);
        this.setInsigniaImage(insigniaImage);
        this.setCrew(crew);
    }

    public SpaceMission(String missionName, int years, int flights, int insigniaImage, int cost, Crew crew, ArrayList<Rocket> rockets) {
        this.setMissionName(missionName);
        this.setYears(years);
        this.setFlights(flights);
        this.setInsigniaImage(insigniaImage);
        this.setCost(cost);
        this.setCrew(crew);
        this.setRockets(rockets);
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getFlights() {
        return flights;
    }

    public void setFlights(int flights) {
        this.flights = flights;
    }

    public int getInsigniaImage() {
        return insigniaImage;
    }

    public void setInsigniaImage(int insigniaImage) {
        this.insigniaImage = insigniaImage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public ArrayList<Rocket> getRockets() {
        return rockets;
    }

    public void setRockets(ArrayList<Rocket> rockets) {
        this.rockets = rockets;
    }

    public void addRocket(Rocket rocket){
        this.getRockets().add(rocket);
    }
}
