package encryptdecrypt.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileDataWriter implements DataWriter {

    String fileName;

    FileDataWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(String data) {
        try {
            File file = new File(fileName);
            Files.writeString(file.toPath(), data);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
