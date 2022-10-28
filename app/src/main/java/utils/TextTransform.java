package utils;

import android.widget.Toast;

import com.example.lab3.MainActivity;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

public class TextTransform {
    public static String concatenate (String original, CharSequence newChar) {
        original = original + newChar;
        return original;
    }
    public static String back (String string) {
        if (string.length() > 0)
            return string.substring(0,string.length()-1);
        else return string;
    }
    public static String clear() {
        String string = "";
        return string;
    }

    public static String signChange(String currentDisplay){
        String toRet = "";
        int i = currentDisplay.length()-1;
        boolean signFound = false;
        char[] displayArray = currentDisplay.toCharArray();
        while (i >=0) {
            if (displayArray[i] == '-' && !signFound) {
                displayArray[i] = '+';
                signFound = true;
            }else {
                if (displayArray[i] == '+' && !signFound) {
                    displayArray[i] = '-';
                    signFound = true;
                }
                if (!signFound) {
                    if (displayArray[i] == '/' || displayArray[i] == '*'
                            || displayArray[i] == '\u221A') {
                        toRet = "-" + toRet;
                        signFound = true;

                    }
                }
            }
            toRet = displayArray[i] + toRet;
        i--;
        }
        if (signFound)
            return toRet;
        return ('-' + toRet);
    }

    public static String calculate (String expresion) {
        Expression calc;
        double result;
        String expresionToCalculate = "";

        int sqrRootIndex = expresion.indexOf('\u221A');
        if (sqrRootIndex != -1) {
            expresionToCalculate = expresion.substring(0, sqrRootIndex);
            expresionToCalculate = expresionToCalculate + " sqrt" ;
            expresionToCalculate = expresionToCalculate + expresion.substring(sqrRootIndex+1);
        }else {
            expresionToCalculate = expresion;
        }
        try {
            calc = new ExpressionBuilder(expresionToCalculate).build();
            result = calc.evaluate();
        } catch (Exception e) {
            throw e;
        }
        return String.valueOf(result);
    }
}
