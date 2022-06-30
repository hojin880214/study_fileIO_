package com.fileIO.shj.file;

import com.fileIO.shj.annotation.FileController;
import com.fileIO.shj.annotation.FileMapping;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

@FileController
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

    private final FileDAO fileDAO;
    public FileServiceImpl(FileDAO fileDAO){
        this.fileDAO = fileDAO;
    }

    private final String projectPath = System.getProperty("user.dir");
    Scanner scanner = new Scanner(System.in);

    @Override
    @FileMapping(menuNumber = 1)
    public FileVO makeFile(){
//        System.out.println("1111111");
        String fileName = getScannerFileName();
        String fileFullPath = projectPath + "\\file\\" + fileName + ".txt";
        String fileContent = getFileContent(fileFullPath);
//        fileDAO.makeFile();

        return new FileVO("s","s","s");

    }

    @Override
    @FileMapping(menuNumber = 2)
    public void readFile(){
        System.out.println("readFile");
    }

    private String getScannerFileName() {

        LOGGER.info("파일 이름을 적어주세요.");

        return scanner.nextLine();

    }

    private String getFileContent(String fileFullPath) {

        String fileContent = "";
        int lineNumber = 0;
        try (
                FileWriter fw = new FileWriter(fileFullPath, false);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            System.out.println(fileFullPath + " 이 생성되었습니다.");
            System.out.println("파일 내용을 입력해주세요.(입력 종료는 개행 후 :q 입력해주세요)" + System.lineSeparator());
            while (true) {
                System.out.print(" " + ++lineNumber + " ");
                String line = scanner.nextLine();
                if((line.equals(":q"))) break;
                fileContent = fileContent.concat(line + System.lineSeparator());
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(System.lineSeparator() + fileFullPath + "의 내용 입력을 완료하였습니다." + System.lineSeparator());

        return fileContent;

    }

}
