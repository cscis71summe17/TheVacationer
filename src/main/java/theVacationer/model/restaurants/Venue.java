
package theVacationer.model.restaurants;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Venue {

    /*
    @SerializedName("categories")
    private List<Category> mCategories;
    */
    @SerializedName("location")
    private Location mLocation;

    @SerializedName("name")
    private String mName;
    @SerializedName("url")
    private String mUrl;

    private String address;

    @SerializedName("id")
    public String id;

    public Venue() {
    }


    /*
    dpublic List<Category> getCategories() {return mCategories;}

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }

    public Location getLocation() {
        return mLocation;
    }
*/
    public void setLocation(Location location) {
        mLocation = location;
        System.out.println(location.getAddress().toString());
        setAddress(mLocation.getAddress()+", "+
                mLocation.getCity()+", "+
                mLocation.getCountry()+" "+
                mLocation.getPostalCode() );
    }

    public void setAddress(String address) {
        this.address = address;
        System.out.println(address);
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUrl() {
        if(mUrl == null){
            mUrl = "";
        }
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getId() {
        return id;
    }

}
