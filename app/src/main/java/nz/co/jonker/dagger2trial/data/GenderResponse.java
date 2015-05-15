package nz.co.jonker.dagger2trial.data;

/**
 * Created by datacom_mobile01 on 15/05/15.
 */
public class GenderResponse {
    String name;
    String gender;
    double probability;
    int count;

    public GenderResponse() {
    }

    public GenderResponse(String name, String gender, double probability, int count) {
        this.name = name;
        this.gender = gender;
        this.probability = probability;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GenderResponse{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", probability=" + probability +
                ", count=" + count +
                '}';
    }
}
