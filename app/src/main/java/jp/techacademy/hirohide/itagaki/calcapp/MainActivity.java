package jp.techacademy.hirohide.itagaki.calcapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.text.TextUtils.isEmpty;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText EditText1;
    EditText EditText2;

    //EditTextをdouble型に変換するための変数
    double edit1 =0.0;
    double edit2 =0.0;
    //計算結果
    double result =0.0;

    // キーボード表示を制御するためのオブジェクト
    InputMethodManager inputMethodManager;
    // 背景のレイアウト
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //snackbar表示時にキーボードを隠し、フォーカスを背景に移すためのオブジェクト定義
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mainLayout = (LinearLayout) findViewById(R.id.main_layout);

        Button addition = (Button) findViewById(R.id.addition);
        addition.setOnClickListener(this);

        Button subtraction = (Button) findViewById(R.id.subtraction);
        subtraction.setOnClickListener(this);

        Button multiplication = (Button) findViewById(R.id.multiplication);
        multiplication.setOnClickListener(this);

        Button division = (Button) findViewById(R.id.division);
        division.setOnClickListener(this);

        EditText1 = (EditText) findViewById(R.id.editText1);
        EditText2 = (EditText) findViewById(R.id.editText2);

    }

    @Override
    public void onClick(View v) {
        try{
        //入力値をdouble型に変換
        edit1 = Double.parseDouble(EditText1.getText().toString());
        edit2 = Double.parseDouble(EditText2.getText().toString());

        }catch (Exception e){
            // キーボードを隠す
            inputMethodManager.hideSoftInputFromWindow(mainLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            // 背景にフォーカスを移す
            mainLayout.requestFocus();

            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_INDEFINITE).show();
            Log.d("calc_app", e.getMessage());
            return;
        }

        if (v.getId() == R.id.addition) {
            result = edit1 + edit2;
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", result);
            startActivity(intent);
        } else if(v.getId() == R.id.subtraction){
            result = edit1 - edit2;
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", result);
            startActivity(intent);
        }else if(v.getId() == R.id.multiplication){
            result = edit1 * edit2;
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", result);
            startActivity(intent);
        }else if(v.getId() == R.id.division){
            result = edit1 / edit2;
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", result);
            startActivity(intent);
        }
    }
}