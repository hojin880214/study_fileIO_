package com.fileIO.shj.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FileIOMenu {

    private static Logger LOGGER = LoggerFactory.getLogger(FileIOMenu.class);


    public void printFileIOMenu() {

        LOGGER.info("-----------------------FileIO-------------------------");
        LOGGER.info("------------------------------------------------------");
        LOGGER.info("1. 새 파일");
        LOGGER.info("2. 파일 열기");
        LOGGER.info("3. 나가기");
        LOGGER.info("------------------------------------------------------");
        LOGGER.info("------------------------------------------------------");
        LOGGER.info("콘솔창에 해당하는 숫자를 입력해주세요.");

    }

    private int selectScannerNumber() {

        int selectedNumber = 0;
        try {
            Scanner sc = new Scanner(System.in);
            selectedNumber = sc.nextInt();
        } catch (InputMismatchException E) {
            LOGGER.error("잘못 입력하셨습니다. 아라비안 숫자를 올바르게 입력해주세요.");
        } finally {
            if (selectedNumber == 0) selectScannerNumber();
        }

        return selectedNumber;

    }

    private boolean isValidFileIOMenuNumber(int number){

        boolean bool = number < 4;
        if(!bool) LOGGER.error("잘못 입력하셨습니다. 해당하는 숫자를 다시 입력해주세요.");

        return bool;

    }

    public int selectFileIOMenuNumber(){

        int selectedNumber = selectScannerNumber();
        if(!isValidFileIOMenuNumber(selectedNumber)) {
            return selectFileIOMenuNumber();
        }
        return selectedNumber;

    }


    public boolean selectFileIOMenu(int selectedNumber) {



//        switch (selectedNumber) {
//            case 1:
//                System.out.println("1. 새 파일 선택하셨습니다.");
//                fileDAOimpl.addFileList(fileDAOimpl.makeFile());
//                fileDAOimpl.printFileList();
//                return false;
//            case 2:
//                System.out.println("2. 파일 열기 선택하셨습니다.");
//                fileDAOimpl.makeTextFileList();
//                fileDAOimpl.showTextFileList();
//                int textFileMaxIndex = fileDAOimpl.textFileMaxIndex();
//                System.out.print("읽을 파일 번호를 입력해주세요 : ");
//                while (true) {
//                    selectedNumber = scanner.nextInt();
//                    if(textFileMaxIndex >= selectedNumber){
//                        fileDAOimpl.readTextFileList(selectedNumber);
//                        break;
//                    }
//                    System.err.print("해당하는 번호가 없습니다. 읽을 파일 번호를 다시 입력해주세요 : ");
//                }
//
//                return false;
//            case 3:
//                System.out.println("3. 나가기 선택하셨습니다. 종료합니다.");
//                return true;
//        }

        return false;

    }
}
