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
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Booking_CRUD {
    Response response;
    JSONObject requestBody;
    BookingUtility bookingUtility;

    @Given("user accesses endpoint {string}")
    public void user_accesses_endpoint(String endpoint) {
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

    @When("the user books a room with the mentioned booking details")
    public void the_user_books_a_room_with_the_mentioned_booking_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            int roomid = Integer.parseInt(generateRandomRoomId());
            bookingUtility.setRoomId(roomid);
            requestBody = createBookingRequestBody(row, roomid);
            response = bookingUtility.requestSetup().body(requestBody.toString()).when().post(bookingUtility.getEndPoint());
            validateBookingResponse(row.get("firstname"), row.get("lastname"), row.get("checkin"), row.get("checkout"));

            if (response.getStatusCode() == 201) {
                int bookingId = response.jsonPath().getInt("booking.bookingid");
                bookingUtility.setBookingId(bookingId);
            }
        }
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    private static String generateRandomRoomId() {

        final Random random = new Random();
        return String.valueOf(2000 + random.nextInt(900));

    }

    private JSONObject createBookingRequestBody(Map<String, String> row, int roomid) {

        return new JSONObject()
                .put("bookingid", 0)
                .put("roomid", roomid)
                .put("firstname", row.get("firstname"))
                .put("lastname", row.get("lastname"))
                .put("depositpaid", true)
                .put("email", row.get("email"))
                .put("phone", row.get("phone"))
                .put("bookingdates", new JSONObject()
                        .put("checkin", row.get("checkin"))
                        .put("checkout", row.get("checkout")));

    }

    private void validateBookingResponse(String firstname, String lastname, String checkin, String checkout) {

        Integer bookingId = response.jsonPath().getInt("bookingid");
        String responseFirstname = response.jsonPath().getString("booking.firstname");
        String responseLastname = response.jsonPath().getString("booking.lastname");
        String responseCheckin = response.jsonPath().getString("booking.bookingdates.checkin");
        String responseCheckout = response.jsonPath().getString("booking.bookingdates.checkout");

        Assert.assertNotNull("BookingID should not to be null",bookingId);
        assertEquals("First Name did not match", firstname, responseFirstname);
        assertEquals("Last Name did not match", lastname, responseLastname);
        assertEquals("Check in date did not match", checkin, responseCheckin);
        assertEquals("Checkout date did not match", checkout, responseCheckout);

    }
}