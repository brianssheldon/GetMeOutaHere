package org.bubba.getmeoutahere;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class NumberAdapter extends BaseAdapter
{
    private Context mContext;
    public MediaPlayer mPlayer;

	public NumberAdapter(GetMeOutaHereActivity getMeOutaHereActivity)
	{
		mContext = getMeOutaHereActivity;
	}

	@Override
	public int getCount()
	{
		return 9;
	}

	@Override
	public Object getItem(int arg0)
	{
		return null;
	}

	@Override
	public long getItemId(int arg0)
	{
		return 0;
	}

	@Override
	public View getView(int number, View view, ViewGroup viewGroup)
	{
		Button button;
        if (view == null) {  // if it's not recycled, initialize some attributes
        	button = new Button(mContext);
        	button.setText("" + (number + 1));
        	button.setTextSize(15);
        	button.setLayoutParams(new GridView.LayoutParams(85, 85));
        	button.setPadding(8, 8, 8, 8);
        } 
        else 
        {
        	button = (Button) view;
        }

        OnClickListener buttonListener = new OnClickListener()
		{
			@Override
			public void onClick(final View v)
			{
				Button b = (Button)v;
				int i = Integer.parseInt((String) b.getText());
				try
				{
					v.postDelayed(
						new Runnable()
						{
						       public void run() 
						       {
						    	   Uri uri = RingtoneManager.getActualDefaultRingtoneUri(
						    			   v.getContext(), RingtoneManager.TYPE_RINGTONE);
						    	   
						    	   if(uri == null)
						    	   {
						    		   mPlayer = MediaPlayer.create(v.getContext(), R.raw.aringtone);
						    	   }
						    	   else
						    	   {
						    		   mPlayer = MediaPlayer.create(v.getContext(), uri);
						    	   }
						    	   
								   mPlayer.setScreenOnWhilePlaying(true);
                                   mPlayer.setLooping(true);
                                   mPlayer.start();
								   v.postDelayed(new Runnable(){public void run(){
									   mPlayer.stop();
									   mPlayer.release();}}, 30000);
						       }
						 }, i * 1000 * ((GetMeOutaHereActivity)v.getContext()).timeMultiplier);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		};

        button.setOnClickListener(buttonListener);
        return button;
	}

    public MediaPlayer getmPlayer() {
        return mPlayer;
    }

    public void setmPlayer(MediaPlayer mPlayer) {
        this.mPlayer = mPlayer;
    }
}