
package theVacationer.model.retaurants;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Category {

    @SerializedName("name")
    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
