package beans;

import java.io.Serializable;

/**
 * Created by KieranMcc on 24/10/2015.
 */
public class Astronaut implements Serializable {
    private String name, nationality;
    private int daysInSpace, astronautImage;

    public Astronaut(){

    }

    public Astronaut(String name, String nationality, int daysInSpace, int astronautImage){
        this.setName(name);
        this.setNationality(nationality);
        this.setDaysInSpace(daysInSpace);
        this.setAstronautImage(astronautImage);
    }

    public void setAstronautImage(int astronautImage) {
        this.astronautImage = astronautImage;
    }

    public int getAstronautImage() {
        return astronautImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getDaysInSpace() {
        return daysInSpace;
    }

    public void setDaysInSpace(int daysInSpace) {
        this.daysInSpace = daysInSpace;
    }
}
