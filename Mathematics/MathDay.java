package codingblock.Mathematics;

import java.util.Scanner;

public class MathDay {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int j = 0;
        while (j < t) {
            int a = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            long result = a;
            for (int i = 2; i <= n; i++) {
                result = power(result, i, m) % m;
            }
            result %= m;
            System.out.println(result);
            j++;
        }
    }

    private static long power(long n, int p, int m) {
        if (p == 0) return 1;
        if (p == 1) return n;
        if (p % 2 == 0) {
            long w = power(n, p / 2, m) % m;
            return (w * w) % m;
        } else {
            long w = power(n, p - 1, m) % m;
            return (w * n) % m;
        }
    }
}
