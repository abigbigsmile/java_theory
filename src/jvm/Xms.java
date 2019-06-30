package jvm;

public class Xms {

    public static void main(String[] args) {

        byte[] b1= new byte[2 * 1024 * 1024];
        byte[] b2= new byte[2 * 1024 * 1024];
        byte[] b3= new byte[2 * 1024 * 1024];

        System.gc();

    }
}
