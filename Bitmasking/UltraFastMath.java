package codingblock.Bitmasking;

import java.util.Scanner;

public class UltraFastMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            solve(s1, s2);
        }
    }

    private static void solve(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                sb.append("1");
            else
                sb.append("0");
        }
        System.out.println(sb.toString());
    }
}
