package theVacationer;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.client.RestTemplate;
import theVacationer.model.Header;
import theVacationer.model.Model;
import theVacationer.model.landmarks.Landmark;
import theVacationer.model.landmarks.Places;
import theVacationer.model.retaurants.Restaurants;
import theVacationer.model.retaurants.Venue;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Peter on 7/2/2017.
 */
public class vacationerStepdefs {
  @Given("^I have a scenario$")
  public void iHaveAScenario() throws Throwable {
    //na
  }
  @When("^I run the tests$")
  public void iRunTheTests() throws Throwable {
    //na
  }

  @Then("^all the tests go green$")
  public void allTheTestsGoGreen() throws Throwable {
    //na
  }
  String country;
  String city;
  Places pl;
  Restaurants resto;

  @Given("^A specific location of Paris, France$")
  public void aSpecificLocationOfParisFrance() throws Throwable {
    String country = "France";
    String city = "Paris";
    resto = new Restaurants(country,city);
  }

  @When("^I chose to locate available restaurants$")
  public void iChoseToLocateAvailableRestaurants() throws Throwable {
    RestTemplate response = new RestTemplate();
    resto = response.getForObject(
      Restaurants.API_CALL+resto.city+","+resto.country,Restaurants.class);
  }

  @Then("^there are (\\d+) valid restaurants$")
  public void thereAreValidRestaurants(int arg0) throws Throwable {
    Iterator itr = resto.getResponse().getVenues().iterator();
    while(itr.hasNext()) {
      Venue venue = (Venue)itr.next();
      String name = venue.getName();
      String url = venue.getUrl();
      System.out.println(name + " " + url);
      assertNotNull(name);
    }
  }

  @Given("^a city \"([^\"]*)\" in \"([^\"]*)\"$")
  public void aCityIn(String arg0, String arg1) throws Throwable {
    country = arg1;
    city = arg0;
  }

  @When("^I chose to locate restaurant information$")
  public void iChoseToLocateRestaurantInformation() throws Throwable {
    resto = new Restaurants(country,city);
    RestTemplate response = new RestTemplate();
    resto = response.getForObject(
      Restaurants.API_CALL+resto.city+","+resto.country,Restaurants.class);
  }

  @Then("^the system should return the top \"([^\"]*)\" restaurants$")
  public void theSystemShouldReturnTheTopRestaurants(String arg0) throws Throwable {
    assertEquals(Integer.parseInt(arg0),resto.getResponse().getVenues().size());
  }
  @Given("^A specific landmark location in Paris, France$")
  public void aSpecificLandmarkLocationInParisFrance() throws Throwable {
    country = "France";
    city = "Paris";
  }

  @When("^I chose to locate top landmarks$")
  public void iChoseToLocateTopLandmarks() throws Throwable {
    pl = new Places(country,city, Model.getConnection().createStatement());
  }

  @Then("^there are (\\d+) valid landmarks$")
  public void thereAreValidLandmarks(int arg0) throws Throwable {
    Iterator itr = pl.getLandmarkHeaderList().iterator();
    Iterator itr_text = pl.getLandmarkList().iterator();
    while(itr.hasNext()) {
      String title = ((Header)itr.next()).title;
      String description = ((Landmark)itr_text.next()).toString();
      assertNotNull(title);
      assertNotNull(description);
    }
  }

  @When("^I chose to locate landmark information$")
  public void iChoseToLocateLandmarkInformation() throws Throwable {
    pl = new Places(country,city, Model.getConnection().createStatement());
  }

  @Then("^the system should return  \"([^\"]*)\" landmarks$")
  public void theSystemShouldReturnLandmarks(String arg0) throws Throwable {
    assertEquals(Integer.parseInt(arg0),pl.getLandmarkHeaderList().size());
  }
}