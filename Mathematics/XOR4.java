package codingblock.Mathematics;

import java.util.ArrayList;
import java.util.Scanner;

public class XOR4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        ArrayList<Long> al = new ArrayList<>();
        for (int i = 0; i < n; i++) al.add(sc.nextLong());

        if (n >= 130) {
            System.out.println("Yes");
        } else {
            boolean b = false;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        for (int l = k + 1; l < n; l++) {
                            if ((((al.get(i) ^ al.get(j)) ^ al.get(k)) ^ al.get(l)) == 0) {
                                System.out.println("Yes");
                                return;
                            }
                        }
                    }
                }
            }

            System.out.println("No");
        }
    }

}
