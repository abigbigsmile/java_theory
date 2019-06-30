package design_pattern.blueBridgeCup;

import java.util.Scanner;

public class CircleNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i*i+j*j <= n*n)ans++;
            }
        }
        System.out.println(ans*4);

    }
}
