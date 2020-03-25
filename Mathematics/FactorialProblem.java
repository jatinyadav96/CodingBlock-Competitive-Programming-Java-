package codingblock.Mathematics;

import java.util.Scanner;

public class FactorialProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            solve(n, k);
        }
    }

    private static void solve(int n, int k) {
        long c = 0;
        for (int i = n; i >= 1; i--) {
            if (i % k == 0) {
                c += CalculateK(i, k);
            }
        }
        System.out.println(c);
    }

    private static long CalculateK(int num, int k) {
        long x = 0;
        while (num % k == 0) {
            x++;
            num /= k;
        }
        return x;
    }
}
