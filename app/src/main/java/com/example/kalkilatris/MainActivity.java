package com.example.kalkilatris;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import org.mariuszgromada.math.mxparser.*;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView previousCal;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //previousCal = findViewById(R.id.previousCalculation);
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);
    }

    public void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos+strToAdd.length());

    }

    public void zeroBtnPress(View view){
        updateText(getResources().getString(R.string.zero));
    }
    public void unBtnPress(View view){
        updateText(getResources().getString(R.string.un));
    }
    public void deuxBtnPress(View view){
        updateText(getResources().getString(R.string.deux));
    }
    public void troisBtnPress(View view){
        updateText(getResources().getString(R.string.trois));
    }
    public void quatreBtnPress(View view){
        updateText(getResources().getString(R.string.quatre));
    }
    public void cinqBtnPress(View view){
        updateText(getResources().getString(R.string.cinq));
    }
    public void sixBtnPress(View view){
        updateText(getResources().getString(R.string.six));
    }
    public void septBtnPress(View view){
        updateText(getResources().getString(R.string.sept));
    }
    public void huitBtnPress(View view){
        updateText(getResources().getString(R.string.huit));
    }
    public void neufBtnPress(View view){
        updateText(getResources().getString(R.string.neuf));
    }

    public void parenOuvertBtnPress(View view){
        updateText(getResources().getString(R.string.parenOuvert));
    }
    public void parenFermeBtnPress(View view){
        updateText(getResources().getString(R.string.parenFerme));
    }
    public void adBtnPress(View view){
        updateText(getResources().getString(R.string.addition));
    }

    public void sousBtnPress(View view){
        updateText(getResources().getString(R.string.soustraction));
    }

    public void mulBtnPress(View view){
        updateText(getResources().getString(R.string.multipli));
    }

    public void divBtnPress(View view){
        updateText(getResources().getString(R.string.division));
    }

    public void pointBtnPress(View view){
        updateText(getResources().getString(R.string.point));
    }

    public void cosBtnPress(View view){
        updateText(getResources().getString(R.string.cos));
    }

    public void sinBtnPress(View view){
        updateText(getResources().getString(R.string.sin));
    }

    public void egalBtnPress(View view){
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll(getResources().getString(R.string.multipli), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
    public void retourBtnPress(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
}