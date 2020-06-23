import java.io.Serializable;
import java.util.Arrays;

public class DataBin implements Serializable {
    private String name;

    private String age;

    public DataBin() {
    }

    public DataBin(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DataBin{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
