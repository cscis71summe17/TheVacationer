package theVacationer.model.retaurants;

/**
 * Created by grigori on 7/5/17.
 */

import com.google.gson.annotations.SerializedName;
import theVacationer.model.ApiConnector;
import theVacationer.model.Model;

import javax.annotation.Generated;
import java.sql.ResultSet;

import javax.annotation.Generated;
import javax.jws.WebParam;

import com.google.gson.annotations.SerializedName;
import org.springframework.web.client.RestTemplate;
import theVacationer.model.ApiConnector;
import theVacationer.model.Model;

import java.sql.ResultSet;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RestaurantsData extends Model {

    @SerializedName("response")
    private Response mResponse;
    public String country;
    public String city;

    public RestaurantsData() {

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

