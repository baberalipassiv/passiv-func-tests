package common.pojos.loglevel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import common.pojos.DAO;


public class LogS extends DAO {


    public String log_level;

    @JsonCreator
    public LogS(@JsonProperty("log_level") String log_level){
        this.log_level = log_level;
    }


    public String getLogLevel() {
        return log_level;
    }

    public void setLogLevel(String log_level) {
        this.log_level = log_level;
    }
}
