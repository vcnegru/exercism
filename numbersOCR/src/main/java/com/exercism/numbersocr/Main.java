package com.exercism.numbersocr;

import java.util.ArrayList;
/*
OCR Numbers
In Practice Mode
Introduction
Given a 3 x 4 grid of pipes, underscores, and spaces, determine which number is represented, or whether it is garbled.

Step One
To begin with, convert a simple binary font to a string containing 0 or 1.

The binary font uses pipes and underscores, four rows high and three columns wide.

     _   #
    | |  # zero.
    |_|  #
         # the fourth row is always blank
Is converted to "0"

         #
      |  # one.
      |  #
         # (blank fourth row)
Is converted to "1"

If the input is the correct size, but not recognizable, your program should return '?'

If the input is the incorrect size, your program should return an error.

Step Two
Update your program to recognize multi-character binary strings, replacing garbled numbers with ?

Step Three
Update your program to recognize all numbers 0 through 9, both individually and as part of a larger string.

 _
 _|
|_

Is converted to "2"

      _  _     _  _  _  _  _  _  #
    | _| _||_||_ |_   ||_||_|| | # decimal numbers.
    ||_  _|  | _||_|  ||_| _||_| #
                                 # fourth line is always blank
Is converted to "1234567890"

Step Four
Update your program to handle multiple numbers, one per line. When converting several lines, join the lines with commas.

    _  _
  | _| _|
  ||_  _|

    _  _
|_||_ |_
  | _||_|

 _  _  _
  ||_||_|
  ||_| _|

Is converted to "123,456,789"
*/
public class Main {

    public static void main(String[] args) {

        ArrayList<NumberSnapshot> correctDigits = new ArrayList<NumberSnapshot>();
        ArrayList<ArrayList<Integer>> recognizedArray = new ArrayList<ArrayList<Integer>>();
        ArrayList<RecognizedData> recognizedData = new ArrayList<RecognizedData>();

        for (int i = 0; i < 10; i++) {
            correctDigits.add(new NumberSnapshot(i));
        }

        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        fileReaderHelper.OpenFile();
        fileReaderHelper.ReadFile();
//        fileReaderHelper.printArrayToRecognize();
        NumberSnapshot   four = new NumberSnapshot(4);

/*
        for (int i = 0; i < fileReaderHelper.getSize(); i++) {
            if(four.equals(fileReaderHelper.getElement(i))){
                System.out.println("Element is equal to: \n" + four.toString());
            }
        }
*/

        for (int n = 0; n < fileReaderHelper.getSize(); n++) {
            ArrayList<NumberSnapshot> numberSnapshots = fileReaderHelper.getRow(n);
            ArrayList<Integer> recognizedRow = new ArrayList<>();
            for (int i = 0; i < numberSnapshots.size(); i++) {
                int digit = -1;
                boolean isDigitFlag = false;
                for (int j = 0; j < 10; j++) {
                    if (numberSnapshots.get(i).equals(correctDigits.get(j))) {
                        isDigitFlag = true;
                        digit = j;
                    }
                }
                digit = digit >= 0 ? digit : -1;
                recognizedRow.add(digit);
            }
            recognizedData.add(new RecognizedData(recognizedRow));
        }

        System.out.println("Start recognize digits. (-1) - is an invalid character.");
        for (int i = 0; i < recognizedData.size(); i++) {
            RecognizedData recognizedRow = recognizedData.get(i);
            for (int j = 0; j < recognizedRow.size(); j++) {
                System.out.print(recognizedRow.getElement(j));
            }
            if((recognizedData.size() > 1) && (i < recognizedData.size()-1)) System.out.print(",");
        }

    }
}
