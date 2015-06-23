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
    EditText pergjigja;
    Button btnAdd;


    String oper = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextN = (EditText) findViewById(R.id.editTextN);
        editTextX = (EditText) findViewById(R.id.editTextX);
        pergjigja = (EditText) findViewById(R.id.pergjigja);

        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Integer nNum = 0;
        Integer xNum = 0;

        Integer result = 0;

        if(TextUtils.isEmpty(editTextN.getText().toString())
                || TextUtils.isEmpty(editTextX.getText().toString())) {
            return;
        }
        nNum = Integer.parseInt(editTextN.getText().toString());
        xNum = Integer.parseInt(editTextX.getText().toString());

        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "Z=X+Y";
                result = nNum + xNum;
                break;
            default:
                break;
        }
        pergjigja.setText("3547 * 4555 - 31444 * 1245 = 1"+result);

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
