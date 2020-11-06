package com.ozzydemo.oakfusion.stringcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorModel
{
    private String inputString;
    private boolean hasDefaultDelimiter;
    private String defaultDelimiter;
    private boolean containsNewLine;
    private boolean hasCorrectBeginSequence;
    private String firstSequence;
    private String secondSequence;

    private List<String> secondSequenceList;

    List<Integer> validNumbers;
    List<Integer> negativeNumbers;
    List<String> inValidTokens;


    public StringCalculatorModel(String input) throws InvalidOperationException
    {
        this.inputString = input;
        hasDefaultDelimiter = false;
        containsNewLine = false;
        hasCorrectBeginSequence = false;

        validNumbers = new ArrayList<Integer>();
        negativeNumbers = new ArrayList<Integer>();
        inValidTokens = new ArrayList<String>();

        evaluate();
    }


    private void evaluate() throws InvalidOperationException
    {

        String updatedInput = inputString;

        if (!inputString.startsWith("\\"))
        {
            updatedInput = "\\" + StringUtil.getDelimiters(inputString) + "\n" + inputString;
        }

        if (inputString.isBlank() || inputString.isEmpty())
        {
            System.out.println("input string is empty, sum is->" + 0);
            validNumbers.add(0);
            return;
        }


        String[] delimiterTokens = updatedInput.split("[\\\\\n]");

        int delimiterTokenPosition = 0;
        //String[] delimiterTokens = inputString.split("[\\\\\n]");

        System.out.println("len of tokens->" + delimiterTokens.length);
        System.out.println("printing tokens");
        int tokenCount = 1;
        for (String token : delimiterTokens)
        {
            System.out.println("\ntoken " + tokenCount + "->" + token);
            tokenCount++;

            String[] subDelimiterTokens = token.split("[" + delimiterTokens[1] + "]");
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

        String delimiterToken = delimiterTokens[1];
        System.out.printf("\ndelimiter token->" + delimiterToken);

        String strInvalidNumbers = String.join(",", inValidTokens);

        String strValidNumbers = String.join(",",
                validNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));

        String strNegativeNumbers = String.join(",",
                negativeNumbers.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));

        System.out.printf("\nValid Numbers->" + strValidNumbers);

        if (!inValidTokens.isEmpty())
        {
            System.out.printf("\nInvalid Numbers->" + strInvalidNumbers);
            throw new InvalidOperationException("input string contains numbers with invalid delimiters->" + strInvalidNumbers);

        }

        if (!negativeNumbers.isEmpty())
        {
            System.out.printf("\nNegative Numbers->" + strNegativeNumbers);
            throw new InvalidOperationException("input string contains negative numbers->" + strNegativeNumbers);

        }


    }


    public Integer calculateSum()
    {
        return validNumbers.stream().reduce(0, Integer::sum);
    }

    public String getInputString()
    {
        return inputString;
    }

    public void setInputString(String inputString)
    {
        this.inputString = inputString;
    }


    public boolean isHasDefaultDelimiter()
    {
        return hasDefaultDelimiter;
    }

    public void setHasDefaultDelimiter(boolean hasDefaultDelimiter)
    {
        this.hasDefaultDelimiter = hasDefaultDelimiter;
    }

    public String getDefaultDelimiter()
    {
        return defaultDelimiter;
    }

    public void setDefaultDelimiter(String defaultDelimiter)
    {
        this.defaultDelimiter = defaultDelimiter;
    }

    public boolean isContainsNewLine()
    {
        return containsNewLine;
    }

    public void setContainsNewLine(boolean containsNewLine)
    {
        this.containsNewLine = containsNewLine;
    }

    public boolean isHasCorrectBeginSequence()
    {
        return hasCorrectBeginSequence;
    }

    public void setHasCorrectBeginSequence(boolean hasCorrectBeginSequence)
    {
        this.hasCorrectBeginSequence = hasCorrectBeginSequence;
    }

    public String getFirstSequence()
    {
        return firstSequence;
    }

    public void setFirstSequence(String firstSequence)
    {
        this.firstSequence = firstSequence;
    }

    public String getSecondSequence()
    {
        return secondSequence;
    }

    public void setSecondSequence(String secondSequence)
    {
        this.secondSequence = secondSequence;
    }

    public List<String> getSecondSequenceList()
    {
        return secondSequenceList;
    }

    public void setSecondSequenceList(List<String> secondSequenceList)
    {
        this.secondSequenceList = secondSequenceList;
    }
}


