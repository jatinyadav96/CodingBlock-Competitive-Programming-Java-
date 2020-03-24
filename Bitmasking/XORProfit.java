package codingblock.Bitmasking;

import java.util.Scanner;

public class XORProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int max = maxXORInRange(l, r);
        System.out.println(max);
    }

    static int maxXORInRange(int L, int R) {
        return (int) (Math.pow(2, (int) (Math.log(L ^ R) / Math.log(2) + 1)) - 1);
    }
}
