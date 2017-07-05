
package theVacationer.model.retaurants;

import javax.annotation.Generated;
import javax.jws.WebParam;

import com.google.gson.annotations.SerializedName;
import org.springframework.web.client.RestTemplate;
import theVacationer.model.Model;

import java.sql.ResultSet;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Restaurants extends Model {

    @SerializedName("response")
    private Response mResponse;
    public String country;
    public String city;
    public static final String API_CALL =
      "https://api.foursquare.com/v2/venues/search?query=restaurant&limit=5&v=20170701&client_id=ZWDQ4TMCCPQD4EGPFXUU0B1S0A1ESD5ATWDAGSIQQ0MHIYQ5&client_secret=VTCW04XIPQYL3MWMNSLX3ZIIFGZXIY5IGOXGK35PJGXON1M1&near=";

    public Restaurants() {
    }
    public Restaurants(String country,String city) {
        this.country = country;
        this.city = city;
    }

    public Response getResponse() {
        return mResponse;
    }

    public void setResponse(Response response) {
        mResponse = response;
    }

    @Override
    public ResultSet query(String query) throws Exception {
        return null;
    }
}
