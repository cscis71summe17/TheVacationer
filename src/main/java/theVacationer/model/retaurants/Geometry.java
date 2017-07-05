
package theVacationer.model.retaurants;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Geometry {

    @SerializedName("bounds")
    private Bounds mBounds;
    @SerializedName("center")
    private Center mCenter;

    public Bounds getBounds() {
        return mBounds;
    }

    public void setBounds(Bounds bounds) {
        mBounds = bounds;
    }

    public Center getCenter() {
        return mCenter;
    }

    public void setCenter(Center center) {
        mCenter = center;
    }

}
