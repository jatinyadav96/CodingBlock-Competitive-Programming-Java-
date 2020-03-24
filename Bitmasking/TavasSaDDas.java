package codingblock.Bitmasking;

import java.util.Scanner;

public class TavasSaDDas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        int power = 1;
        int tr = 1;
        int rank = 0;
        while (n != 0) {
            int x = n % 10;
            if (x == 7)
                tr += (1 << i);
            n /= 10;
            power *= 2;
            rank += power;
            i++;
        }
        rank -= power;
        rank += tr;
        System.out.println(rank);
    }
}
