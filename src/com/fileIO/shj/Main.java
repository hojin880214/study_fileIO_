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

        FileIOMenu fileIOMenu = new FileIOMenu();

//        while(true){
            fileIOMenu.printFileIOMenu();
                fileIOMenu.selectFileIOMenu(fileIOMenu.selectFileIOMenuNumber());

//        }
    }
}
