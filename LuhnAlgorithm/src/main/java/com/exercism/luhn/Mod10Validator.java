package com.exercism.luhn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mod10Validator {
    private static final String FILE_NAME = "TestData.txt";
    private ArrayList<String> listToValidate;
    Scanner scanner;

    public Mod10Validator() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(FILE_NAME).getFile());
            scanner = new Scanner(file);
            listToValidate = new ArrayList<String>();
            System.out.println("Starting read from "+file.getName().toString());
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NAME + " file not found.");
            e.printStackTrace();
        }
    }

    public void fileReader() {
        while (scanner.hasNextLine()) {
            listToValidate.add(scanner.nextLine());
        }
    }

    public void printValues() {
        System.out.println("***********************************");
        for (int i = 0; i < listToValidate.size(); i++) {
            System.out.println(listToValidate.get(i));
        }
        System.out.println("***********************************");
    }

    // replace space characters from string before validation
    public void normalizeValues(){
        for (int i = 0; i < listToValidate.size(); i++) {
            listToValidate.set(i, listToValidate.get(i).replace(" ",""));
        }
    }

    public void mod10(){
        for (int i = 0; i < listToValidate.size(); i++) {
            isValid(listToValidate.get(i));
        }
    }

    public void isValid(String value){
        Integer sum = 0;
        Integer num = 0;
        boolean exceptionFlag = false;
        String normalizedString = value.replace(" ","");
        String reversedString = new StringBuilder().append(normalizedString).reverse().toString();

        for (int i = 0; i < reversedString.length() ; i++) {
            try {
                String substr = reversedString.substring(i,i+1);
                num = Integer.valueOf(substr);
            }catch (NumberFormatException e){
                System.out.println(value + " contains invalid characters. Can't be validated.");
                //e.printStackTrace();
                exceptionFlag = true;
                break;
            }
            if(i%2==0){
                sum+=num;
            }
            else{
                Integer duplicatedvalue = num * 2;
                sum+= (duplicatedvalue < 9) ? duplicatedvalue :(duplicatedvalue-9);
            }
        }
        if(sum % 10 == 0){
            System.out.println(value + " is a valid mod10 number's sequence. Sum is " + sum);
        }else if(!exceptionFlag){
            System.out.println(value + " is a INVALID mod10 number's sequence. Sum is " + sum);
        }
    }
}
