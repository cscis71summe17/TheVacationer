package theVacationer.model.gratuities;
/**
 * Created by Alexander Dmitryukov on 6/29/2017.
 */
public class GratuityNumbers {
    int id;
    String number;

    public GratuityNumbers(String number,int id) {
        this.number = number;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        this.number = number;
    }
}
