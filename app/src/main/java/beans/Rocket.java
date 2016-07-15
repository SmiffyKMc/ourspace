package beans;

/**
 * Created by KieranMcc on 24/10/2015.
 */
public class Rocket {
    private String rocketName;
    private int rocketImage;

    public Rocket(){

    }

    public Rocket(String rocketName, int rocketImage) {
        this.setRocketName(rocketName);
        this.setRocketImage(rocketImage);
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public int getRocketImage() {
        return rocketImage;
    }

    public void setRocketImage(int rocketImage) {
        this.rocketImage = rocketImage;
    }
}
