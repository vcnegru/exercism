package com.exercism.luhn;

public class Main {

    public  static void main(String[] args){
        FileUtils.OpenFile();
        ListToValidate listToValidate = FileUtils.ReadFile();
        listToValidate.validateListMOD10();
    }
}