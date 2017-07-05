package theVacationer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Peter on 6/27/2017.
 */
public abstract class Model {
  public static final String JDBC_POSTGRESQL_CONNECTION_PATH = "jdbc:postgresql://ec2-34-229-149-121.compute-1.amazonaws.com:5432/vacation";
  public static final String POSTGRES_USER = "postgres";
  public static final String POSTGRES_VACATION = "vacation";
  public final String COUNTRY_TABLE = "Country";
  public final String SAFETYINFO_TABLE = "SafetyInfo";
  public final String CITY_TABLE = "City";
  //public final String FILE_PATH = "src/main/resources/vacationer.sqlite";

  //  public final String FILE_PATH = Model.class.getClassLoader().getResource( "vacationer.sqlite").getPath();
  public abstract ResultSet query(String query) throws Exception;

  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");
    Connection db = DriverManager.getConnection(
            JDBC_POSTGRESQL_CONNECTION_PATH, POSTGRES_USER, POSTGRES_VACATION);
    return db;
  }
}
