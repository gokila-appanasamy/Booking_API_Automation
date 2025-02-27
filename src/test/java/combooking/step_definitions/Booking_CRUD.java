package combooking.step_definitions;

import combooking.support.BookingUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;

import io.restassured.response.Response;

public class Booking_CRUD {
    Response response;
    JSONObject requestBody;
    BookingUtility bookingUtility;

    @Given("user has access to endpoint {string}")
    public void user_has_access_to_endpoint(String endpoint) {
        bookingUtility = new BookingUtility();
        bookingUtility.setEndPoint(endpoint);
    }

    @When("user creates a auth token with login authentication as {string} and {string}")
    public void user_creates_a_auth_token_with_login_authentication_as_and(String userName, String password) {
        JSONObject loginAuth = new JSONObject();
        loginAuth.put("username", userName);
        loginAuth.put("password", password);
        bookingUtility.response =
                        bookingUtility.
                        requestSetup().
                        body(loginAuth.toString())
                        .when().
                        post(bookingUtility.getEndPoint());

        Cookies allDetailedCookies = bookingUtility.response.detailedCookies();

        Cookie token = allDetailedCookies.get("token");
        bookingUtility.setToken(token);
    }

    @Then("user should get the response code {int}")
    public void user_should_get_the_response_code(Integer statusCode) {
        System.out.println(bookingUtility.response.getStatusCode());
        assertEquals(Long.valueOf(statusCode), Long.valueOf(bookingUtility.response.getStatusCode()));
    }

}
