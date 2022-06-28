package com.fileIO.shj;

import com.fileIO.shj.annotation.FileController;
import com.fileIO.shj.annotation.FileMapping;
import com.fileIO.shj.menu.FileIOMenu;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        try{
            Class clazz = Class.forName("com.fileIO.shj.file.FileService");
            Annotation[] annotations = clazz.getAnnotations();
            Constructor con = clazz.getConstructor();
            for (Annotation annotation : annotations) {
                if (annotation instanceof FileController) {
//                    FileController fileController  = (FileController) annotation;
                    for (Method method : clazz.getDeclaredMethods()) {
                        if (method.isAnnotationPresent(FileMapping.class)) {
                            FileMapping fileMapping = method.getDeclaredAnnotation(FileMapping.class);
                            System.out.println(fileMapping.menuNumber());
                            method.invoke(con.newInstance());
                        }
                    }
                }
            }
        }catch(Exception e){

        }

        FileIOMenu fileIOMenu = new FileIOMenu();

//        while(true){
            fileIOMenu.printFileIOMenu();
                fileIOMenu.selectFileIOMenu(fileIOMenu.selectFileIOMenuNumber());

//        }
    }
}
