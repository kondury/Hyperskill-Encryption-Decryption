package encryptdecrypt.crypto;

import java.util.stream.Collectors;

public class Cryptographer {

    private interface CharProcessor {
        char process(char ch);
    }

    private CryptoMethod method;

    private Mode mode;

    public Cryptographer() {
    }

    public void setMethod(CryptoMethod method) {
        this.method = method;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public String process(String source) {
        return switch (mode) {
            case DECRYPT -> process(source, method::decrypt);
            case ENCRYPT -> process(source, method::encrypt);
        };
    }

    private static String process(String source, CharProcessor charProcessor) {
        return source.chars()
                .mapToObj(code -> charProcessor.process((char) code))
                .map(Object::toString)
                .collect(Collectors.joining());

//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < source.length(); i++) {
//            builder.append(processor.process(source.charAt(i)));
//        }
//        return builder.toString();
    }
}