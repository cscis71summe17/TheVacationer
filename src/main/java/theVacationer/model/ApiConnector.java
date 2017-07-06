package theVacationer.model;

import org.springframework.web.client.RestTemplate;
import theVacationer.model.retaurants.Restaurants;
import theVacationer.model.retaurants.RestaurantsData;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by grigori on 7/5/17.
 */
public class ApiConnector {
    public static final String PARAM_OPEN = "?";
    public static final String PARAM_CONNECTOR = "&";
    public static final String STR = "=";
    private String baseRequestUrl;
    private String paramsString;


    public ApiConnector(String baseRequestUrl) {
        this.baseRequestUrl = baseRequestUrl;
    }

    public String getBaseRequestUrl() {
        return baseRequestUrl;
    }

    public void setParams(Map<String, String> params) {
        Iterator it = params.entrySet().iterator();
        StringBuilder builder = new StringBuilder();
        boolean initialized = false;
        if(params.size() > 0) {
            builder.append(PARAM_OPEN);
            while (it.hasNext()) {
                if(initialized) {
                    builder.append(PARAM_CONNECTOR);
                }
                Map.Entry pair = (Map.Entry)it.next();
                builder.append(pair.getKey());
                builder.append(STR);
                builder.append(pair.getValue());
                initialized = true;
            }
        }
        paramsString = builder.toString();
    }

    public String getParamsString() {
        return paramsString;
    }

    public String getFullUrl() {
        return baseRequestUrl + paramsString;
    }

    public <T> T query(Class<T> type) {
        RestTemplate response = new RestTemplate();
        T data = null;
        data = response.getForObject(getFullUrl(),
                type);
        return data;
    }

}
