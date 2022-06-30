package com.fileIO.shj.file;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FileVO {

    private final String fileFullPath;
    private final String fileName;
    private final String fileContent;

//    public FileVO(String fileFullPath, String fileName, String fileContent) {
//        this.fileFullPath = fileFullPath;
//        this.fileName = fileName;
//        this.fileContent = fileContent;
//    }

    public String toStringFileList(){
        return fileName + ".txt";
    }

}
