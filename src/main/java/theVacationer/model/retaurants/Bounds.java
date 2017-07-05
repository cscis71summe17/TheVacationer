
package theVacationer.model.retaurants;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Bounds {

    @SerializedName("ne")
    private Ne mNe;
    @SerializedName("sw")
    private Sw mSw;

    public Ne getNe() {
        return mNe;
    }

    public void setNe(Ne ne) {
        mNe = ne;
    }

    public Sw getSw() {
        return mSw;
    }

    public void setSw(Sw sw) {
        mSw = sw;
    }

}
