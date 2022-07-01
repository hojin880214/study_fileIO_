package com.fileIO.shj.annotation;

import com.fileIO.shj.file.FileDAOImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.fileIO.shj.myBatis.MyBatisConnectionFactory;

public class FileAnnotationHandler {

    public void handleFileAnnotation(int num){

        try{

            Class<?> clazz = Class.forName("com.fileIO.shj.file.FileServiceImpl");

            Annotation[] annotations = clazz.getAnnotations();

            for (Annotation annotation : annotations) {
                if (!(annotation instanceof FileController)) continue;
                getFileServiceMethod(num, clazz);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void getFileServiceMethod(int num, Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Method method : clazz.getDeclaredMethods()) {
            checkFileMappingAnnotation(num, clazz, method);
        }
    }

    private void checkFileMappingAnnotation(int num, Class<?> clazz, Method method) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (method.isAnnotationPresent(FileMapping.class)) {
            getFileMappingMenuNumber(num, clazz, method);
        }
    }

    private void getFileMappingMenuNumber(int num, Class<?> clazz, Method method) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        FileMapping fileMapping = method.getDeclaredAnnotation(FileMapping.class);
        checkMenuNumber(num, clazz, method, fileMapping);
    }

    private void checkMenuNumber(int num, Class<?> clazz, Method method, FileMapping fileMapping) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if(!(num == fileMapping.menuNumber())) return;
        invokeMethod(clazz, method);
    }

    private void invokeMethod(Class<?> clazz, Method method) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?>[] constructorParameterTypes = {com.fileIO.shj.file.FileDAO.class};
        Constructor<?> constructor = clazz.getConstructor(constructorParameterTypes);
        FileDAOImpl fileDAOImpl = new FileDAOImpl(MyBatisConnectionFactory.getSqlSessionFactory());
        method.invoke(constructor.newInstance(fileDAOImpl));
    }

//    public void handleFileAnnotation(int num){
//
//        try{
//            SqlSessionFactory sqlSessionFactory = null;
//            FileDAOImpl fileDAOImpl = new FileDAOImpl(sqlSessionFactory);
//            Class clazz = Class.forName("com.fileIO.shj.file.FileServiceImpl");
//            Class[] constructorParameterTypes = {com.fileIO.shj.file.FileDAO.class};
//            Annotation[] annotations = clazz.getAnnotations();
//
//            for (Annotation annotation : annotations) {
//                if (!(annotation instanceof FileController)) continue;
//                for (Method method : clazz.getDeclaredMethods()) {
//                    if (!method.isAnnotationPresent(FileMapping.class)) continue;
//                    FileMapping fileMapping = method.getDeclaredAnnotation(FileMapping.class);
//                    if(!(num == fileMapping.menuNumber())) return;
//                    Constructor constructor = clazz.getConstructor(constructorParameterTypes);
//                    method.invoke(constructor.newInstance(fileDAOImpl));
//                }
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }

//    private <T> T checkAnnotation(T targetObj, Class annotationObj) {
//        Field[] fields = targetObj.getClass().getDeclaredFields();
//        for (Field f : fields) {
//            if(annotationObj == InsertIntData.class) {
//                return checkAnnotation4InsertInt(targetObj, f);
//            }
//            else if(annotationObj == InsertStringData.class) {
//                return checkAnnotation4InsertString(targetObj, f);
//            }
//        }
//        return targetObj;
//    }
//
//    private <T> T checkAnnotation4InsertInt(T targetObj, Field field) {
//        InsertIntData annotation = field.getAnnotation(InsertIntData.class);
//        if(annotation != null && field.getType() == int.class) {
//            field.setAccessible(true);
//            try {  field.set(targetObj, annotation.data()); }
//            catch (IllegalAccessException e) { System.out.println(e.getMessage()); }
//        }
//        return targetObj;
//    }
//
//    private <T> T checkAnnotation4InsertString(T targetObj, Field field) {
//        InsertStringData annotation = field.getAnnotation(InsertStringData.class);
//        if(annotation != null && field.getType() == String.class) {
//            field.setAccessible(true);
//            try { field.set(targetObj, annotation.data()); }
//            catch (IllegalAccessException e) { System.out.println(e.getMessage()); }
//        }
//        return targetObj;
//    }

//    public <T> Optional<T> getInstance(Class targetClass, Class annotationClass) {
//        Optional optional = Optional.empty();
//        Object object;
//        try {
//            object = targetClass.newInstance();
//            object = checkAnnotation(object, annotationClass);
//            optional = Optional.of(object);
//        }catch (InstantiationException | IllegalAccessException e) { System.out.println(e.getMessage()); }
//        return optional;
//    }
}