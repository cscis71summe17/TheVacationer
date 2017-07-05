package theVacationer.model.geodata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import theVacationer.model.Model;

import javax.swing.plaf.nimbus.State;

/**
 * Created by Peter on 6/27/2017.
 */
public class Cities extends Model {
  private final String COUNTRY_TABLE = "Country";
  private final String CITY_TABLE = "City";
  List<String> cityList;
  Statement statement;
  public Cities (String country, Statement st) {
    try {
      statement = st;
      cityList = new ArrayList<String>();
      ResultSet results = query(country);
      while (results.next()) {
        cityList.add(results.getString(1));
      }

    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  public ResultSet query(String query) throws Exception {
    String str =
      "SELECT A.name " +
      "FROM  " + CITY_TABLE + " AS A, " + COUNTRY_TABLE + " AS B " +
      "WHERE A.country_id = B.id AND B.name LIKE '" + query + "';";
    return statement.executeQuery(str);
  }

  public List<String> getCityList() {
    return cityList;
  }
}
