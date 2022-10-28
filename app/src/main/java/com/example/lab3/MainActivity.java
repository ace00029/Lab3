package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

import utils.TextTransform;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private TextView calculatorScreen;
    private Button backButton, clearButton,changeSignButton,
            sqrRootButton,sumButton,subButton,multButton,divButton, equalButton;
    private Button n0Button, n1Button,n2Button,n3Button,n4Button,n5Button,
            n6Button,n7Button,n8Button,n9Button, dotButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.calculatorScreen = findViewById(R.id.calculatorScreen);

        backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(this);
        clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(this);
        changeSignButton = (Button) findViewById(R.id.plusMinus);
        changeSignButton.setOnClickListener(this);
        sqrRootButton = (Button) findViewById(R.id.squareRoot);
        sqrRootButton.setOnClickListener(this);
        sumButton = (Button) findViewById(R.id.plus);
        sumButton.setOnClickListener(this);
        subButton = (Button) findViewById(R.id.minus);
        subButton.setOnClickListener(this);
        multButton = (Button) findViewById(R.id.multiplication);
        multButton.setOnClickListener(this);
        divButton = (Button) findViewById(R.id.division);
        divButton.setOnClickListener(this);
        equalButton = (Button) findViewById(R.id.equal);
        equalButton.setOnClickListener(this);
        n0Button = (Button) findViewById(R.id.n0);
        n0Button.setOnClickListener(this);
        n1Button = (Button) findViewById(R.id.n1);
        n1Button.setOnClickListener(this);
        n2Button = (Button) findViewById(R.id.n2);
        n2Button.setOnClickListener(this);
        n3Button = (Button) findViewById(R.id.n3);
        n3Button.setOnClickListener(this);
        n4Button = (Button) findViewById(R.id.n4);
        n4Button.setOnClickListener(this);
        n5Button = (Button) findViewById(R.id.n5);
        n5Button.setOnClickListener(this);
        n6Button = (Button) findViewById(R.id.n6);
        n6Button.setOnClickListener(this);
        n7Button = (Button) findViewById(R.id.n7);
        n7Button.setOnClickListener(this);
        n8Button = (Button) findViewById(R.id.n8);
        n8Button.setOnClickListener(this);
        n9Button = (Button) findViewById(R.id.n9);
        n9Button.setOnClickListener(this);
        dotButton = (Button) findViewById(R.id.dot);
        dotButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String currentDisplay = calculatorScreen.getText().toString();
        switch (view.getId()) {
            case R.id.back: {
                calculatorScreen.setText(TextTransform.back(currentDisplay));
                break;
            }
            case R.id.clear: {
                calculatorScreen.setText(TextTransform.clear());
                break;
            }
            case R.id.plusMinus: {
                calculatorScreen.setText(TextTransform.signChange(currentDisplay));
                break;
            }
            case R.id.equal: {
                try {
                    String result = TextTransform.calculate(currentDisplay);
                    calculatorScreen.setText(String.valueOf(result));
                } catch (Exception e) {
                    String errorMessage = e.getMessage();
                    Toast.makeText(this, "Invalid expresion: " + errorMessage,
                            Toast.LENGTH_LONG).show();
                    calculatorScreen.setText(TextTransform.clear());
                }
                break;
            }
            default: {
                CharSequence newChar = ((Button) view).getText();
                calculatorScreen.setText(TextTransform.concatenate(currentDisplay, newChar));
                break;
            }
        }

    }


}