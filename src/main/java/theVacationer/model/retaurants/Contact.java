
package theVacationer.model.retaurants;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Contact {

    @SerializedName("facebook")
    private String mFacebook;
    @SerializedName("facebookName")
    private String mFacebookName;
    @SerializedName("facebookUsername")
    private String mFacebookUsername;
    @SerializedName("formattedPhone")
    private String mFormattedPhone;
    @SerializedName("instagram")
    private String mInstagram;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("twitter")
    private String mTwitter;

    public String getFacebook() {
        return mFacebook;
    }

    public void setFacebook(String facebook) {
        mFacebook = facebook;
    }

    public String getFacebookName() {
        return mFacebookName;
    }

    public void setFacebookName(String facebookName) {
        mFacebookName = facebookName;
    }

    public String getFacebookUsername() {
        return mFacebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        mFacebookUsername = facebookUsername;
    }

    public String getFormattedPhone() {
        return mFormattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        mFormattedPhone = formattedPhone;
    }

    public String getInstagram() {
        return mInstagram;
    }

    public void setInstagram(String instagram) {
        mInstagram = instagram;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getTwitter() {
        return mTwitter;
    }

    public void setTwitter(String twitter) {
        mTwitter = twitter;
    }

}
