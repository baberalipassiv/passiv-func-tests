import common.pojos.schedule.Schedule;
import org.testng.annotations.Test;

public class HotWaterTests {


    @Test(priority = 1)
    public void turn_on_hot_water_boost(){

        // verify is on via prog_register
        // verify is on via hotwater/status

    }

    @Test(priority = 1)
    public void edit_hot_water_boost_duration_increase(){

        // verify prog_reg remaining min.
    }

    @Test(priority = 1)
    public void edit_hot_water_boost_duration_decrease(){

        // verify prog_reg remaining min
    }

}
