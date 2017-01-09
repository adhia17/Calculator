package com.dhiandian.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.display)
    TextView display;
    @Bind(R.id.display_screen)
    LinearLayout displayScreen;
    @Bind(R.id.btn_open_bracket)
    Button btnOpenBracket;
    @Bind(R.id.btn_close_bracket)
    Button btnCloseBracket;
    @Bind(R.id.btn_x_square)
    Button btnXSquare;
    @Bind(R.id.btn_clear)
    Button btnClear;
    @Bind(R.id.btn_seven)
    Button btnSeven;
    @Bind(R.id.btn_eight)
    Button btnEight;
    @Bind(R.id.btn_nine)
    Button btnNine;
    @Bind(R.id.btn_division)
    Button btnDivision;
    @Bind(R.id.btn_four)
    Button btnFour;
    @Bind(R.id.btn_five)
    Button btnFive;
    @Bind(R.id.btn_six)
    Button btnSix;
    @Bind(R.id.btn_multiplication)
    Button btnMultiplication;
    @Bind(R.id.btn_one)
    Button btnOne;
    @Bind(R.id.btn_two)
    Button btnTwo;
    @Bind(R.id.btn_three)
    Button btnThree;
    @Bind(R.id.btn_subtraction)
    Button btnSubtraction;
    @Bind(R.id.btn_zero)
    Button btnZero;
    @Bind(R.id.btn_dot)
    Button btnDot;
    @Bind(R.id.btn_equal)
    Button btnEqual;
    @Bind(R.id.btn_addition)
    Button btnAddition;
    @Bind(R.id.linearLay0)
    LinearLayout linearLay0;

    private String lastResultObtain = "";
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_open_bracket, R.id.btn_close_bracket, R.id.btn_x_square, R.id.btn_clear, R.id.btn_seven, R.id.btn_eight, R.id.btn_nine, R.id.btn_division, R.id.btn_four, R.id.btn_five, R.id.btn_six, R.id.btn_multiplication, R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_subtraction, R.id.btn_zero, R.id.btn_dot, R.id.btn_equal, R.id.btn_addition})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                currentDisplayedInput += "0";
                inputToBeParsed += "0";
                break;
            case R.id.btn_one:
                currentDisplayedInput += "1";
                inputToBeParsed += "1";
                break;
            case R.id.btn_two:
                currentDisplayedInput += "2";
                inputToBeParsed += "2";
                break;
            case R.id.btn_three:
                currentDisplayedInput += "3";
                inputToBeParsed += "3";
                break;
            case R.id.btn_four:
                currentDisplayedInput += "4";
                inputToBeParsed += "4";
                break;
            case R.id.btn_five:
                currentDisplayedInput += "5";
                inputToBeParsed += "5";
                break;
            case R.id.btn_six:
                currentDisplayedInput += "6";
                inputToBeParsed += "6";
                break;
            case R.id.btn_seven:
                currentDisplayedInput += "7";
                inputToBeParsed += "7";
                break;
            case R.id.btn_eight:
                currentDisplayedInput += "8";
                inputToBeParsed += "8";
                break;
            case R.id.btn_nine:
                currentDisplayedInput += "9";
                inputToBeParsed += "9";
                break;
            case R.id.btn_open_bracket:
                currentDisplayedInput += "(";
                inputToBeParsed += "(";
                break;
            case R.id.btn_close_bracket:
                currentDisplayedInput += ")";
                inputToBeParsed += ")";
                break;
            case R.id.btn_x_square:
                currentDisplayedInput += "^2";
                inputToBeParsed += "^2";
                break;
            case R.id.btn_clear:
                display.setText("");
                currentDisplayedInput = "";
                inputToBeParsed = "";
                break;
            case R.id.btn_division:
                currentDisplayedInput += "÷";
                inputToBeParsed += "/";
                break;
            case R.id.btn_multiplication:
                currentDisplayedInput += "x";
                inputToBeParsed += "*";
                break;
            case R.id.btn_subtraction:
                currentDisplayedInput += "-";
                inputToBeParsed += "-";
                break;
            case R.id.btn_addition:
                currentDisplayedInput += "+";
                inputToBeParsed += "+";
                break;
            case R.id.btn_equal:
                Calculator mCalculator = new Calculator();
                String enteredInput = display.getText().toString();
                String resultObject = mCalculator.getResult(currentDisplayedInput, inputToBeParsed);
                display.setText(removeTrailingZero(resultObject));
                currentDisplayedInput = "";
                inputToBeParsed = "";
                break;
            case R.id.btn_dot:
                currentDisplayedInput += ".";
                inputToBeParsed += ".";
                break;
        }
        if (!(view.getId() == R.id.btn_equal))
            display.setText(currentDisplayedInput);
    }

    private String removeTrailingZero(String formattingInput) {
        if (!formattingInput.contains(".")) {
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if (newValue.equals(".0")) {
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }
}
