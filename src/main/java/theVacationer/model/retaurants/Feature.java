
package theVacationer.model.retaurants;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Feature {

    @SerializedName("cc")
    private String mCc;
    @SerializedName("displayName")
    private String mDisplayName;
    @SerializedName("geometry")
    private Geometry mGeometry;
    @SerializedName("highlightedName")
    private String mHighlightedName;
    @SerializedName("id")
    private String mId;
    @SerializedName("longId")
    private String mLongId;
    @SerializedName("matchedName")
    private String mMatchedName;
    @SerializedName("name")
    private String mName;
    @SerializedName("slug")
    private String mSlug;
    @SerializedName("woeType")
    private Long mWoeType;

    public String getCc() {
        return mCc;
    }

    public void setCc(String cc) {
        mCc = cc;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public Geometry getGeometry() {
        return mGeometry;
    }

    public void setGeometry(Geometry geometry) {
        mGeometry = geometry;
    }

    public String getHighlightedName() {
        return mHighlightedName;
    }

    public void setHighlightedName(String highlightedName) {
        mHighlightedName = highlightedName;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getLongId() {
        return mLongId;
    }

    public void setLongId(String longId) {
        mLongId = longId;
    }

    public String getMatchedName() {
        return mMatchedName;
    }

    public void setMatchedName(String matchedName) {
        mMatchedName = matchedName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public Long getWoeType() {
        return mWoeType;
    }

    public void setWoeType(Long woeType) {
        mWoeType = woeType;
    }

}
