package codingblock.Bitmasking;

import java.util.Scanner;

public class IncredibleHulk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(Integer.bitCount(sc.nextInt()));
        }
    }
}
