import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlingDemo {

    public static void main(String[] args) {

        // STEP 1: WRITE DATA INTO FILE
        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.write("Java File Handling Task\n");
            writer.write("Task 1 - CODTECH Internship\n");
            writer.close();
            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println("Error while writing file");
        }

        // STEP 2: READ DATA FROM FILE
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            System.out.println("\nReading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }

        // STEP 3: APPEND DATA TO FILE
        try {
            FileWriter writer = new FileWriter("data.txt", true);
            writer.write("File updated successfully\n");
            writer.close();
            System.out.println("\nData appended successfully");
        } catch (IOException e) {
            System.out.println("Error while appending file");
        }
    }
}
