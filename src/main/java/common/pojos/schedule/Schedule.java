package common.pojos.schedule;

import com.fasterxml.jackson.annotation.JsonInclude;
import common.pojos.DAO;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Schedule extends DAO {

    String type;
    String uri;
    Integer zone;
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

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
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

        this.layers = new ArrayList<>();
        this.layers.addAll(layers);
    }

}
