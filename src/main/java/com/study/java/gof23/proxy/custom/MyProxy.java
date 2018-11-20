package com.study.java.gof23.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by yan on  20/11/2018.
 * <p>
 * ���ɴ������
 */
public class MyProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h) {

        //1������Դ����

        String proxySrc = generateSrc(interfaces);

        try{
            //1.��̬����Դ����.java�ļ�
            String src = generateSrc(interfaces);

            //2.Java �ļ��������
            String filePath = MyProxy.class.getResource("").getPath();
            System.out.println(filePath);
            File f = new File(filePath+"$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            //3.�����ɵ�.java�ļ������.class�ļ�
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task=compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();

            //4.�������ɵ�.class�ļ����ص�jvm����
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c =proxyClass.getConstructor(MyInvocationHandler.class);
            //����˹��캯���󣬿���ɾ��.class�ļ�
            f.delete();

            //5.�����ֽ��������Ժ���µĴ�����󡪡����������󣬲�����
            return c.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        sb.append("package com.study.java.gof23.proxy.custom;"+ln);
        sb.append("import com.study.java.gof23.proxy.myDynamicProxy.Star;"+ln);
        sb.append("import java.lang.reflect.InvocationHandler;"+ln);
        sb.append("import java.lang.reflect.Method;"+ln);
        sb.append("import java.lang.reflect.Proxy;"+ln);
        sb.append("import java.lang.reflect.UndeclaredThrowableException;"+ln);
        sb.append("public class $Proxy0 implements "+interfaces[0].getName()+ "{"+ln);

        sb.append("MyInvocationHandler h;"+ln);
        sb.append("public $Proxy0(MyInvocationHandler h) {"+ln);
        sb.append("this.h = h;"+ln);
        sb.append("}"+ln);

        for(Method m:interfaces[0].getMethods()){
            sb.append("public "+m.getReturnType().getName()+" "+m.getName()+"() {"+ln);
            sb.append("try {"+ln);
            sb.append("Method m = "+interfaces[0].getName()+" .class.getMethod(\""+m.getName()+"\",new Class[]{});"+ln);
            sb.append("this.h.invoke(this,m,null);"+ln);
            sb.append("}catch(Throwable e){"+ln);
            sb.append("e.printStackTrace();"+ln);
            sb.append("}"+ln);
            sb.append("}"+ln);
        }

        sb.append("}"+ln);
        return sb.toString();

    }
}
