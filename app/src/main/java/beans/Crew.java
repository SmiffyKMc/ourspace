package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by KieranMcc on 24/10/2015.
 */
public class Crew implements Serializable {
    private String flightName;
    private ArrayList<Astronaut> crew;
    private int crewImage;

    public Crew(){
        crew = new ArrayList<>();
    }

    public Crew(String flightName, ArrayList<Astronaut> crew, int crewImage){
        this.setFlightName(flightName);
        this.setCrew(crew);
        this.setCrewImage(crewImage);
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public ArrayList<Astronaut> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<Astronaut> crew) {
        this.crew = crew;
    }

    public void addCrewMember(Astronaut crewMember){
        this.getCrew().add(crewMember);
    }

    public void emptyCrew(){
        this.crew.clear();
    }

    public int getCrewImage() {
        return crewImage;
    }

    public void setCrewImage(int crewImage) {
        this.crewImage = crewImage;
    }
}
