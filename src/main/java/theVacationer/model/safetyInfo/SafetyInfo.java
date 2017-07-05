package theVacationer.model.safetyInfo;

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
public class SafetyInfo extends Model {
    List<SafetyNumber> numbers;
    Statement statement;

    public SafetyInfo(String country, Statement st){
        try {
            statement = st;
            numbers = new ArrayList<SafetyNumber>();
            ResultSet results = query(country);
            int currentId = 1;
            while (results.next()) {
                SafetyNumber info = new SafetyNumber(results.getString(1),results.getString(2), currentId);
                numbers.add(info);
                currentId++;
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<SafetyNumber> getNumbers() {
        return numbers;
    }

    @Override
    public ResultSet query(String country) throws Exception {
        String str =
                "SELECT A.number, A.description " +
                        "FROM  " + SAFETYINFO_TABLE + " AS A, " + COUNTRY_TABLE + " AS B " +
                        "WHERE A.country_id = B.id AND B.name LIKE '" + country + "';";
        return statement.executeQuery(str);
    }

    public void setNumbers(List<SafetyNumber> numbers) {
        this.numbers = numbers;
    }
}
