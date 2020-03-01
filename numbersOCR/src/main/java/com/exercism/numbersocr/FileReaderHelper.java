package com.exercism.numbersocr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderHelper {
    private static final String FILE_NAME = "TestDataFile.txt";
    private Scanner scanner;
    private ArrayList<NumberSnapshot> numbersList = new ArrayList<NumberSnapshot>();
    private ArrayList<ArrayList<NumberSnapshot>> inputData = new ArrayList<ArrayList<NumberSnapshot>>();

    public void OpenFile() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(FILE_NAME).getFile());
            scanner = new Scanner(file);
            System.out.println("Starting read from " + file.getName().toString());
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NAME + " file not found.");
            e.printStackTrace();
        }
    }

    public void ReadFile() {
        boolean fileHasNextLine = scanner.hasNextLine();
        int counterNumRowsWithDigits=-1;
        while (fileHasNextLine) {
            counterNumRowsWithDigits++;
            String line1 = "", line2 = "", line3 = "", line4 = "";
            try {
                line1 = scanner.nextLine();
                line2 = scanner.nextLine();
                line3 = scanner.nextLine();
                line4 = scanner.nextLine();
                if (stringLengthSanityCheck(line1, line2, line3, line4)) {

                    inputData.add(counterNumRowsWithDigits,stringArrayBuilder(line1, line2, line3, line4));
                } else {
                    System.out.println("Incorrect format of input data.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Unexpected end of file: " + FILE_NAME);
                e.printStackTrace();
            }

            fileHasNextLine = scanner.hasNextLine();
        }
        if(counterNumRowsWithDigits>0) System.out.println("Multi line input file.");
    }

    private boolean stringLengthSanityCheck(String line1, String line2, String line3, String line4) {
        if ((line1.length() == line2.length()) && (line1.length() == line3.length()) && (line4.length() == line2.length())) {
            return true;
        } else {
            return false;
        }
    }

    private ArrayList<NumberSnapshot> stringArrayBuilder(String line1, String line2, String line3, String line4) {
        int expectedNumberOfNumbers = line1.length() / 3;
        ArrayList<NumberSnapshot> result = new ArrayList<NumberSnapshot>();
        int i = 0;
        while(i < line1.length()){
            NumberSnapshot numberSnapshot = new NumberSnapshot(-1);
            for (int j = 0; j < 3; j++) {
                numberSnapshot.setNumberSnapshot(0,j,line1.substring(i+j,i+j+1));
                numberSnapshot.setNumberSnapshot(1,j,line2.substring(i+j,i+j+1));
                numberSnapshot.setNumberSnapshot(2,j,line3.substring(i+j,i+j+1));
                numberSnapshot.setNumberSnapshot(3,j,line4.substring(i+j,i+j+1));
            }
            result.add(numberSnapshot);
            i+=3;
        }
        return result;
    }

    public  void printArrayToRecognize() {
        for (ArrayList<NumberSnapshot> list: inputData) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        }
    }

    public int getSize(){
        return inputData.size();
    }

    public ArrayList<NumberSnapshot> getRow(int i){
        return inputData.get(i);
    }

    public NumberSnapshot getElement(int i, ArrayList<NumberSnapshot> list){
        return list.get(i);
    }
}



