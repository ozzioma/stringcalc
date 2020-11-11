package com.ozzydemo.oakfusion.stringcalc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringcalcApplicationTests
{

    String input1 = "";
    String input2 = "\\!;**\n1;2\n3\n4!5!6**7;8\n9**-10";
    String input22 = "\\,!\n1\n2,3\n4\n-5!6!-7";
    String input3 = "\\!;*\n1;2!3\n4;5\n6\n7!8*9!10**11***12";
    String input32 = "\\!;*\n1;2!3\n4;5\n6\n7!8*9!10**11***12!999";
    String input33 = "\\!;**\n1;2!3\n4;5\n6\n7!8*9!10**11***12*1000";
    String input34 = "\\!;***\n1;2!3\n4;5\n6\n7!8*9!10**11***12;1001";
    String input35 = "\\!;***\n1;2!3\n4;5\n6\n7!8*9!10**11***12**2000";
    String input4 = "\\,\n1\n2,3\n4\n5";
    String input42 = "\\,!\n1\n2,3\n4\n5!6!7";
    String input5 = "1,2,3,4,5";
    String input6 = "1*2*3*4*5";
    String input7 = "1**2**3**4**5";
    String input8 = "1***2***3***4***5";
    String input9 = "1,2,3*4**5***6";

    @Test
    void contextLoads()
    {
    }

    @Test
    void sum_isZero_On_EmptyString()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculator model = new StringCalculator();
            assertEquals(0, model.Add(input1));

        });

    }

    @Test
    void throws_On_NegativeNumbers1()
    {
        InvalidOperationException exception = assertThrows(InvalidOperationException.class, () ->
        {
            StringCalculator model = new StringCalculator();
            model.Add(input2);
        });
    }

    @Test
    void throws_On_NegativeNumbers2()
    {
        InvalidOperationException exception = assertThrows(InvalidOperationException.class, () ->
        {
            StringCalculator model = new StringCalculator();
            model.Add(input22);
        });
    }

    @Test
    void sum_is_78_On_Input3()
    {

        assertDoesNotThrow(() ->
        {
            StringCalculator model = new StringCalculator();
            assertEquals(78,  model.Add(input3));

        });

    }

    @Test
    void sum_is_1077_On_Input32()
    {

        assertDoesNotThrow(() ->
        {
            StringCalculator model = new StringCalculator();
            assertEquals(1077,  model.Add(input32));

        });

    }


    @Test
    void sum_is_1078_On_Input33()
    {

        assertDoesNotThrow(() ->
        {
            StringCalculator model = new StringCalculator();
            assertEquals(1078,  model.Add(input33));

        });

    }


    @Test
    void ignores_numbers_greaterThan_1000_On_Input34()
    {

        assertDoesNotThrow(() ->
        {
            StringCalculator model = new StringCalculator();
            assertEquals(78,  model.Add(input34));

        });

    }

    @Test
    void ignores_numbers_greaterThan_1000_On_Input35()
    {

        assertDoesNotThrow(() ->
        {
            StringCalculator model = new StringCalculator();
            assertEquals(78,  model.Add(input35));

        });

    }

    @Test
    void can_recognize_UndeclaredTokens_On_Input3()
    {

        assertDoesNotThrow(() ->
        {

            StringCalculator model = new StringCalculator();
            assertEquals(78,  model.Add(input3));
        });

    }

    @Test
    void sum_is_15_On_Input4()
    {
        assertDoesNotThrow(() ->
        {
            StringCalculator model = new StringCalculator();
            assertEquals(15, model.Add(input4));

        });
    }

    @Test
    void sum_is_28_On_Input42()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculator model = new StringCalculator();
            assertEquals(28, model.Add(input42));

        });
    }

    @Test
    void sum_is_15_On_Input5()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculator model = new StringCalculator();
            assertEquals(15, model.Add(input5));

        });
    }


    @Test
    void sum_is_15_On_Input6()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculator model = new StringCalculator();
            assertEquals(15, model.Add(input6));

        });
    }

    @Test
    void sum_is_15_On_Input7()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculator model = new StringCalculator();
            assertEquals(15, model.Add(input7));

        });
    }


    @Test
    void sum_is_15_On_Input8()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculator model = new StringCalculator();
            assertEquals(15, model.Add(input8));

        });
    }


    @Test
    void sum_is_21_On_Input9()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculator model = new StringCalculator();
            assertEquals(21, model.Add(input9));

        });
    }

}
