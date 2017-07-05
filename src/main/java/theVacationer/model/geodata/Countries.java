package theVacationer.model.geodata;

import theVacationer.model.Model;

import java.sql.*;
import java.util.*;

/**
 * Created by Peter on 6/27/2017.
 */
public class Countries extends Model {
  private final String COUNTRY_TABLE = "Country";
  private final String CITY_TABLE = "City";
  List<String> countryList;
  Statement statement;
  public Countries (Statement st) {
    try {
      statement = st;
      countryList = new ArrayList<String>();
      ResultSet results = query(null);
      while (results.next()) {
        countryList.add(results.getString(2));
      }

    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  public ResultSet query(String query) throws Exception {
    return statement.executeQuery("SELECT * FROM " + COUNTRY_TABLE + ";");
  }

  public List<String> getCountryList() {
    return countryList;
  }
}
