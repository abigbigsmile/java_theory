package jvm;

public class JVMArgs {

    private Object ref;

    public JVMArgs(){
        byte[] b = new byte[20 * 1024 * 1024];
    }

    public static void main(String[] args) {
        JVMArgs j1 = new JVMArgs();
        JVMArgs j2 = new JVMArgs();
        j1.ref = j2;
        j2.ref = j1;
        j1 = null;
        j2 = null;

    }

}
