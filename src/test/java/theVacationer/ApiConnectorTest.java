package theVacationer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import theVacationer.model.ApiConnector;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by grigori on 7/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApiConnectorTest {

    public static final String BASE_URL = "baseUrl";

    public ApiConnectorTest() {
    }

    @Test
    public void getBaseRequestUrl() throws Exception {
        ApiConnector api = new ApiConnector(BASE_URL);
        assertEquals(BASE_URL, api.getBaseRequestUrl());
    }

    @Test
    public void setRequestParamsEmpty() throws Exception {
        ApiConnector api = new ApiConnector(BASE_URL);
        api.setParams(new TreeMap<String, String>());
        assertEquals("", api.getParamsString());
    }

    @Test
    public void setRequestParamsSingePair() throws Exception {
        ApiConnector api = new ApiConnector(BASE_URL);
        Map<String,String> paramMap = new TreeMap();
        paramMap.put("Param1", "Value1");
        api.setParams(paramMap);
        assertEquals("?Param1=Value1", api.getParamsString());
    }

    @Test
    public void setRequestParamsMultiPairs() throws Exception {
        ApiConnector api = new ApiConnector(BASE_URL);
        Map<String,String> paramMap = new TreeMap();
        paramMap.put("Param1", "Value1");
        paramMap.put("Param2", "Value2");
        api.setParams(paramMap);
        assertEquals("?Param1=Value1&Param2=Value2", api.getParamsString());
    }

    @Test
    public void getFullUrlTest() throws Exception {
        ApiConnector api = new ApiConnector(BASE_URL);
        Map<String,String> paramMap = new TreeMap();
        paramMap.put("Param1", "Value1");
        paramMap.put("Param2", "Value2");
        api.setParams(paramMap);
        assertEquals(BASE_URL+"?Param1=Value1&Param2=Value2", api.getFullUrl());
    }

}