package encryptdecrypt.io;

public class DataReaderFactory {
    public static DataReader getDataReader(String dataParam, String fileParam) {
        if (!dataParam.isEmpty()) {
            return new StandardDataReader(dataParam);
        } else if (fileParam != null) {
            return new FileDataReader(fileParam);
        } else {
            return new StandardDataReader("");
        }
    }
}
