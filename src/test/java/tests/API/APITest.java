package tests.API;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.API.APISteps;

@ExtendWith(SerenityJUnit5Extension.class)
public class APITest {

    @Steps
    APISteps apiSteps;

    @Test
    public void getTest() {
        apiSteps.sendGetRequest(2);
        apiSteps.verifyStatusCode(200);
        apiSteps.verifyBodyArrayContains("data.first_name", "Lindsay");
        apiSteps.verifyBodyField("page", 2);
    }

    @Test
    public void postTest() {
        apiSteps.postCreateRandomUser();
        apiSteps.verifyStatusCode(201);
        apiSteps.verifyReturnedRandomName();
        apiSteps.verifyReturnedRandomJob();
    }
}
