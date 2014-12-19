package io.naotou.edit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText text;
    private Button d;
    private Button c;
    private Button b;
    private Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        findViewById(R.id.e).setOnClickListener(this);
        text = (EditText) findViewById(R.id.edit);
        text.setClickable(false);
//        text.setFocusable(false);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a:
                Editable a1 = text.getText().append("a");
                text.setText(a1);
                text.setSelection(a1.length());
                break;
            case R.id.b:
                Editable b1 = text.getText().append("b");
                text.setText(b1);
                text.setSelection(b1.length());
                break;
            case R.id.c:
                Editable c1 = text.getText().append("c");
                text.setText(c1);
                text.setSelection(c1.length());
                break;
            case R.id.d:
                Editable d1 = text.getText().append("d");
                text.setText(d1);
                text.setSelection(d1.length());
                break;
            case R.id.e:
                Editable e1 = text.getText().append("</>");
                text.setText(e1);
                text.setSelection(e1.length()-2);
                break;
        }

    }
}
