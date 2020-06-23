import java.io.*;

public class TestAppendFile {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt", true));
        writer.append("\nfjakfja;f");
        writer.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
