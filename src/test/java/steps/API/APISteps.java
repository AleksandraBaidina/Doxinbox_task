package steps.API;

import static net.serenitybdd.rest.SerenityRest.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.json.JSONObject;

public class APISteps {

    private Response response;
    private String name;
    private String job;

    @Step("Send get request with page number")
    @Given("Send get request with page number {int}")
    public void sendGetRequest(Integer pageNumber) {
        response = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .param("page", pageNumber)
                .accept(ContentType.JSON)
                .get();
    }

    @Step("Verify status code")
    @Then("Verify status code {int}")
    public void verifyStatusCode(int code) {
        response.then().statusCode(code);
    }

    @Step("Verify first_name")
    @Then("^Verify that first name ([a-zA-Z]+) is exist$")
    public void verifyBodyFirstNameContains(String value) {
        verifyBodyArrayContains("data.first_name", value);
    }

    @Step("Verify body contains field with value")
    @Given("^Verify body array contains ([a-zA-Z]+) with ([a-zA-Z]+)$")
    public void verifyBodyArrayContains(String field, String value) {
        response.then().body(field, Matchers.hasItem(value));
    }

    @Step("Verify value page")
    @Given("^Verify body contains field ([a-zA-Z]+) with numerical value (\\d+)$")
    public void verifyBodyField(String field, int value) {
        response.then().body(field, Matchers.equalTo(value));
    }

    @Step("Create user with random name and job")
    @Given("Create user with random name and job")
    public void postCreateRandomUser() {
        name = "name_" + RandomStringUtils.randomAlphabetic(3);
        job = "job_" + RandomStringUtils.randomAlphabetic(10);

        JSONObject reqBody = new JSONObject();
        reqBody.put("name", name);
        reqBody.put("job", job);

        response = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(reqBody.toString())
                .post();
    }

    @Step("Verify returned name")
    @Then("Verify returned name")
    public void verifyReturnedRandomName() {
        response.then().body("name", Matchers.equalTo(name));
    }

    @Step("Verify returned job")
    @Then("Verify returned job")
    public void verifyReturnedRandomJob() {
        response.then().body("job", Matchers.equalTo(job));
    }
}
