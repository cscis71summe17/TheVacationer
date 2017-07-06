package theVacationer.model.gratuities;
/**
 * Created by Alexander Dmitryukov on 6/29/2017.
 */
public class GratuityNumbers {
    int id;
    int rate;

    public GratuityNumbers(String number,int id) {
        this.rate = Integer.parseInt(number);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }


    public void setRate(int number) {
        this.rate = number;
    }
}
