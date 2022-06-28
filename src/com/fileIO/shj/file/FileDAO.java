package com.fileIO.shj.file;

public interface FileDAO {

    FileVO makeFile();
    void addFileList(FileVO fileVO);
    void printFileList();
    void makeTextFileList();
    int textFileMaxIndex();
    void showTextFileList();
    void readTextFileList(int selectedNumber);

}
