package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by KieranMcc on 13/10/2015.
 */
public class Planet implements Serializable {
    private String planetName;
    private int planetHomeImage;
    private int planetCompImage;
    private int planetFeatImage;
    private String planetStats;
    private String planetInfo;
    private String planetFeature;
    private String planetFeatName;
    private ArrayList<Moon> moons;

    public Planet(){

    }

    public Planet(String planetName, int planetHomeImage, int planetCompImage, String planetStats, String planetInfo, int planetFeatImage
        , String planetFeatName, String planetFeature){
        this.setPlanetCompImage(planetCompImage);
        this.setPlanetHomeImage(planetHomeImage);
        this.setPlanetInfo(planetInfo);
        this.setPlanetName(planetName);
        this.setPlanetStats(planetStats);
        this.setPlanetFeatImage(planetFeatImage);
        this.setPlanetFeatName(planetFeatName);
        this.setPlanetFeature(planetFeature);
    }

    public ArrayList<Moon> getMoons (){
        return moons;
    }

    public void addMoon(Moon moon){
        moons.add(moon);
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getPlanetHomeImage() {
        return planetHomeImage;
    }

    public void setPlanetHomeImage(int planetHomeImage) {
        this.planetHomeImage = planetHomeImage;
    }

    public int getPlanetCompImage() {
        return planetCompImage;
    }

    public void setPlanetCompImage(int planetCompImage) {
        this.planetCompImage = planetCompImage;
    }

    public String getPlanetStats() {
        return planetStats;
    }

    public void setPlanetStats(String planetStats) {
        this.planetStats = planetStats;
    }

    public String getPlanetInfo() {
        return planetInfo;
    }

    public void setPlanetInfo(String planetInfo) {
        this.planetInfo = planetInfo;
    }

    public int getPlanetFeatImage() {
        return planetFeatImage;
    }

    public void setPlanetFeatImage(int planetFeatImage) {
        this.planetFeatImage = planetFeatImage;
    }

    public String getPlanetFeature() {
        return planetFeature;
    }

    public void setPlanetFeature(String planetFeature) {
        this.planetFeature = planetFeature;
    }

    public String getPlanetFeatName() {
        return planetFeatName;
    }

    public void setPlanetFeatName(String planetFeatName) {
        this.planetFeatName = planetFeatName;
    }
}
