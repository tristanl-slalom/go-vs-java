import java.io.*;
import java.nio.file.*;

public class IOBenchmark {
    public static void main(String[] args) {
        System.out.printf("Java IO Performance Test%n");
        String filename = "testfile-java.txt";
        String content = "This is a line of text.\n";

        long start = System.currentTimeMillis();

        // Create the file
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filename);
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
            return;
        }

        // Buffered writer is much more time-efficient!
        try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < 1000000; i++) {
                writer.write(content);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return;
        }

        long writeDuration = System.currentTimeMillis() - start;
        System.out.printf("Write duration: %d ms%n", writeDuration);

        start = System.currentTimeMillis();

        // Read from file
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        long readDuration = System.currentTimeMillis() - start;
        System.out.printf("Read duration: %d ms%n", readDuration);
    }
}
