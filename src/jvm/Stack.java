package jvm;

public class Stack {

    public static void ref(){
        System.out.println("");
        ref();
    }

    public static void main(String[] args) {
        ref();
    }
}
