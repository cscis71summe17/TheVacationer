package theVacationer;

/**
 * Created by grigori on 7/3/17.
 */
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

import java.sql.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import theVacationer.model.Model;
import theVacationer.model.geodata.Cities;
import theVacationer.model.geodata.Countries;
import theVacationer.model.safetyInfo.SafetyInfo;
import theVacationer.model.Header;
import theVacationer.model.landmarks.Landmark;
import theVacationer.model.landmarks.Places;

@RunWith(MockitoJUnitRunner.class)
public class ModelUnitTests {

    public static final String FRANCE = "France";
    public static final String PARIS = "Paris";
    public static final String MARSELLE = "Marselle";
    public static final String LYON = "Lyon";
    public static final String SPAIN = "Spain";
    public static final String GERMANY = "Germany";
    public static final String MUNICH = "Munich";
    public static final String ALL_SERIVCES = "All Serivces";
    public static final String POLICE = "Police";
    public static final String MEDICAL_HELP = "Medical Help";
    public static final String FIRST_SAFETY_NUMBER = "111";
    public static final String SECOND_SAFETY_NUMBER = "222";
    public static final String THIRD_SAFETY_NUMBER = "333";
    public static final String FIRST_LANDMARK_DESCRIPTION = "The highest place in the city";
    public final String COUNTRY_TABLE = "Country";
    public final String SAFETYINFO_TABLE = "SafetyInfo";

    @Test
    public void cityTestIndexVerification() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);


            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Cities ct = new Cities(stringSample, s);

            verify(rs, times(1)).getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cityTestQueryVerification() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);
            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.next()).thenReturn(true).thenReturn(false);

            String str =
                    "SELECT A.name FROM  City AS A, Country AS B WHERE A.country_id = B.id AND B.name LIKE 'France';";

            Cities ct = new Cities(stringSample, s);

            verify(s, times(1)).executeQuery(str);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cityTestMultiCityNotNulltMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn(PARIS)
                    .thenReturn(MARSELLE)
                    .thenReturn(LYON);

            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            Cities ct = new Cities(stringSample, s);
            assertNotNull(ct);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cityTestMultiCityPresentMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn(PARIS)
                    .thenReturn(MARSELLE)
                    .thenReturn(LYON);

            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            Cities ct = new Cities(stringSample, s);
            assertTrue(ct.getCityList().contains(PARIS));
            assertTrue(ct.getCityList().contains(MARSELLE));
            assertTrue(ct.getCityList().contains(LYON));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cityTestFranceCapitalPresentMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.getString(1)).thenReturn(PARIS);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Cities ct = new Cities(stringSample, s);
            assertNotNull(ct);
            assertTrue(ct.getCityList().contains(PARIS));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestNotNullMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.getString(2)).thenReturn(stringSample);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Countries ct = new Countries(s);
            assertNotNull(ct);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestPresentMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.getString(2)).thenReturn(stringSample);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Countries ct = new Countries(s);
            assertTrue(ct.getCountryList().contains(stringSample));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestExactSizedMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.getString(2)).thenReturn(stringSample);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Countries ct = new Countries(s);
            assertNotNull(ct);
            assertTrue(ct.getCountryList().size() == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestMultiCountryPresentMocked() {
        try {

            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(2))
                    .thenReturn(FRANCE)
                    .thenReturn(SPAIN)
                    .thenReturn(GERMANY);

            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            Countries ct = new Countries(s);
            assertNotNull(ct);
            assertTrue(ct.getCountryList().contains(GERMANY));
            assertTrue(ct.getCountryList().contains(SPAIN));
            assertTrue(ct.getCountryList().contains(FRANCE));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestQueryVerification() {
        try {
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);
            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.next()).thenReturn(true).thenReturn(false);

            String str =
                    "SELECT * FROM Country;";

            Countries ct = new Countries(s);

            verify(s, times(1)).executeQuery(str);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyinfoTestIndexVerification() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);


            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.next()).thenReturn(true).thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);

            verify(rs, times(1)).getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void landmarksTestQueryVerification() {
        try {
            String country = GERMANY;
            String city = MUNICH;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);
            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.next()).thenReturn(true).thenReturn(false);

            String str =
                    "SELECT A.name, A.description FROM Landmarks AS A, Country AS B, City AS C WHERE A.country_id = B.id AND A.city_id = C.id AND B.name = 'Germany' AND C.name = 'Munich';";

            Places ct = new Places(country, city, s);

            verify(s, times(1)).executeQuery(str);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestQueryVerification() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);
            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.next()).thenReturn(true).thenReturn(false);

            String str ="SELECT A.number, A.description " +
                    "FROM  " + SAFETYINFO_TABLE + " AS A, " + COUNTRY_TABLE + " AS B " +
                    "WHERE A.country_id = B.id AND B.name LIKE '" + stringSample + "';";
            SafetyInfo ct = new SafetyInfo(stringSample, s);

            verify(s, times(1)).executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void landmarkSinglePlaceHeaderVerification() {
        try {
            String country = FRANCE;
            String city = PARIS;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.getString(1)).thenReturn("Tower");
            when(rs.next()).thenReturn(true).thenReturn(false);

            Places ct = new Places(country, city, s);

            assertNotNull(ct);
            assertTrue(ct.getLandmarkHeaderList().contains(new Header(1, "Tower")));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoNotNullMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn(ALL_SERIVCES)
                    .thenReturn(POLICE)
                    .thenReturn(MEDICAL_HELP);


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertNotNull(ct);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestDescriptionNotEmptyMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn(ALL_SERIVCES)
                    .thenReturn(POLICE)
                    .thenReturn(MEDICAL_HELP);


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertTrue(ct.getNumbers().size()>0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestDescriptionPresentMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(2))
                    .thenReturn(ALL_SERIVCES)
                    .thenReturn(POLICE)
                    .thenReturn(MEDICAL_HELP);


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertTrue(ct.getNumbers().get(0).getDescription().contains(ALL_SERIVCES));
            assertTrue(ct.getNumbers().get(1).getDescription().contains(POLICE));
            assertTrue(ct.getNumbers().get(2).getDescription().contains(MEDICAL_HELP));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestNumberPresentMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn(FIRST_SAFETY_NUMBER)
                    .thenReturn(SECOND_SAFETY_NUMBER)
                    .thenReturn(THIRD_SAFETY_NUMBER);


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertTrue(ct.getNumbers().get(0).getNumber().contains(FIRST_SAFETY_NUMBER));
            assertTrue(ct.getNumbers().get(1).getNumber().contains(SECOND_SAFETY_NUMBER));
            assertTrue(ct.getNumbers().get(2).getNumber().contains(THIRD_SAFETY_NUMBER));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestFullInfoPresentMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn(FIRST_SAFETY_NUMBER);

            when(rs.getString(2))
                    .thenReturn(POLICE);


            when(rs.next()).thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertTrue(ct.getNumbers().get(0).getNumber().contains(FIRST_SAFETY_NUMBER));
            assertTrue(ct.getNumbers().get(0).getDescription().contains(POLICE));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void landmarkSinglePlaceDescriptionVerification() {
        try {
            String country = FRANCE;
            String city = PARIS;

            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1)).thenReturn(FIRST_LANDMARK_DESCRIPTION);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Places ct = new Places(country, city, s);

            assertNotNull(ct);
            assertTrue(ct.getLandmarkList().contains(new Landmark(FIRST_LANDMARK_DESCRIPTION)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestNumbersNotNullMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn(ALL_SERIVCES)
                    .thenReturn(POLICE)
                    .thenReturn(MEDICAL_HELP);


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertNotNull(ct.getNumbers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestNumbersPresentMocked() {
        try {
            String stringSample = FRANCE;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn(ALL_SERIVCES)
                    .thenReturn(POLICE)
                    .thenReturn(MEDICAL_HELP);


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertNotNull(ct.getNumbers().get(0).getNumber());
            assertNotNull(ct.getNumbers().get(1).getNumber());
            assertNotNull(ct.getNumbers().get(2).getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void landmarkTestIndexVerification() {
        try {
            String country = FRANCE;
            String city = PARIS;
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);


            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Places ct = new Places(country, city, s);

            verify(rs, times(1)).getString(1);
            verify(rs, times(1)).getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}