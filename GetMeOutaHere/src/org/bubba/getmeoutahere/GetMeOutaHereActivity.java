package org.bubba.getmeoutahere;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class GetMeOutaHereActivity extends Activity 
{
	public int timeMultiplier = 60;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new NumberAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            {
            	System.err.println("asdfasdf");
            	Button b = (Button) v;
            	b.setText(b.getText() + "x");
                Toast.makeText(GetMeOutaHereActivity.this, "aaaa" 
                		+ position, Toast.LENGTH_SHORT).show();
            }
        });

        Button minutesButton = (Button)findViewById(R.id.minutes);
		minutesButton.setOnClickListener(
			new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					timeMultiplier = 60;
				}
			});

		
        Button secondsButton = (Button)findViewById(R.id.seconds);
		secondsButton.setOnClickListener(
			new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					timeMultiplier = 1;
				}
			});
    }
}