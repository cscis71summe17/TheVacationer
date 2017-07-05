package theVacationer.model.landmarks;

/**
 * Created by Alexander Dmitryukov on 6/28/2017.
 */
public class Landmark {
    public String description;
    public Landmark(String desc) {
        description = desc;
    }
    @Override
    public String toString() {
        return description;
    }
}
