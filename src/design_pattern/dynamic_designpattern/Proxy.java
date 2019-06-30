package design_pattern.dynamic_designpattern;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

//可以使用JavaPoet来生成源码文件
public class Proxy {

    public static Object newProxyInstance(Class interfaceName, InnovationHandler innovationHandler)throws Exception{

        Method[] methods = interfaceName.getMethods();
        String methodStr = "";
        for(Method method : methods){
            methodStr +=
                    "  @Override\n\n"+
                            "      public void "+method.getName()+"(){\n\n"+
                            "      try{\n\n"+
                            "      Method md = "+interfaceName.getName()+".class.getMethod(\""+method.getName()+"\");\n\n"+
                            "      innovationHandler.invoke(this, md);\n\n"+
                            "      }catch(Exception e){e.printStackTrace();}\n\n"+
                            "  }\n\n";
        }


        String src =
                "package design_pattern.dynamic_designpattern;\n\n"+

                "import java.lang.reflect.Method;\n\n"+

                        "public class WhateverProxy implements "+interfaceName.getName()+"{\n\n"+

                        "   private InnovationHandler innovationHandler;\n\n"+

                        "   public WhateverProxy(InnovationHandler innovationHandler) {\n\n"+
                        "       this.innovationHandler = innovationHandler;\n\n"+
                        "   }\n\n"+

                        methodStr+

                        "}\n\n";
        String fileName = System.getProperty("user.dir")+"/src/design_pattern.dynamic_designpattern/WhateverProxy.java";
//        System.out.println(fileName);
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(src);
        fileWriter.flush();
        fileWriter.close();

        //编译
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
//        System.out.println(javaCompiler.getClass().getName());
        StandardJavaFileManager standardJavaFileManager = javaCompiler.getStandardFileManager(null,null,null);
        Iterable units = standardJavaFileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask compilationTask = javaCompiler.getTask(null, standardJavaFileManager, null, null,null,units);
        compilationTask.call();
        standardJavaFileManager.close();

        //将class文件load进内存，再产生对象
        URL[] urls = new URL[]{new URL("file:/"+fileName)};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class clazz = urlClassLoader.loadClass("design_pattern.dynamic_designpattern.WhateverProxy");
        //因为构造方法有参数，不能直接用类生成实例
        Constructor constructor = clazz.getConstructor(InnovationHandler.class);
        Object o = constructor.newInstance(innovationHandler);
        return o;

    }
}
