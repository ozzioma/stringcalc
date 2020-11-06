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
    String input4 = "\\,\n1\n2,3\n4\n5";
    String input42 = "\\,!\n1\n2,3\n4\n5!6!7";
    //String input43 = "1\n2,3\n4\n5";
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

            StringCalculatorModel model;
            model = new StringCalculatorModel(input1);
            assertEquals(0, model.calculateSum());

        });

    }

    @Test
    void throws_On_NegativeNumbers1()
    {
        InvalidOperationException exception = assertThrows(InvalidOperationException.class, () ->
        {
            StringCalculatorModel model = new StringCalculatorModel(input2);
        });
    }

    @Test
    void throws_On_NegativeNumbers2()
    {
        InvalidOperationException exception = assertThrows(InvalidOperationException.class, () ->
        {
            StringCalculatorModel model = new StringCalculatorModel(input22);
        });
    }

    @Test
    void can_recognize_UndeclaredTokens()
    {
//        InvalidOperationException exception = assertThrows(InvalidOperationException.class, () ->
//        {
//            StringCalculatorModel model = new StringCalculatorModel(input3);
//        });

        assertDoesNotThrow(() ->
        {

            StringCalculatorModel model;
            model = new StringCalculatorModel(input3);
            assertEquals(78, model.calculateSum());

        });


    }

    @Test
    void sum_is_15_On_Input4()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculatorModel model;
            model = new StringCalculatorModel(input4);
            assertEquals(15, model.calculateSum());

        });
    }

    @Test
    void sum_is_28_On_Input42()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculatorModel model;
            model = new StringCalculatorModel(input42);
            assertEquals(28, model.calculateSum());

        });
    }

    @Test
    void sum_is_15_On_Input5()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculatorModel model;
            model = new StringCalculatorModel(input5);
            assertEquals(15, model.calculateSum());

        });
    }


    @Test
    void sum_is_15_On_Input6()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculatorModel model;
            model = new StringCalculatorModel(input6);
            assertEquals(15, model.calculateSum());

        });
    }

    @Test
    void sum_is_15_On_Input7()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculatorModel model;
            model = new StringCalculatorModel(input7);
            assertEquals(15, model.calculateSum());

        });
    }


    @Test
    void sum_is_15_On_Input8()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculatorModel model;
            model = new StringCalculatorModel(input8);
            assertEquals(15, model.calculateSum());

        });
    }


    @Test
    void sum_is_21_On_Input9()
    {
        assertDoesNotThrow(() ->
        {

            StringCalculatorModel model;
            model = new StringCalculatorModel(input9);
            assertEquals(21, model.calculateSum());

        });
    }

}
