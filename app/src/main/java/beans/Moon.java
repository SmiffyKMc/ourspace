package beans;

import java.io.Serializable;

/**
 * Created by KieranMcc on 16/10/2015.
 */
public class Moon implements Serializable {
    private String planetName;
    private String moonName;
    private String moonInfo;
    private int moonImage;

    public Moon (){

    }

    public Moon (String planetName, String moonName, String moonInfo, int moonImage){
        this.setPlanetName(planetName);
        this.setMoonName(moonName);
        this.setMoonInfo(moonInfo);
        this.setMoonImage(moonImage);
    }

    public String getPlanetName(){
        return planetName;
    }

    public void setPlanetName(String planetName){
        this.planetName = planetName;
    }

    public String getMoonName() {
        return moonName;
    }

    public void setMoonName(String moonName) {
        this.moonName = moonName;
    }

    public String getMoonInfo() {
        return moonInfo;
    }

    public void setMoonInfo(String moonInfo) {
        this.moonInfo = moonInfo;
    }

    public int getMoonImage() {
        return moonImage;
    }

    public void setMoonImage(int moonImage) {
        this.moonImage = moonImage;
    }
}
