package encryptdecrypt.crypto;

public enum Mode {
    ENCRYPT, DECRYPT;

    public static Mode getMode(String name) {
        return switch (name) {
            case "enc" -> ENCRYPT;
            case "dec" -> DECRYPT;
            default -> null;
        };
    }
}
