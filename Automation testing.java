

Feature: Make My Trip - Login and Search Flight
        Scenario: User logs in and searches for a round-trip flight
        Given User is on the Make My Trip login page
        When User logs in with username "user@example.com" and password "password123"
        Then User is on the Make My Trip homepage
        When User searches for a round-trip flight from "New York" to "San Francisco"
        And User selects the fourth available flight
        And User fills in the passenger details
        Then User proceeds to the payment page
        2. Step Definitions (`MakeMyTripSteps.java`)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageobjects.LoginPage;
import pageobjects.HomePage;
import pageobjects.FlightSearchPage;
import pageobjects.PassengerDetailsPage;
public class MakeMyTripSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    FlightSearchPage flightSearchPage;
    PassengerDetailsPage passengerDetailsPage;
    @Given("User is on the Make My Trip login page")
    public void user_is_on_the_make_my_trip_login_page() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        loginPage = new LoginPage(driver);
    }
    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("User is on the Make My Trip homepage")
    public void user_is_on_the_make_my_trip_homepage() {
        homePage = new HomePage(driver);
        homePage.verifyHomePage();
    }
    @When("User searches for a round-trip flight from {string} to {string}")
    public void user_searches_for_a_round_trip_flight_from_to(String from, String to) {
        homePage.searchRoundTripFlight(from, to);
    }
    @When("User selects the fourth available flight")

    public void user_selects_the_fourth_available_flight() {
        flightSearchPage = new FlightSearchPage(driver);
        flightSearchPage.selectFourthFlight();
    }
    @When("User fills in the passenger details")
    public void user_fills_in_the_passenger_details() {
        passengerDetailsPage = new PassengerDetailsPage(driver);
        passengerDetailsPage.fillPassengerDetails();
    }
    @Then("User proceeds to the payment page")
    public void user_proceeds_to_the_payment_page() {
        passengerDetailsPage.proceedToPayment();
    }
}
```

        3. Page Object Model (POM) Classes
`LoginPage.java`
        ```java
package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("loginButton");
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
```
        `HomePage.java`
        ```java
package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;

    }
    By fromCity = By.id("fromCity");
    By toCity = By.id("toCity");
    By departureDate = By.id("departure");
    By returnDate = By.id("return");
    By searchButton = By.id("flights-search-btn");
    public void verifyHomePage() {
// Add assertions or checks to verify that the user is on the homepage
    }
    public void searchRoundTripFlight(String from, String to) {
        driver.findElement(fromCity).sendKeys(from);
        driver.findElement(toCity).sendKeys(to);
        driver.findElement(departureDate).click();
        driver.findElement(By.xpath("//div[@class='DayPicker-Date'][4]")).click();
        driver.findElement(returnDate).click();
        driver.findElement(By.xpath("//div[@class='DayPicker-Date'][10]")).click();
        driver.findElement(searchButton).click();
    }
}
```
        `FlightSearchPage.java`
        ```java
package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class FlightSearchPage {
    WebDriver driver;
    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    By fourthFlight = By.xpath("//div[@class='flight-list-container'][4]//button[@class='add-to-bag']");
    public void selectFourthFlight() {
        driver.findElement(fourthFlight).click();
    }
}
```
        `PassengerDetailsPage.java`
        ```java
package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PassengerDetailsPage {
    WebDriver driver;
    public PassengerDetailsPage(WebDriver driver) {
        this.driver = driver;

    }
    By firstName1 = By.id("traveller-first-name1");
    By lastName1 = By.id("traveller-last-name1");
    By gender1 = By.id("traveller-gender1");
    By age1 = By.id("traveller-age1");
    By firstName2 = By.id("traveller-first-name2");
    By lastName2 = By.id("traveller-last-name2");
    By gender2 = By.id("traveller-gender2");
    By age2 = By.id("traveller-age2");
    By firstName3 = By.id("traveller-first-name3");
    By lastName3 = By.id("traveller-last-name3");
    By gender3 = By.id("traveller-gender3");
    By age3 = By.id("traveller-age3");
    By proceedButton = By.id("proceed-button");
    public void fillPassengerDetails() {
        driver.findElement(firstName1).sendKeys("John");
        driver.findElement(lastName1).sendKeys("Doe");
        driver.findElement(gender1).sendKeys("Male");
        driver.findElement(age1).sendKeys("25");
        driver.findElement(firstName2).sendKeys("Jane");
        driver.findElement(lastName2).sendKeys("Doe");
        driver.findElement(gender2).sendKeys("Female");
        driver.findElement(age2).sendKeys("21");
        driver.findElement(firstName3).sendKeys("Peter");
        driver.findElement(lastName3).sendKeys("Doe");
        driver.findElement(gender3).sendKeys("Male");
        driver.findElement(age3).sendKeys("2");
    }
    public void proceedToPayment() {
        driver.findElement(proceedButton).click();
    }
}
