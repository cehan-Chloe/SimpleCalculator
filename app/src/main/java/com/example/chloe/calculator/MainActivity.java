package com.example.chloe.calculator;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.Math;
import java.util.regex.Pattern;

public class MainActivity extends Activity implements OnClickListener {

    // clarify the element
    Button btn0 = null;
    Button btn1 = null;
    Button btn2 = null;
    Button btn3 = null;
    Button btn4 = null;
    Button btn5 = null;
    Button btn6 = null;
    Button btn7 = null;
    Button btn8 = null;
    Button btn9 = null;
    Button btnC = null;
    Button btnAdd = null;
    Button btnSub = null;
    Button btnMul = null;
    Button btnDiv = null;
    Button btnEqu = null;
    Button btnPercent = null;
    Button btnSqrt = null;
    Button btnM_plus = null;
    Button btnDot = null;
    Button btnM_minus = null;
    Button btnMRC = null;

    // the textview of expression
    TextView expressionResult = null;

    double result = 0;// result of expression
    double memory = 0; // initialize memory
    int memory_times = 0; // the times of push MRC button
    int lastOP = 0;
    int lastInput = 0; // 0 for num, 1 for op
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void displayDigit(int number) {
        if (lastOP == 6 || lastOP == 7) {
            expressionResult.setText(null);
            String myString = String.valueOf(number);
            expressionResult.setText(myString);
            result = number;
            lastInput = 0;
            lastOP = 0;
            return;
        }
        if (lastInput == 1) {
            expressionResult.setText(null);

        }
        String myString = expressionResult.getText().toString();
        myString += number;
        expressionResult.setText(myString);
        lastInput = 0;
    }

    public void binaryInputOperator(int curOP) {
        String myString = expressionResult.getText().toString();
        if (myString.isEmpty()){
            return;
        }
        updateResult();
        lastOP = curOP == 5 ? 0 : curOP;
        if(Double.isInfinite(result) || Double.isNaN(result)){
            expressionResult.setText(String.valueOf("Error"));
        }
        else{
            expressionResult.setText(String.valueOf(result));
        }
        lastInput = 1;
    }

    public void updateResult() {
        if (lastInput == 1) {
            return;
        }
        double curNumInDisplay = Double.valueOf(expressionResult.getText().toString());
        switch (lastOP) {
            case 0: //empty, default value
            {
                result = curNumInDisplay;
                break;
            }
            case 1: //plus
            {
                result += curNumInDisplay;
                break;
            }
            case 2: //sub
            {
                result -= curNumInDisplay;
                break;
            }
            case 3: //mul
            {
                result *= curNumInDisplay;
                break;
            }
            case 4: // div
            {
                result /= curNumInDisplay;
                break;
            }
            case 5: // equal
            {
                break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // direct to activity_main view
        setContentView(R.layout.activity_main);

        // add element
        btn0 = (Button) findViewById(R.id.btnZero);
        btn1 = (Button) findViewById(R.id.btnOne);
        btn2 = (Button) findViewById(R.id.btnTwo);
        btn3 = (Button) findViewById(R.id.btnThree);
        btn4 = (Button) findViewById(R.id.btnFour);
        btn5 = (Button) findViewById(R.id.btnFive);
        btn6 = (Button) findViewById(R.id.btnSix);
        btn7 = (Button) findViewById(R.id.btnSeven);
        btn8 = (Button) findViewById(R.id.btnEight);
        btn9 = (Button) findViewById(R.id.btnNine);


        btnEqu = (Button) findViewById(R.id.btnEqu);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDivide);
        expressionResult = (TextView) findViewById(R.id.expressionView);

        btnC = (Button) findViewById(R.id.btnClear);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnPercent = (Button) findViewById(R.id.btnPercent);
        btnSqrt = (Button) findViewById(R.id.btnSqrt);

        btnM_plus = (Button) findViewById(R.id.btnM_plus);
        btnM_minus = (Button) findViewById(R.id.btnM_minus);
        btnMRC = (Button) findViewById(R.id.btnMRC);


        //add listener
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqu.setOnClickListener(this);

        btnC.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);

        btnM_plus.setOnClickListener(this);
        btnM_minus.setOnClickListener(this);
        btnMRC.setOnClickListener(this);

        expressionResult.setEllipsize(null);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // the response of each button 0-9
            case R.id.btnZero:
                displayDigit(0);
                break;
            case R.id.btnOne:
                displayDigit(1);
                break;
            case R.id.btnTwo:
                displayDigit(2);
                break;
            case R.id.btnThree:
                displayDigit(3);
                break;
            case R.id.btnFour:
                displayDigit(4);
                break;
            case R.id.btnFive:
                displayDigit(5);
                break;
            case R.id.btnSix:
                displayDigit(6);
                break;
            case R.id.btnSeven:
                displayDigit(7);
                break;
            case R.id.btnEight:
                displayDigit(8);
                break;
            case R.id.btnNine:
                displayDigit(9);
                break;


            case R.id.btnClear:
                expressionResult.setText(null);
                result = 0;
                lastOP = 0;
                break;

            case R.id.btnDot:
                String stringDot = expressionResult.getText().toString();
                if (stringDot.isEmpty()) {
                    stringDot = "0";
                }

                String decimalPattern = "((-)?[0-9]*)\\.([0-9]*)";
                boolean match = Pattern.matches(decimalPattern, stringDot);
                if (match){
                    return;
                }
                stringDot += ".";
                expressionResult.setText(stringDot);
                break;

            // the response of each operator button
            case R.id.btnAdd:
                binaryInputOperator(1);
                break;

            case R.id.btnSub:
                binaryInputOperator(2);
                break;

            case R.id.btnMul:
                binaryInputOperator(3);
                break;

            case R.id.btnDivide:
                binaryInputOperator(4);
                break;

            case R.id.btnEqu:
                binaryInputOperator(5);
                break;

            case R.id.btnPercent:
                String stringPercent = expressionResult.getText().toString();
                if (stringPercent.isEmpty()){
                    return;
                }
                if (lastOP != 0) {
                    updateResult();
                } else {
                    result = Double.valueOf(expressionResult.getText().toString());
                }
                result /= 100;
                if(Double.isInfinite(result) || Double.isNaN(result)){
                    expressionResult.setText(String.valueOf("Error"));
                    break;
                }
                expressionResult.setText(String.valueOf(result));
                lastInput = 1;
                lastOP = 0;
                break;

            case R.id.btnSqrt:
                String stringSqrt = expressionResult.getText().toString();
                if (stringSqrt.isEmpty()){
                    return;
                }
                if (lastOP != 0) {
                    updateResult();
                } else {
                    result = Double.valueOf(expressionResult.getText().toString());
                }
                result = Math.sqrt(result);
                if(Double.isInfinite(result) || Double.isNaN(result)){
                    expressionResult.setText(String.valueOf("Error"));
                    break;
                }
                expressionResult.setText(String.valueOf(result));
                lastInput = 1;
                lastOP = 0;
                break;

            case R.id.btnMRC:
                if (memory_times == 0){
                    expressionResult.setText(String.valueOf(memory));
                    memory_times = 1;
                }
                else{
                    memory = 0;
                    expressionResult.setText(String.valueOf(memory));
                    memory_times = 0;
                }
                lastInput = 1;
                lastOP = 0;
                break;

            case R.id.btnM_plus:
                memory += Double.valueOf(expressionResult.getText().toString());
                result = memory;
                expressionResult.setText(String.valueOf(result));
                lastInput = 1;
                lastOP = 0;
                break;

            case R.id.btnM_minus:
                memory -= Double.valueOf(expressionResult.getText().toString());
                result = memory;
                expressionResult.setText(String.valueOf(result));
                lastInput = 1;
                lastOP = 0;
                break;

            default:
                break;
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

