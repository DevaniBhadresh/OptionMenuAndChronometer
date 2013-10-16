package com.menuDemo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuDemoActivity extends Activity implements OnClickListener, OnChronometerTickListener {
    /** Called when the activity is first created. */
	LinearLayout ln;
	EditText editsec;
	Button btclick;
	TextView msg;
	Chronometer timer;
	int sec=0,delay=0,clCng=0;
	String[] allColors;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Resources res=getResources();
        allColors=res.getStringArray(R.array.colors);
        editsec=(EditText) findViewById(R.id.txtEdt);
        btclick=(Button) findViewById(R.id.btnClk);
        msg=(TextView) findViewById(R.id.lblHead);
        timer=(Chronometer) findViewById(R.id.chronometer1);
        timer.setVisibility(-1);
        btclick.setOnClickListener(this);
        timer.setOnChronometerTickListener(this);
        
        
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
     
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	ln=(LinearLayout)findViewById(R.id.linearLayout1);
        switch (item.getItemId())
        {
        case R.id.blue:
        	ln.setBackgroundColor(Color.BLUE);
            return true;
 
        case R.id.green:
        	ln.setBackgroundColor(Color.GREEN);
            return true;
 
        case R.id.red:
        	ln.setBackgroundColor(Color.RED);
            return true;
 
        case R.id.yellow:
        	ln.setBackgroundColor(Color.YELLOW);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==btclick.getId())
		  {
		   delay=Integer.parseInt(editsec.getText().toString());
		   sec=0;
		   timer.start();
		     
		  }
	}
	@Override
	public void onChronometerTick(Chronometer arg0) {
		// TODO Auto-generated method stub
		  ln=(LinearLayout)findViewById(R.id.linearLayout1);
		  msg.setText("Color Changed in [ 0"+ (delay-sec) +" ] sec delay");
		  sec++;
		  clCng++;
		 // Color.parseColor(allColors[0]); // red
		 // Color.parseColor(allColors[1]); // green
		 // Color.parseColor(allColors[2]); // blue
		  if(sec==delay)
		  {
		   ln.setBackgroundColor(Color.parseColor(allColors[(clCng%7)])); 
		   sec=0;
		   Toast.makeText(this, "BackGround Color Is Changed...", Toast.LENGTH_SHORT).show();
		  }
	}     
}