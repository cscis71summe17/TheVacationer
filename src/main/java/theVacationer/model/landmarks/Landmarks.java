package theVacationer.model.landmarks;

import java.util.List;
import theVacationer.model.Header;

/**
 * Created by Alexander Dmitryukov on 6/28/2017.
 */
public class Landmarks {
    List<Landmark> bodies;
    List<Header> header;

    public Landmarks(List<Landmark> landmarksList,List<Header> header) {
        this.bodies = landmarksList;
        this.header = header;
    }

    public List<Landmark> getBodies() {
        return bodies;
    }
    public List<Header> getHeader() {
        return header;
    }

    public void setbodies(List<Landmark> landmarksList) {
        this.bodies = landmarksList;
    }
    public void setHeader(List<Header> header) {
        this.header = header;
    }
}
