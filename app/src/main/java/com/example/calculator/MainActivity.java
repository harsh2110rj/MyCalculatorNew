package com.example.calculator;



import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;

    private Double operand1;
    private Double operand2;
    private double as2s;
    private String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (EditText) findViewById(R.id.result);
        newNumber = (EditText) findViewById(R.id.newNumber);
        displayOperation = (TextView) findViewById(R.id.displayOperation);


        Button button0 = (Button) findViewById(R.id.button00);
        Button button1 = (Button) findViewById(R.id.button01);
        Button button2 = (Button) findViewById(R.id.button02);

        Button button3 = (Button) findViewById(R.id.button03);

        Button button4 = (Button) findViewById(R.id.button04);

        Button button5 = (Button) findViewById(R.id.button05);

        Button button6 = (Button) findViewById(R.id.button06);

        Button button7 = (Button) findViewById(R.id.button07);

        Button button8 = (Button) findViewById(R.id.button08);

        Button button9 = (Button) findViewById(R.id.button09);

        Button buttonPoint = (Button) findViewById(R.id.point);

        final Button buttonEquals = (Button) findViewById(R.id.equals);

        Button buttonPlus = (Button) findViewById(R.id.plus);

        Button buttonMinus = (Button) findViewById(R.id.minus);

        Button buttonMultiply = (Button) findViewById(R.id.multiply);

        Button buttonDivide = (Button) findViewById(R.id.divide);

//        Button button0=(Button)findViewById(R.id.button00);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
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
        buttonPoint.setOnClickListener(listener);


        final View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = newNumber.getText().toString();

                try {

                    Double doubleValue = Double.valueOf(value);
                    performOperation(doubleValue, op);

//            buttonEquals.setOnClickListener(opListener);
                } catch (NumberFormatException e) {
                    newNumber.setText("");
                }

                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }

        };
        buttonEquals.setOnClickListener(opListener);
        buttonDivide.setOnClickListener(opListener);
        buttonMultiply.setOnClickListener(opListener);
        buttonMinus.setOnClickListener(opListener);
        buttonPlus.setOnClickListener(opListener);

        Button buttonNeg = (Button) findViewById(R.id.buttonNeg);
        buttonNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = newNumber.getText().toString();
                if (value.length() == 0) {
                    newNumber.setText("-");
                } else {
                    try {
                        Double doubleValue = Double.valueOf(value);
                        doubleValue *= -1;
                        newNumber.setText(doubleValue.toString());
                    } catch (NumberFormatException e) {
                        newNumber.setText("");
                    }
                }
            }
        });


    }

    private void performOperation(Double value, String op) {
//        displayOperation.setText(op);
        if (operand1 == null) {
            operand1 = value;
        }//result.setText(operand1.toString());}
        else {
            operand2 = value;
            if (pendingOperation.equals("=")) {
                pendingOperation = op;
            }
            switch (pendingOperation) {
                case "=":
                    operand1 = operand2;
                    break;
                case "+":
                    operand1 += operand2;
                    break;
                case "-":
                    operand1 -= operand2;
                    break;
                case "*":
                    operand1 *= operand2;
                    break;
                case "/":
                    if (operand2 == 0) {
                        operand1 = 0.0;
                    } else {
                        operand1 /= operand2;
                    }
                    break;

            }


        }
        result.setText(operand1.toString());
        newNumber.setText("");
    }

}
