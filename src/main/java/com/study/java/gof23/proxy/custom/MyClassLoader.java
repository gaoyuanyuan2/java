package com.study.java.gof23.proxy.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by yan on  20/11/2018.
 *
 * 代码生成、编译、重新load到JVM
 */
public class MyClassLoader  extends ClassLoader{

    private File ClassPathFile;

    public MyClassLoader(){
        String classPath = MyClassLoader.class.getResource("").getPath();
        this.ClassPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName()+"."+name;
        if(ClassPathFile != null){
            File classFile = new File(ClassPathFile,name.replaceAll("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;

                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len ;
                    while((len = in.read(buff))!=-1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(null!=in){
                        try{
                            in.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    if(null!=out){
                        try{
                            out.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
