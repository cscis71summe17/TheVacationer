
package theVacationer.model.retaurants;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Menu {

    @SerializedName("anchor")
    private String mAnchor;
    @SerializedName("label")
    private String mLabel;
    @SerializedName("mobileUrl")
    private String mMobileUrl;
    @SerializedName("type")
    private String mType;
    @SerializedName("url")
    private String mUrl;

    public String getAnchor() {
        return mAnchor;
    }

    public void setAnchor(String anchor) {
        mAnchor = anchor;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public String getMobileUrl() {
        return mMobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        mMobileUrl = mobileUrl;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
