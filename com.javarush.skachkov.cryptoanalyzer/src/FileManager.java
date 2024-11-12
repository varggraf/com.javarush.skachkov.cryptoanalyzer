import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {

    
    public static boolean notEmptyFile(String fileName) {

        boolean notEmpty = true;
        
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {

            if(reader.read() == -1) {

                notEmpty = false;
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        return notEmpty;
    }
}
