package encryptdecrypt.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileDataReader implements DataReader {

    String fileName;

    public FileDataReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String read() {
        File file = new File(fileName);
        try {
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
