import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CohgwCacheResult implements Serializable {

    @JsonProperty("STATUS")
    private String status;

    @JsonProperty("STATUS_MESSAGE")
    private String message;

    @JsonProperty("Parameters")
    private Parameters parameters;

    @Override
    public String toString() {
        return "CohgwCacheResult{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
