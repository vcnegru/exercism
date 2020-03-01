package com.exercism.luhn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {
    private static final String FILE_NAME = "TestData.txt";
    private static Scanner scanner;

    public static void OpenFile() {
        try {
            ClassLoader classLoader = FileUtils.class.getClassLoader();
            File file = new File(classLoader.getResource(FILE_NAME).getFile());
            scanner = new Scanner(file);
            System.out.println("Starting read from " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NAME + " file not found.");
            e.printStackTrace();
        }
    }

    public static ListToValidate ReadFile() {
        ListToValidate listOfStringsToValidate = new ListToValidate();
        while (scanner.hasNextLine()) {
            listOfStringsToValidate.addListToValidate(scanner.nextLine());
        }
        return  listOfStringsToValidate;
    }

}