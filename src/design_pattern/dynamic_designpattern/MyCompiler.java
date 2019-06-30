package design_pattern.dynamic_designpattern;

public class MyCompiler {

    public static void main(String[] args) throws Exception{

        /*String src =

                "package design_pattern.dynamic_designpattern;\n\n"+

                "public class CatTimePolymerizationProxy implements Runnable{\n\n"+

                "   private Runnable cat;\n\n"+

                "   public CatTimePolymerizationProxy(Runnable cat) {\n\n"+
                "       this.cat = cat;\n\n"+
                "   }\n\n"+

                "  @Override\n\n"+
                "      public void run() {\n\n"+
                "      System.out.println(\"start time.....\");\n\n"+
                "      cat.run();\n\n"+
                "      System.out.println(\"stop time.....\");\n\n"+
                "  }\n\n"+
                "}\n\n";
        String fileName = System.getProperty("user.dir")+"/src/design_pattern.dynamic_designpattern/CatTimePolymerizationProxy.java";
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
        Class clazz = urlClassLoader.loadClass("design_pattern.dynamic_designpattern.CatTimePolymerizationProxy");
        //因为构造方法有参数，不能直接用类生成实例
        Constructor constructor = clazz.getConstructor(Runnable.class);
        Runnable catTimePolymerizationProxy = (Runnable)constructor.newInstance(new Cat());
        catTimePolymerizationProxy.run();*/
    }
}
