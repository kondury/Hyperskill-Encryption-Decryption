package encryptdecrypt;

import encryptdecrypt.crypto.*;
import encryptdecrypt.io.DataReader;
import encryptdecrypt.io.DataReaderFactory;
import encryptdecrypt.io.DataWriterFactory;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> params = prepareParams(args);

        Mode mode = Mode.getMode(params.getOrDefault("-mode", "enc"));
        if (mode == null) {
            System.out.println("Error: wrong mode!");
            return;
        }

        CryptoMethod cryptoMethod = CryptoMethodFactory.getCryptoMethod(params);
        Cryptographer cryptographer = new Cryptographer();
        cryptographer.setMode(mode);
        cryptographer.setMethod(cryptoMethod);

        String dataParam = params.getOrDefault("-data","");
        String inFileNameParam = params.getOrDefault("-in", null);
        DataReader dataReader = DataReaderFactory.getDataReader(dataParam, inFileNameParam);
        String data = dataReader.read();
        if (data == null) {
            System.out.println("Error in DataReader");
            return;
        }

        String result = cryptographer.process(data);

        String outFileNameParam = params.getOrDefault("-out", null);
        DataWriterFactory.getDataWriter(outFileNameParam).write(result);

    }

    public static Map<String, String> prepareParams(String[] args) {
        Map<String, String> params = new HashMap<>();

        boolean addParam = false;
        String key = null;
        for (String arg: args) {
            if (addParam) {
                params.put(key, arg);
                addParam = false;
            } else if (arg.startsWith("-")) {
                key = arg;
                addParam = true;
            }
        }

        return params;
//        return  IntStream.range(0, args.length / 2)
//                .mapToObj(i -> new Pair(args[i], args[i + 1]))
//                .collect(Collectors.toMap(t -> (String) t.getKey(), t -> (String) t.getValue()));
    }
}
