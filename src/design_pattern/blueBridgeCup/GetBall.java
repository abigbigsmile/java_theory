package design_pattern.blueBridgeCup;

import java.util.Scanner;

public class GetBall {
    public static void main(String[] args){
        int m,n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int result = getBall(n, m);
        System.out.println(result);
    }


    public static int getBall(int n, int m){
        if(n < m)return 0;
        if(n == m || m == 0)return 1;
        else return getBall(n-1, m-1)+getBall(n, m-1);
    }
}
