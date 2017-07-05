package theVacationer.model.geodata;

import java.util.List;

/**
 * Created by Alexander Dmitryukov on 6/28/2017.
 */
public class Geodata {
    List<Country> geoData;

    public Geodata(List<Country> geoData) {
        this.geoData = geoData;
    }

    public List<Country> getGeodataList() {
        return geoData;
    }

    public void setGeodataList(List<Country> geoData) {
        this.geoData = geoData;
    }
}
