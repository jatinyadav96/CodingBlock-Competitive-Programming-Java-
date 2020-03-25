package codingblock.Mathematics;

import java.util.Scanner;

public class PowerLog {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(power(x, n));

//        System.out.println(pow(-1, 1, 20));
    }

    static int power(int n, int p) {
        if (p == 0) return 1;
        if (p == 1) return n;
        if (p % 2 == 0) {
            int w = power(n, p / 2);
            return w * w;
        } else {
            int w = power(n, p - 1);
            return w * n;
        }
    }

    public static int pow(int x, int n, int d) {
        long rem = 1;
        int check = 0;

        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if (x < 0) {
            x = Math.abs(x);
            if (n % 2 != 0) {
                check = 1;
            }
        }

        long temp = x % d;
        while (n != 0) {
            if (n % 2 != 0) {
                rem = (rem * temp) % d;
            }

            temp = temp * temp;
            temp = temp % d;

            n = n / 2;
            if (rem > d) {
                rem = rem % d;
            }
        }

        if (check == 1) {
            return d - (int) rem;
        }

        return (int) rem;
    }
}


