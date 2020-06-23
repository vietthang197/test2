import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class MainJsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        List<Parameter> list = new ArrayList<>();
        list.add(new Parameter("CACHE_NAME", "3434343434"));
        Parameters parameters = new Parameters();
        parameters.setParameter(list);
        System.out.println(parameters);

        ObjectMapper objectMapper = new ObjectMapper();
        CohgwCacheResult result = objectMapper.readValue("{\n" +
                "    \"STATUS\": \"1\",\n" +
                "    \"STATUS_MESSAGE\": \"SUCCESS\",\n" +
                "    \"Parameters\": {\n" +
                "        \"Parameter\": [\n" +
                "            {\n" +
                "                \"name\": \"MSISDN\",\n" +
                "                \"value\": \"84936418773\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"SERVICE_ID\",\n" +
                "                \"value\": \"262\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}", CohgwCacheResult.class);
        System.out.println(result);
    }
}
