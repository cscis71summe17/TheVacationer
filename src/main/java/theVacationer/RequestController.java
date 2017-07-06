package theVacationer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import theVacationer.model.ApiConnector;
import theVacationer.model.Model;
import theVacationer.model.geodata.*;
import theVacationer.model.landmarks.Landmarks;
import theVacationer.model.landmarks.Places;
import theVacationer.model.FourSquareApiResponse;
import theVacationer.model.retaurants.Venue;
import theVacationer.model.safetyInfo.SafetyInfo;
import theVacationer.model.safetyInfo.SafetyNumber;

@RestController
public class RequestController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/geodata")
    public Geodata getGeoData() {
        //Mocking Data add DB query
        //TODO Pete, please query from DB
        //To test RUN and in web browser go to http://localhost:8080/geodata

        Connection con = null;
        Geodata geoDataList = null;
        try {
            con = Model.getConnection();
            Countries c = new Countries(con.createStatement());
            Iterator itr = c.getCountryList().iterator();
            List<Country> countryList = new ArrayList<Country>();
            while(itr.hasNext()) {
                String country = (String)itr.next();
                Cities city = new Cities(country, con.createStatement());
                List<String > cityList = city.getCityList();
                Country mockCountry = new Country(country,cityList);
                countryList.add(mockCountry);
            }
            geoDataList = new Geodata(countryList);
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return geoDataList;
    }

    @RequestMapping("/landmarks")
    public Landmarks getLandmarks(@RequestParam(value="city") String city,
                                  @RequestParam(value="country")String country) throws Exception {
        //TODO Query Landmark from DB with country/city and return Landmarks instead of Country, Landmark class is empty
        //To test RUN and in web browser go to http://localhost:8080/landmarks?city=boston&country=USA
      Connection connection = Model.getConnection();
      Places pl = new Places(country,city, connection.createStatement());
      Landmarks landmarks = new Landmarks(pl.getLandmarkList(),pl.getLandmarkHeaderList());
      connection.close();
      return landmarks;
    }

    @RequestMapping("/safetyinfo")
    public List<SafetyNumber> getSafetyinfo(@RequestParam(value="country")String country) throws Exception {
        Connection con = null;
        con = Model.getConnection();
        List<SafetyNumber> sf = new SafetyInfo(country, con.createStatement()).getNumbers();
        if(con != null)
            con.close();
        return sf;
    }

    @RequestMapping("/reataurants")
    public List<Venue> getRestaurants(@RequestParam(value="city") String city,
                                   @RequestParam(value="country")String country) throws Exception {
        Connection con = null;
        RestTemplate response = new RestTemplate();



        String baseUrl = "https://api.foursquare.com/v2/venues/search";
        ApiConnector api = new ApiConnector(baseUrl);
        Map<String,String> paramMap = new TreeMap<String, String>();
        paramMap.put("query", "restaurant");
        paramMap.put("limit", "5");
        paramMap.put("v", "20170701");
        paramMap.put("client_id", "ZWDQ4TMCCPQD4EGPFXUU0B1S0A1ESD5ATWDAGSIQQ0MHIYQ5");
        paramMap.put("client_secret", "VTCW04XIPQYL3MWMNSLX3ZIIFGZXIY5IGOXGK35PJGXON1M1");
        paramMap.put("near", city+","+country);
        api.setParams(paramMap);
        
        FourSquareApiResponse fourSquareApiResponse = new FourSquareApiResponse(country, city, api);
        fourSquareApiResponse.queryApi();
        return fourSquareApiResponse.getResponse().getVenues();
    }

    @RequestMapping("/gratuities")
    public List<Integer> getGratuities(@RequestParam(value="country")String country) throws Exception {
        return new ArrayList<>();
    }
}

