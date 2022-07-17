package encryptdecrypt.crypto;

import java.util.Map;

public class CryptoMethodFactory {
    public static CryptoMethod getCryptoMethod(Map<String, String> params) {
        int keyParam = Integer.parseInt(params.getOrDefault("-key", "0"));
        String algParam = params.getOrDefault("-alg","shift");
        return "unicode".equals(algParam) ? new UnicodeCryptoMethod(keyParam) :
                new ShiftCryptoMethod(keyParam);
    }
}
