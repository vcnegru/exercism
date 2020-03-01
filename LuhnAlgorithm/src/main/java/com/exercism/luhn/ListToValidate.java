package com.exercism.luhn;

import java.util.ArrayList;

public class ListToValidate {
    private ArrayList<String> listToValidate;

    public ListToValidate(){
        listToValidate = new ArrayList<>();
    }

    public ListToValidate(ArrayList<String> list){
        listToValidate = list;
    }

    public void addListToValidate(String stringToValidate) {
        this.listToValidate.add(stringToValidate);
    }

    public String getListToValidate(int i){
        return listToValidate.get(i);
    }

    public void validateListMOD10(){
        boolean isValid = false;
        for (String stringToValidate: listToValidate) {
            isValid(stringToValidate);
        }
    }

    public void isValid(String stringToValidate){
        int sum = 0;
        int num = 0;
        boolean exceptionFlag = false;
        String normalizedString = stringToValidate.replace(" ","");
        String reversedString = new StringBuilder().append(normalizedString).reverse().toString();

        for (int i = 0; i < reversedString.length() ; i++) {
            try {
                String substr = reversedString.substring(i,i+1);
                num = Integer.valueOf(substr);
            }catch (NumberFormatException e){
                System.out.println(stringToValidate + " contains invalid characters. Can't be validated.");
                //e.printStackTrace();
                exceptionFlag = true;
                break;
            }
            if(i%2==0){
                sum+=num;
            }
            else{
                int duplicatedvalue = num * 2;
                sum+= (duplicatedvalue < 9) ? duplicatedvalue :(duplicatedvalue-9);
            }
        }
        if(sum % 10 == 0){
            System.out.println(stringToValidate + " is a VALID mod10 number's sequence. CheckSum is " + sum);
        }else if(!exceptionFlag){
            System.out.println(stringToValidate + " is an INVALID mod10 number's sequence. CheckSum is " + sum);
        }
    }
}