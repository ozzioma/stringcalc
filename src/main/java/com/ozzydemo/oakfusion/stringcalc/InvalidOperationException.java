package com.ozzydemo.oakfusion.stringcalc;

public class InvalidOperationException extends Exception
{
    public InvalidOperationException(String message)
    {
        super(message);
    }

    public InvalidOperationException(String message, Exception base)
    {
        super(message, base);
    }
}
