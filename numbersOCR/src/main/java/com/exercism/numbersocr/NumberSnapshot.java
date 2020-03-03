package com.exercism.numbersocr;

import java.util.Arrays;

public class NumberSnapshot {
    private int[][] numberSnapshot;

    public NumberSnapshot(){}

    public NumberSnapshot(int number){
        switch(number){
            case 1:
                numberSnapshot = new int[][] {{0,0,0},{0,0,1},{0,0,1},{0,0,0}};
                break;
            case 2:
                numberSnapshot = new int[][] {{0,1,0},{0,1,1},{1,1,0},{0,0,0}};
                break;
            case 3:
                numberSnapshot = new int[][] {{0,1,0},{0,1,1},{0,1,1},{0,0,0}};
                break;
            case 4:
                numberSnapshot = new int[][] {{0,0,0},{1,1,1},{0,0,1},{0,0,0}};
                break;
            case 5:
                numberSnapshot = new int[][] {{0,1,0},{1,1,0},{0,1,1},{0,0,0}};
                break;
            case 6:
                numberSnapshot = new int[][] {{0,1,0},{1,1,0},{1,1,1},{0,0,0}};
                break;
            case 7:
                numberSnapshot = new int[][] {{0,1,0},{0,0,1},{0,0,1},{0,0,0}};
                break;
            case 8:
                numberSnapshot = new int[][] {{0,1,0},{1,1,1},{1,1,1},{0,0,0}};
                break;
            case 9:
                numberSnapshot = new int[][] {{0,1,0},{1,1,1},{0,1,1},{0,0,0}};
                break;
            case 0:
                numberSnapshot = new int[][] {{0,1,0},{1,0,1},{1,1,1},{0,0,0}};
                break;
            default:
                numberSnapshot = new int[][] {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
                break;
        }
    }

    public void setNumberSnapshot(int i, int j, String s){
        String normalize="";
        int elementValue = -1;
        switch (s){
            case " ":
                elementValue = 0;
                break;
            case "|":
            case "_":
                elementValue = 1;
                break;
            default:
                elementValue = -1;
                break;
        }
        numberSnapshot[i][j] = elementValue;
    }

    public void printSnapshot(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++){
                int element = numberSnapshot[i][j];
                if(element == 0)
                    System.out.print(" ");
                else {System.out.print(element);}
            }
            System.out.println();
        }
    }

    public boolean equals(NumberSnapshot o) {
        boolean result = true;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(!(this.numberSnapshot[i][j] == o.numberSnapshot[i][j])) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result="";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                result += (numberSnapshot[i][j] == 0) ? " " : numberSnapshot[i][j];
            }
            result +=  "\n";
        }
        return result;
    }

}
