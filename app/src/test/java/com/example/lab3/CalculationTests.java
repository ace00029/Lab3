package com.example.lab3;

import org.junit.Test;

import static org.junit.Assert.*;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import utils.TextTransform;

public class CalculationTests {

    @Test
    public void additionTest01()
    {
        String inputExpression = "12+567";
        String expectedResult = "579.0";

        String actualResult = TextTransform.calculate(inputExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void additionTest02()
    {
        String inputExpression = "-112+567";
        String expectedResult = "455.0";

        String actualResult = TextTransform.calculate(inputExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void dividedTest01()
    {
        String inputExpression = "134/91";

        Expression calc = new ExpressionBuilder(inputExpression).build();
        String expectedResult = String.valueOf(calc.evaluate());

        String actualResult = TextTransform.calculate(inputExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void dividedTest02()
    {
        String inputExpression = "91/0.53";

        Expression calc = new ExpressionBuilder(inputExpression).build();
        String expectedResult = String.valueOf(calc.evaluate());

        String actualResult = TextTransform.calculate(inputExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sqrRootTest01()
    {
        String x = "2134";
        String y = "123";

        String inputExpression = (x+'\u221A'+y);

        String inputExpressionForBuilder = ( x+"sqrt"+y );

        Expression calc = new ExpressionBuilder(inputExpressionForBuilder).build();
        String expectedResult = String.valueOf(calc.evaluate());

        String actualResult = TextTransform.calculate(inputExpression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sqrRootTest02()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            String y = "-123";

            String inputExpression = ('\u221A'+y);

            String inputExpressionForBuilder = ( "sqrt"+y );

            Expression calc = new ExpressionBuilder(inputExpressionForBuilder).build();
            String expectedResult = String.valueOf(calc.evaluate());
            String actualResult = TextTransform.calculate(inputExpression);
        });
    }

    @Test
    public void dividedByXTest01()
    {
        String inputExpresion = "2134";

        String expectedResult = ("1/"+inputExpresion);
        String actualResult = TextTransform.dividedByX(inputExpresion);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void dividedByXTest02()
    {
        String inputExpresion = "-2134";

        String expectedResult = ("1/"+inputExpresion);
        String actualResult = TextTransform.dividedByX(inputExpresion);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void signChangeTest01()
    {
        String inputExpresion = "2134";

        String expectedResult = ("-"+inputExpresion);
        String actualResult = TextTransform.signChange(inputExpresion);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void signChangeTest02()
    {
        String inputExpresion = "-2134";

        String expectedResult = (inputExpresion.replace('-','+'));
        String actualResult = TextTransform.signChange(inputExpresion);

        assertEquals(expectedResult, actualResult);
    }
}
