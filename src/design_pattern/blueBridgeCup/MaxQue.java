package design_pattern.blueBridgeCup;


import java.util.Scanner;

//求两个字符串的最大公共子序列
public class MaxQue {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int result = maxQue(s1, s2);
        System.out.println("result:" + result);
    }

    public static int maxQue(String s1, String s2){
        if(s1.length() == 0 || s2.length() == 0)return 0;
        if(s1.charAt(0) == s2.charAt(0)){
            s1 = s1.substring(1);
            s2 = s2.substring(1);
            return 1 + maxQue(s1, s2);
        }else{
            return Math.max(maxQue(s1.substring(1), s2),maxQue(s1, s2.substring(1)));
        }
    }
}
