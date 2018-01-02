package com.example.programmingquizproject;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class Splash_Activity extends Activity {

	ProgressDialog pd;
	Button b1, b2;
	int i=1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        setTitle("QUIZOID");
        final Animation anima=AnimationUtils.loadAnimation(this, R.anim.rotate);
        b2=(Button)findViewById(R.id.start);
        b1=(Button)findViewById(R.id.rules);
        
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
					v.startAnimation(anima);
					Intent i=new Intent(Splash_Activity.this, RulesActivity.class);
					startActivity(i);
			}
		});
        
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				v.startAnimation(anima);
				
				pd=new ProgressDialog(Splash_Activity.this);
		        
				
				
				pd.setMessage("Loading Just Wait...");
				
				pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				
				pd.setIndeterminate(true);
				pd.setCancelable(false);
				pd.setCanceledOnTouchOutside(false);
				
				pd.show();
				final int loadtime=100;
				Thread t=new Thread()
				{
					public void run()
					{
						int time=0;
						while(time < loadtime)
						{
							try {
								sleep(200);
								time+=10;
								pd.incrementProgressBy(time);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						if(time >= loadtime)
						{
							//pd.cancel();
							Intent i=new Intent(Splash_Activity.this, QuizStartActivity.class);
							startActivity(i);
							pd.cancel();
						}
					}
				};
				t.start();
				
				
				//Toast.makeText(Splash_Activity.this, "Loop Executed", Toast.LENGTH_LONG).show();
			}
				
		});
        
    }
}
