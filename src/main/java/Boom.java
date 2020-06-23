import java.io.IOException;
import java.nio.file.Files;

public class Boom {
    public static void main(String[] args) throws IOException {
        System.out.println( Files.createTempDirectory("xxxx").toAbsolutePath());
    }
}
