import java.io.*;

public class FileMainTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("D:/acfs/share/admin/datavas/log_apigw/neovas-api-logmtvp-db-2020-04-15.log");
        final BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        while (true) {
            Thread.sleep(1000);
            writer.write(111);
            writer.flush();
        }
    }
}
