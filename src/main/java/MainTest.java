import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) throws IOException {
//        String v = "";
//        StringBuilder response = new StringBuilder();
//        String request = "{\"Parameters\":{\"Parameter\":[{\"name\":\"CACHE_NAME\", \"value\":\"262_84936418773\"}]}}";
//        URL url = new URL("http://localhost:18080/sync/coh-cache");
//        URLConnection connection = url.openConnection();
//        connection.setConnectTimeout(10000);
//        HttpURLConnection httpConn = (HttpURLConnection) connection;
//
//        httpConn.setRequestMethod("POST");
//        httpConn.setRequestProperty("Content-Type", "application/json");
//        httpConn.setRequestProperty("Accept", "application/json");
//
//        httpConn.setDoOutput(true);
//        httpConn.setDoInput(true);
//        httpConn.setUseCaches(false);
//
//        OutputStream out = httpConn.getOutputStream();
//        out.write(request.getBytes());
//        out.flush();
//        out.close();
//
//        httpConn.connect();
//
//        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
//        BufferedReader in = new BufferedReader(isr);
//
//        String value = null;
//        while ((value = in.readLine()) != null) {
//            response.append(value);
//        }
//        in.close();
//        v = response.toString();
//        System.out.println(v);

        Map<String, String> data = new HashMap<>();
        data.put("ss", null);
        System.out.println(data.get("ss"));
    }
}
