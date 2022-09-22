package basic.binary;

public class BinaryConverter {
    public static void main(String[] args) {
        int i = 123;
        System.out.println("10진법 = " + i);
        System.out.println();

        // 10진수 > 2진수
        String binaryString = Integer.toBinaryString(i);
        System.out.println("binaryString = " + binaryString);
        // 2진수 > 10진수
        int binaryToDecimal = Integer.parseInt(binaryString, 2);
        System.out.println("binaryToDecimal = " + binaryToDecimal);
        System.out.println();

        // 10진수 > 8진수
        String octalString = Integer.toOctalString(i);
        System.out.println("octalString = " + octalString);
        // 8진수 > 10진수
        int octalToDecimal = Integer.parseInt(octalString, 8);
        System.out.println("octalToDecimal = " + octalToDecimal);
        System.out.println();

        // 10진수 > 16진수
        String hexString = Integer.toHexString(i);
        System.out.println("hexString = " + hexString);
        int hexToDecimal = Integer.parseInt(hexString, 16);
        System.out.println("hexToDecimal = " + hexToDecimal);


    }
}
