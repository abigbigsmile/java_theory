package design_pattern.blueBridgeCup;

import java.util.Scanner;

//全排列
public class Permutation {

    static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] str = s.toCharArray();
        Perm(str, 0, str.length-1);
        System.out.println("result:" + count);
    }

    public static void Perm(char[] str, int begin, int end){
        //递归出口
        char temp;
        if(begin == end){
            System.out.println(str);
            count++;
            return;
        }
        else{
            for(int i = begin; i <= end; i ++){
                if(isEqual(str, begin, i)){
                    temp = str[begin];
                    str[begin] = str[i];
                    str[i] = temp;

                    Perm(str, begin+1, end);

                    temp = str[begin];
                    str[begin] = str[i];
                    str[i] = temp;
                }
            }
        }
    }

    //当所给字符串有相同字符时
    //例如：对122全排列时，第一个元素1与第二个元素2交换得到212；然后第一个元素1与第三个元素2交换，
    // 同样得到212，这种情况应该避免发生。所以在第一个元素与第三个元素交换之前，一定要检查第三个
    // 元素之前是否出现过，如果没有出现则执行交换；如果出现过则不进行交换。
    public static boolean isEqual(char[] str, int x, int y){
        for(int i = x; i < y; i++){
            if(str[i] == str[y])return false;
        }
        return true;
    }
}
