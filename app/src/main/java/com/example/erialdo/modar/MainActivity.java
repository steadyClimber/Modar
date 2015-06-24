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

import java.math.BigInteger;
import java.util.ArrayList;

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
        Integer resultInv = 0; // ruan rezultatin e inversit te numrit
        // ky variabel i dyte u shtua per shkak se ka vetem nje obj result BigInteger
        // pra nuk mund te kete nje objekt result BigInteger me dy vlera ne te njejten kohe
        if(TextUtils.isEmpty(editTextN.getText().toString())
                || TextUtils.isEmpty(editTextX.getText().toString())
                || TextUtils.isEmpty(editTextY.getText().toString())) {
            return;
        }

        nNum = Integer.parseInt(editTextN.getText().toString());
        xNum = Integer.parseInt(editTextX.getText().toString());
        yNum = Integer.parseInt(editTextY.getText().toString());

        int a=0,b=0;
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
                result = (xNum % yNum)%nNum;
                if(result < 0) result += yNum;
            }break;

            case R.id.btnGCD: {
                result=gcd(xNum,yNum);
            }break;
            case R.id.btnExGCD: {
                int vals[]=extendedGCD(xNum,yNum);
                a = vals[1];
                b = vals[2];
                result = gcd(xNum,yNum);
            }break;
            case R.id.btnInv: {
                BigInteger x,n;
                x = BigInteger.valueOf(xNum);
                n = BigInteger.valueOf(nNum);
                BigInteger res = x.modInverse(n);

                resultInv = res.intValue();
            }
            case R.id.btnPow: {
                BigInteger x,y,n;
                x = BigInteger.valueOf(xNum);
                y = BigInteger.valueOf(yNum);
                n = BigInteger.valueOf(nNum);
                BigInteger res = x.modPow(y,n);

                result = res.intValue();
            }

            default:
                break;

        }

        if(v.getId() == R.id.btnAdd){
            pergjigja.setText(result+"="+xNum+"+"+yNum+" mod("+nNum+")");
        }else if(v.getId() == R.id.btnSub){
            pergjigja.setText(result + "=" + xNum + "-" + yNum + " mod(" + nNum + ")");

        }else if(v.getId() == R.id.btnDiv) {
            pergjigja.setText(result + " = [" +xNum+ "/" + yNum + "]" );

        }else if(v.getId() == R.id.btnMult){
            pergjigja.setText(result + "=" + xNum + "*" + yNum + " mod(" + nNum + ")");

        }else if(v.getId() == R.id.btnMod) {
            pergjigja.setText(result+"="+xNum+" Mod "+yNum+"  mod("+nNum+")");

        }else if(v.getId() == R.id.btnGCD) {
            pergjigja.setText(result+" = gcd( "+xNum+", "+yNum+" )");

        }else if(v.getId()==R.id.btnInv) {
            pergjigja.setText(resultInv+" = "+xNum+"^-1 mod("+nNum+")");

        }else if(v.getId() == R.id.btnExGCD) {
            pergjigja.setText(xNum+"*("+a+") + "+yNum+"*("+b+") = "+result);
        }else if(v.getId() == R.id.btnPow) {
            pergjigja.setText(result+" = "+xNum+"^"+yNum+" mod("+nNum+")");
        }else
        pergjigja.setText(""+result);

    }

    public int gcd(int a,int b) {
        int mb;
        int i;
        a = Math.abs(a); b = Math.abs(b);
        for(i = 0; i < 1000; i++)
        {
            if(b == 0) {return (a);}
            mb = a%b;
            a = b;
            b = mb;
        }
        return 0;
    }


    //  return array [d, a, b] such that d = gcd(p, q), ap + bq = d
    static int[] extendedGCD(int p, int q) {
        if (q == 0)
            return new int[] { p, 1, 0 };

        int[] vals = extendedGCD(q, p % q);
        int d = vals[0];
        int a = vals[2];
        int b = vals[1] - (p / q) * vals[2];
        return new int[] { d, a, b };
    }



/*
    /**
     * Calculates the extended GCD.
     * @param aux the helper array
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of the a & b. GCD(a,b) = u*a + v*b. Stores m and n in the helper array.
     *
     */
   /* public static  int  extendedGCD(int[] aux, int a, int b) {
        int  tempo;
        if (a*b ==0 ){	//EXIT condition
            tempo =  a + b;
        }
        else {
            tempo = extendedGCD(aux, b, a % b);
            int temp = aux[0];
            aux[0] = aux[1];
            aux[1] = temp - aux[1]*(a/b);
        }
        return tempo;
    }
*/




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
