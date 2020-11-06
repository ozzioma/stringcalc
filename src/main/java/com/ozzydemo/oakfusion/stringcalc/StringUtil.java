package com.ozzydemo.oakfusion.stringcalc;

import java.util.ArrayList;
import java.util.List;

public class StringUtil
{

    public static String getDelimiters(String inputString)
    {

        StringBuilder sb = new StringBuilder(inputString);
        List<String> delimiters = new ArrayList<>();

        for (int count = 0; count < sb.length(); count++)
        {
            char charToken = sb.charAt(count);
            boolean isDigit = Character.isDigit(charToken);
            if (!isDigit)
            {
                String strToken = "" + charToken;
                //if (!strToken.contains("\n"))
                if (!delimiters.contains(strToken))
                    delimiters.add(strToken);
                System.out.println("delimiter->" + charToken);
            }
            else
            {
                System.out.println("digit->" + charToken);

            }
        }

        delimiters.add("\n");

        String foundDelim = String.join("", delimiters);
        // System.out.println("delim->" + foundDelim + " len of delimiters->" + delimiters.size());

        return foundDelim;

    }

}


