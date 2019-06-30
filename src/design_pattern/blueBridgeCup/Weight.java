package design_pattern.blueBridgeCup;

import java.util.Scanner;

public class Weight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] a = new double[30][30];
        double min = 1000000;
        double max = 0;

        for (int i = 0; i < 29; i++) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        for (int i = 1; i < 30; i++) {
            for (int j = 0; j <= i; j++) {
                if (j != 0)
                    a[i][j] = a[i - 1][j - 1] / 2.0 + a[i - 1][j] / 2.0 + a[i][j];

                else
                    a[i][j] = a[i - 1][j] / 2.0 + a[i][j];
            }
        }
        for (int i = 0; i < 30; i++) {
            max = Math.max(max, a[29][i]);
            min = Math.min(min, a[29][i]);
        }
        for (int i = 0; i < 30; i++) {
            for(int j = 0; j < 30; j++){
                System.out.println(a[i][j]);
            }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println((long) (2086458231 * max / min));

    }
}
