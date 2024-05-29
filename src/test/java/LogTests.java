import common.pojos.loglevel.LogS;
import common.rest.request.RequestBuilder;
import common.rest.service.LogService;
import common.utils.HttpStatusCode;
import common.utils.MockProperties;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LogTests extends BaseTests{

    LogService logService;
    @BeforeSuite
    private void setup(){
        RequestBuilder requestBuilder = new RequestBuilder(MockProperties.hubAddress);
        logService = new LogService(requestBuilder);
    }

    @Test(priority = 1)
    public void set_hub_log_level(){
        Assert.assertEquals(logService.setLogLevel(new LogS("All")),
                HttpStatusCode.OK.getCode());
    }

    @Test(priority = 2)
    public void get_hub_log_level(){
        LogS level = logService.getLogLevel();
        Assert.assertEquals(level.getLogLevel(), "All");
    }

}
