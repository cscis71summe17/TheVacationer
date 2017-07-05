
package theVacationer.model.retaurants;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Geocode {

    @SerializedName("feature")
    private Feature mFeature;
    @SerializedName("parents")
    private List<Object> mParents;
    @SerializedName("what")
    private String mWhat;
    @SerializedName("where")
    private String mWhere;

    public Feature getFeature() {
        return mFeature;
    }

    public void setFeature(Feature feature) {
        mFeature = feature;
    }

    public List<Object> getParents() {
        return mParents;
    }

    public void setParents(List<Object> parents) {
        mParents = parents;
    }

    public String getWhat() {
        return mWhat;
    }

    public void setWhat(String what) {
        mWhat = what;
    }

    public String getWhere() {
        return mWhere;
    }

    public void setWhere(String where) {
        mWhere = where;
    }

}
