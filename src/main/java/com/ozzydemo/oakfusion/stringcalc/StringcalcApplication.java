package com.ozzydemo.oakfusion.stringcalc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class StringcalcApplication implements CommandLineRunner
{

    public static void main(String[] args)
    {
        SpringApplication.run(StringcalcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {

        System.out.println("Running String Calculator Kata");

        //demo1();
        //demo2();
        //demo3();

    }


    String getDelimiters(String inputString)
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

        String foundDelim = String.join("", delimiters);
        // System.out.println("delim->" + foundDelim + " len of delimiters->" + delimiters.size());

        return foundDelim;

    }

    void demo3()
    {
        String text3 = "1\n2,3";
        String text4 = "1,2,3";

        StringBuilder sb = new StringBuilder(text4);
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

        String foundDelim = String.join("", delimiters);
        System.out.println("delim->" + foundDelim + " len of delimiters->" + delimiters.size());


    }

    void demo2()
    {
        Gson jsonPrinter = new GsonBuilder().setPrettyPrinting().create();

        List<Integer> validNumbers = new ArrayList<Integer>();
        List<Integer> negativeNumbers = new ArrayList<Integer>();
        List<String> inValidTokens = new ArrayList<String>();


        //String input = "1,2,3*4**5***6";
        String input = "\\!;**\n1;2\n3\n4!5!6**7;8\n9**-10";
        //String test = "\\!;*\n1;2!3\n4;5\n-6\n7!8*9!10";
        //String test = "1\n2,3\n4\n5";
        //String test = "1**2**3**4**5";
        //String test = "\\,\n1,2,3";
        //String test = "\\*\n1*2*3";
        //String test = "\\*,\n1*2,3*4";

        String updatedInput = input;

        if (!input.startsWith("\\"))
        {
            updatedInput = "\\" + getDelimiters(input) + "\n" + input;
        }


        /* \\,\n*/
        //String test = "1,2,3";
        //System.out.println("input string->" + test);

        //StringCalculatorModel model = new StringCalculatorModel(test);

        if (updatedInput.isBlank() || updatedInput.isEmpty())
        {
            System.out.println("input string is empty, sum is->" + 0);
            return;
        }


        String[] delimiterTokens = updatedInput.split("[\\\\\n]");
        //String[] delimiterTokens2 = updatedInput.split("[\\\\\n]");

        int delimiterTokenPosition = 0;


        if (delimiterTokens.length > 2)
        {
            delimiterTokenPosition = 1;
        }
        else
        {

        }

        System.out.println("len of tokens->" + delimiterTokens.length);
        System.out.println("printing tokens");

        int tokenCount = 1;
        for (String token : delimiterTokens)
        {
            System.out.println("\ntoken " + tokenCount + "->" + token);
            tokenCount++;

            String[] subDelimiterTokens = token.split("[" + delimiterTokens[delimiterTokenPosition] + "]");
            int subTokenCount = 1;

            for (String subToken : subDelimiterTokens)
            {
                System.out.println("sub token " + subTokenCount + "->" + subToken);

                if (subToken.isEmpty() || subToken.isBlank()) continue;

                Integer tokenValue;
                try
                {
                    tokenValue = Integer.parseInt(subToken);
                    System.out.println("token value->" + tokenValue);

                    if (tokenValue < 0)
                    {
                        negativeNumbers.add(tokenValue);
                    }
                    else
                    {
                        validNumbers.add(tokenValue);

                    }
                }
                catch (NumberFormatException ex)
                {
                    //throw ex;
                    inValidTokens.add(subToken);
                }

                subTokenCount++;
            }
        }

        String delimiterToken = delimiterTokens[delimiterTokenPosition];
        System.out.printf("\ndelimiter token->" + delimiterToken);

        String strInvalidNumbers = String.join(",", inValidTokens);

        String strValidNumbers = String.join(",",
                validNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));

        String strNegativeNumbers = String.join(",",
                negativeNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));

        System.out.printf("\nValid Numbers->" + strValidNumbers);
        System.out.printf("\nInvalid Numbers->" + strInvalidNumbers);
        System.out.printf("\nNegative Numbers->" + strNegativeNumbers);


    }

    void demo1()
    {
        Gson jsonPrinter = new GsonBuilder().setPrettyPrinting().create();

        String test = "//;\n1;2";//"1,\n";//"1\n2,3";//"ozzy;ichiban;taicho";
        System.out.println("input string->" + test);

        //StringCalculatorModel model = new StringCalculatorModel(test);

        String[] tokens1 = test.split("//");
        //String[] tokens1 = test.split(";");
        String[] tokens2 = test.split("\n", 2);

        System.out.println("len of tokens->" + tokens1.length);
        //System.out.println("correct len if contains default delim->" + tokens1.length);


        if (tokens1.length == 2)
        {


            System.out.println("has CORRECT sequence for default delimiter token");

            if (tokens1[0].contains("\n"))
            {
                System.out.println("tokens[0] contains new line->" + tokens1[0]);
            }
            if (tokens1[0].isEmpty() || tokens1[0].isBlank())
            {
                System.out.println("tokens[0] is empty or blank->" + tokens1[0]);
            }

            if (tokens1[1].contains("\n"))
            {
                System.out.println("tokens[1] contains new line->" + tokens1[1]);
            }
            if (tokens1[1].isEmpty() || tokens1[1].isBlank())
            {
                System.out.println("tokens[1] is empty or blank->" + tokens1[1]);
            }


            char delimiterToken = tokens1[1].charAt(0);
            System.out.println("delimiter token->" + delimiterToken);

            char newLineToken = tokens1[1].charAt(1);
            //String newLineToken = tokens1[0];
            System.out.println("newLine token->" + newLineToken);
            if (newLineToken == '\n')
            {
                System.out.println("newline token found in correct position");
            }

            StringBuilder sb = new StringBuilder(tokens1[1]);
            sb.deleteCharAt(0);
            //sb.deleteCharAt(1);
            System.out.println("numbers string minus delim->" + sb.toString());

            //String numberString=sb.toString();
            //System.out.println("numbers string->" + numberString);


            //System.out.println("token 1->" + newLineToken);
            //System.out.println("token 2->" + delimiterToken);

//            if (newLineToken.contains("\n") && !delimiterToken.isEmpty())
//            {
//                System.out.println("CORRECT sequence for default delimiter token detected");
//                model.setHasDefaultDelimiter(true);
//                model.setDefaultDelimiter(delimiterToken);
//
//            }
//            else
//            {
//                System.out.println("INCORRECT sequence for default delimiter token detected");
//
//            }

        }
        else
        {
            System.out.println("has INCORRECT sequence for default delimiter token");

        }

        System.out.println("\n printing tokens");
        for (String token : tokens1)
        {
            if (token.contains("\n"))
            {
                System.out.println("current token contains newline");
            }

            System.out.println(token);
        }

        System.out.println("\n printing model");
        // System.out.println(jsonPrinter.toJson(model));

    }
}


