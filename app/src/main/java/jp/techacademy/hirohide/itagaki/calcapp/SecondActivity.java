package jp.techacademy.hirohide.itagaki.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("VALUE1",0.0);

        TextView resultView = (TextView) findViewById(R.id.resultView);
        //resultView.setText(""); //初期化
        resultView.setText(String.valueOf(result));
    }
}