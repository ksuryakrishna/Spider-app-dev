package com.surya.basiccounterapp;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    int temp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickIncrease(View view){
        TextView abc = (TextView) findViewById(R.id.textview);
        abc.setText(""+temp);
        temp=temp+1;

    }
}
