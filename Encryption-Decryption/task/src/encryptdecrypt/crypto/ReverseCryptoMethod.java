package encryptdecrypt.crypto;

public class ReverseCryptoMethod implements CryptoMethod {

    final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    final int length = alphabet.length();

    public ReverseCryptoMethod() {
    }

    @Override
    public char encrypt(char ch) {
        return getOpposite(ch);
    }

    @Override
    public char decrypt(char ch) {
        return getOpposite(ch);
    }

    private char getOpposite(char ch) {
        return alphabet.indexOf(ch) >= 0 ? alphabet.charAt(length + 'a' - ch - 1) : ch;
    }
}
