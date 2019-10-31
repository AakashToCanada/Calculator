package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;

    //Variables to hond operands and type of calculations
    private Double operand1 = null;
    private Double operand2 = null;
    private String operation = "=";
    private final String operatorValueToBESaved = "operatorToBeSaved";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(operatorValueToBESaved, displayOperation.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        displayOperation.setText(savedInstanceState.getString(operatorValueToBESaved));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        newNumber = findViewById(R.id.newNumber);
        displayOperation = findViewById(R.id.operation);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        Button buttonNegative = findViewById(R.id.buttonNegative);
        Button buttonEquals = findViewById(R.id.buttonEqual);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonSubtraction = findViewById(R.id.buttonSubtract);
        Button buttonAddition = findViewById(R.id.buttonAddition);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonClear = findViewById(R.id.buttonClear);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                newNumber.append(b.getText().toString());
            }
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);


        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (b.getText().toString().equalsIgnoreCase("CLEAR")) {
                    result.setText("");
                } else if (b.getText().toString().equalsIgnoreCase("NEG")) {
                    if (newNumber.getText().toString().equalsIgnoreCase("")) {
                        newNumber.setText("-");
                    }
                } else {
                    if (displayOperation.getText().toString().length() == 0 || displayOperation.getText().toString().equalsIgnoreCase("=")) {
                        displayOperation.setText(b.getText().toString());
                    }

                    if (newNumber.getText().toString().length() == 0 && displayOperation.getText().toString().equalsIgnoreCase("=")) {
                        result.setText("");
                    }

                    if (newNumber.getText().toString().length() != 0) {
                        if (result.getText().toString().length() != 0) {
                            Double op1 = Double.valueOf(result.getText().toString());
                            Double op2 = Double.valueOf(newNumber.getText().toString());
                            switch (displayOperation.getText().toString()) {
                                case "+":
                                    op1 = op1 + op2;
                                    break;
                                case "*":
                                    op1 = op1 * op2;
                                    break;
                                case "-":
                                    op1 = op1 - op2;
                                    break;
                                case "/":
                                    if (op1 == Double.valueOf(0) || op2.intValue() == Double.valueOf(0)) {
                                        op1 = 0.0;
                                        break;
                                    }
                                    op1 = op1 / op2;
                                    break;
                                case "=":
                                    op1 = op2;
                                    break;

                            }
                            result.setText("" + op1);
                            displayOperation.setText(b.getText().toString());
                            newNumber.setText("");
                        } else {
                            result.setText(newNumber.getText().toString());
                            newNumber.setText("");
                        }

                    }

                }
            }

        };


        buttonEquals.setOnClickListener(listener1);
        buttonDivide.setOnClickListener(listener1);
        buttonSubtraction.setOnClickListener(listener1);
        buttonAddition.setOnClickListener(listener1);
        buttonMultiply.setOnClickListener(listener1);
        buttonNegative.setOnClickListener(listener1);
        buttonClear.setOnClickListener(listener1);
    }


}
