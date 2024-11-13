package common.pojos.schedule;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Events {

    String day;
    String time;

    @JsonProperty("C")
    Integer C;

    String preset;
    String datetime;
    String usage;

   public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("C")
    public Integer getC() {
        return this.C;
    }

    @JsonProperty("C")
    public void setC(Integer C) {
        this.C = C;
    }

    public String getPreset() {
        return preset;
    }

    public void setPreset(String preset) {
        this.preset = preset;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getUsage() {
        return this.usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

}
