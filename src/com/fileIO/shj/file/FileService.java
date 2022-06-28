package com.fileIO.shj.file;


import com.fileIO.shj.annotation.FileController;
import com.fileIO.shj.annotation.FileMapping;

@FileController
public class FileService {

    @FileMapping(menuNumber = 1)
    public void makeFile(){
        System.out.println("makeFile");
    }

    @FileMapping(menuNumber = 2)
    public void readFile(){
        System.out.println("readFile");
    }
}
