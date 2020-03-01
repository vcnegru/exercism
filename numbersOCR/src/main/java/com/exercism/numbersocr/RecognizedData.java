package com.exercism.numbersocr;

import java.util.ArrayList;

public class RecognizedData {
    private ArrayList<Integer> recognizedArray = new ArrayList<Integer>();

    public  RecognizedData(ArrayList<Integer> recognizedArray){
        this.recognizedArray = recognizedArray;
    }

    @Override
    public String toString() {
        String result="";
        for (int i = 0; i < recognizedArray.size(); i++) {
            result+=recognizedArray.get(i);
        }
        return result;
    }

    public int size(){return recognizedArray.size();}
    public int getElement(int i){return recognizedArray.get(i);}
}
