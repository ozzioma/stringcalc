package com.ozzydemo.oakfusion.stringcalc;

import java.util.List;
import java.util.StringTokenizer;

public class StringCalculator
{

    public int Add(String numbersString)
    {
        int sum = 0;

        if (numbersString == null || numbersString.isBlank() || numbersString.isEmpty())
            return sum;

        //check for newline


        //get default delimiter
        StringTokenizer tokenizer = new StringTokenizer(numbersString, "!*^/");


        return sum;
    }



}

