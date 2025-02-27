@bookingE2ETest

Feature: End to End Booking Tests
  Scenario: To perform a CRUD operation on booking API

    Given user has access to endpoint "/auth/login"
    When user creates a auth token with login authentication as "admin" and "password"
    Then user should get the response code 200