package encryptdecrypt.io;

public class StandardDataReader implements DataReader {

    String data;

    public StandardDataReader(String data) {
        this.data = data;
    }

    @Override
    public String read() {
        return data;
    }
}
