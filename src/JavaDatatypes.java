import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class JavaDatatypes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfInts = Integer.parseInt(bufferedReader.readLine());
        List<String> listNumberToBeOpInString = bufferedReader.lines()
                .limit(numberOfInts)
                .collect(Collectors.toList());

        listNumberToBeOpInString.forEach(i-> {
                    outPut(i, getBitLength(i));
                }
        );
    }

    public static int getBitLength(String inputString) {
        try {
            BigInteger bigInteger = new BigInteger(inputString);
            return bigInteger.bitLength();
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void outPut(String numberToBe, int bitCount) {
        if (bitCount > 63) {
            System.out.println(numberToBe + " can't be fitted anywhere.");
        } else {
            System.out.println(numberToBe + " can be fitted in:");
            if (bitCount > 31) {
                System.out.println("* long");
            } else if (bitCount > 15) {
                System.out.println("* int");
                System.out.println("* long");
            } else if (bitCount > 7) {
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
            } else {
                System.out.println("* byte");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
            }
        }
    }
}
