package encryptdecrypt.crypto;

public class UnicodeCryptoMethod implements CryptoMethod {

    private final int shift;
    public UnicodeCryptoMethod(int shift) {
        this.shift = shift;
    }

    @Override
    public char encrypt(char ch) {
        return (char) (ch + shift);
    }

    @Override
    public char decrypt(char ch) {
        return (char) (ch - shift);
    }
}
