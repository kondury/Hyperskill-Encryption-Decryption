package encryptdecrypt.io;

public class DataWriterFactory {
    public static DataWriter getDataWriter(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            return new FileDataWriter(fileName);
        }
        return new StandartDataWriter();
    }
}
