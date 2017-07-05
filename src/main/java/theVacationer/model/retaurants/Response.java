
package theVacationer.model.retaurants;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Response {

    @SerializedName("venues")
    private List<Venue> mVenues;

    public Response() {
    }

    public List<Venue> getVenues() {
        int i=1;
        for (Venue vn: mVenues) {
            vn.id = String.valueOf(i);
            i++;
        }
        return mVenues;
    }

    public void setVenues(List<Venue> venues) {
        mVenues = venues;
    }

}
