package codingblock.Mathematics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BostonNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Long, Integer> map = factorize(n);
        int fact = 0;
        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            fact += sumOfDigit(e.getKey()) * e.getValue();
        }
        int sum = sumOfDigit(n);
        if (sum == fact)
            System.out.println("1");
        else
            System.out.println("0");

    }

    public static int sumOfDigit(long n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static Map<Long, Integer> factorize(long n) {
        Map<Long, Integer> factors = new LinkedHashMap<>();
        for (long d = 2; n > 1; ) {
            int power = 0;
            while (n % d == 0) {
                ++power;
                n /= d;
            }
            if (power > 0) factors.put(d, power);
            ++d;
            if (d * d > n) {
                d = n;
            }
        }
        return factors;
    }
}
