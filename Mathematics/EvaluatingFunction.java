package codingblock.Mathematics;

import java.math.BigInteger;
import java.util.Scanner;

public class EvaluatingFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger x = sc.nextBigInteger();
        BigInteger ans = BigInteger.valueOf(4).multiply(x.pow(3)).add(BigInteger.valueOf(5).multiply(x.pow(2))).subtract(BigInteger.valueOf(6).multiply(x)).add(BigInteger.valueOf(14));
        System.out.println(ans);
    }
}
