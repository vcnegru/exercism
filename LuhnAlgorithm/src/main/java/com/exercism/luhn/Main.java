package com.exercism.luhn;

public class Main {
    public  static void main(String[] args){
        Mod10Validator values = new Mod10Validator();
        values.fileReader();
        values.printValues();
        values.mod10();
    }
}
