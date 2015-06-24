package com.example.erialdo.modar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

    EditText editTextN;
    EditText editTextX;
    EditText editTextY;
    EditText pergjigja;

    Button btnAdd;
    Button btnMult;
    Button btnSub;
    Button btnDiv;
    Button btnMod;
    Button btnGCD;
    Button btnInv;
    Button btnExGCD;
    Button btnPow;
    Button historyBtn;
    Button advOptBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextN = (EditText) findViewById(R.id.editTextN);
        editTextX = (EditText) findViewById(R.id.editTextX);
        editTextY = (EditText) findViewById(R.id.editTextY);
        pergjigja = (EditText) findViewById(R.id.pergjigja);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMod = (Button) findViewById(R.id.btnMod);
        btnGCD = (Button) findViewById(R.id.btnGCD);
        btnInv = (Button) findViewById(R.id.btnInv);
        btnExGCD = (Button) findViewById(R.id.btnExGCD);
        btnPow = (Button) findViewById(R.id.btnPow);
        historyBtn = (Button) findViewById(R.id.historyBtn);
        advOptBtn = (Button) findViewById(R.id.advopBtn);

        btnAdd.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnGCD.setOnClickListener(this);
        btnInv.setOnClickListener(this);
        btnExGCD.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        historyBtn.setOnClickListener(this);
        advOptBtn.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        Integer nNum = 1;
        Integer xNum ;
        Integer yNum ;

        Integer result = 0 ;

        if(TextUtils.isEmpty(editTextN.getText().toString())
                || TextUtils.isEmpty(editTextX.getText().toString())) {
            return;
        }
        nNum = Integer.parseInt(editTextN.getText().toString());
        xNum = Integer.parseInt(editTextX.getText().toString());
        yNum = Integer.parseInt(editTextY.getText().toString());

        switch (v.getId()) {
            case R.id.btnAdd: {
                result = ((xNum + yNum)%nNum);
                if(result < 0) result += nNum;
            }break;

            case R.id.btnSub: {
                result = ((xNum - yNum)%nNum);
                if(result < 0) result += nNum;
            }break;

            case R.id.btnMult: {
                result = ((xNum * yNum)%nNum);
                if(result < 0) result += nNum;
            }break;

            case R.id.btnDiv: {
                result = (int) Math.floor(xNum / yNum);
            }break;

            case R.id.btnMod: {
                result = (xNum % yNum);
                if(result < 0) result += yNum;
            }break;

            default:
                break;

        }

        pergjigja.setText(""+result);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
//hello
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
