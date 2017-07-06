package theVacationer.model.safetyInfo;

/**
 * Created by Alexander Dmitryukov on 6/29/2017.
 */
public class SafetyNumber {
    int id;
    String number;
    String description;
    int tip;

    public SafetyNumber(String number, String description, String tip, int id) {
        this.number = number;
        this.description = description;
        this.tip = Integer.parseInt(tip);
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

    public String getDescription() {
        return description;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
