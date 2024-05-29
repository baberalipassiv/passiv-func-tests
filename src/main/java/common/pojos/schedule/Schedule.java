package common.pojos.schedule;

import common.pojos.DAO;

import java.util.ArrayList;

public class Schedule extends DAO {

    String type;
    String uri;
    int zone;
    String mode;
    ArrayList<Layers> layers;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public ArrayList<Layers> getLayers() {
        return layers;
    }

    public void setLayers(ArrayList<Layers> layers) {
        this.layers = layers;
    }

}
