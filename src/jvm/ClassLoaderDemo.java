package jvm;

import java.io.InputStream;

public class ClassLoaderDemo{



    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = new ClassLoader(){
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream ins = this.getClass().getResourceAsStream(fileName);
                if(ins == null){
                    System.out.println("双亲委派。");
                    return super.loadClass(name);
                }
                try{
                    System.out.println("ClassLoader running !");
                    byte[] bytes = new byte[ins.available()];
                    ins.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                }catch (Exception e){
                    throw new ClassNotFoundException();
                }
            }
        };
        Object o = classLoader.loadClass("jvm.ClassLoaderDemo").newInstance();
        System.out.println(o.getClass());
        System.out.println(o instanceof ClassLoaderDemo);
    }


}
