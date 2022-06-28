package com.fileIO.shj;

import com.fileIO.shj.menu.FileIOMenu;

public class Main {

    public static void main(String[] args) {

        FileIOMenu fileIOMenu = new FileIOMenu();

//        while(true){
            fileIOMenu.printFileIOMenu();
                fileIOMenu.selectFileIOMenu(fileIOMenu.selectFileIOMenuNumber());

//        }
    }
}
