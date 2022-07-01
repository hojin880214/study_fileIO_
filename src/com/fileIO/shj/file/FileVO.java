package com.fileIO.shj.file;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FileVO {

    private final String fileFullPath;
    private final String fileName;
    private final String fileContent;

    public String toStringFileList(){
        return fileName + ".txt";
    }

}
