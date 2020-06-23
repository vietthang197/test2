import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Parameter implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

    public Parameter() {
    }

    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{" )
            .append("\"name\":\"")
            .append(name)
            .append("\"")
            .append(", \"value\":\"")
            .append(value)
            .append("\"")
            .append("}");
        return builder.toString();
    }
}
