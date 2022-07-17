package encryptdecrypt.crypto;

public class ShiftCryptoMethod implements CryptoMethod {

    final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    final int length = alphabet.length();
    private final int shift;

    public ShiftCryptoMethod(int shift) {
        this.shift = shift;
    }

    @Override
    public char encrypt(char ch) {
        if (!Character.isLetter(ch)) {
            return ch;
        }
        char start = Character.isLowerCase(ch) ? 'a' : 'A';
        return (char) (start + (ch - start + shift) % length);
    }

    @Override
    public char decrypt(char ch) {
        if (!Character.isLetter(ch)) {
            return ch;
        }
        char start = Character.isLowerCase(ch) ? 'a' : 'A';
        return (char) (start + (length + ch - start - shift) % length);
    }
}
