package theVacationer.model.gratuities;

import theVacationer.model.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Dmitryukov on 6/29/2017.
 */
public class Gratuities extends Model {
    List<GratuityNumbers> numbers;
    Statement statement;

    public Gratuities(String country, Statement st){
        try {
            statement = st;
            numbers = new ArrayList<GratuityNumbers>();
            ResultSet results = query(country);
            int currentId = 1;
            while (results.next()) {
                GratuityNumbers info = new GratuityNumbers(results.getString(2), currentId);
                numbers.add(info);
                currentId++;
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<GratuityNumbers> getNumbers() {
        return numbers;
    }

    @Override
    public ResultSet query(String country) throws Exception {
        String str =
                "SELECT A.id, A.rate " +
                        "FROM  " + GRATUITIES_TABLE + " AS A, " + COUNTRY_TABLE + " AS B " +
                        "WHERE A.country_id = B.id AND B.name LIKE '" + country + "';";
        return statement.executeQuery(str);
    }

    public void setNumbers(List<GratuityNumbers> numbers) {
        this.numbers = numbers;
    }
}
