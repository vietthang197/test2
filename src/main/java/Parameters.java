import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Parameters implements Serializable {
    @JsonProperty("Parameter")
    private List<Parameter> parameter;

    public Parameters(List<Parameter> parameter) {
        this.parameter = parameter;
    }

    public Parameters() {
    }

    public List<Parameter> getParameter() {
        return parameter;
    }

    public void setParameter(List<Parameter> parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"Parameters\":{\"Parameter\":")
                .append(parameter)
                .append("}}");
        return builder.toString();
    }
}
