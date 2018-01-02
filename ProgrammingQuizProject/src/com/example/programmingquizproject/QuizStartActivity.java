package com.example.programmingquizproject;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class QuizStartActivity extends Activity {

	PopupMenu pm;
	Button b1,b2;
	TextView t1,t2,t3,t4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz_start);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		setTitle("QUIZOID");
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.quiz);
		t4=(TextView)findViewById(R.id.textView4);
		t2.setSelected(true);
		//b1.setEnabled(false);
		b1.setVisibility(View.INVISIBLE);
		final String s1="The Following Section consists of C, JAVA, DOTNET, NETWORKING, WEB-DEVELOPMENT, LINUX Miscellaneous Questions ";
		final String s2="Take the test on these topics and improve your skills.";
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				pm=new PopupMenu(QuizStartActivity.this,b2);
				pm.getMenuInflater().inflate(R.menu.menu_popup, pm.getMenu());
				pm.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						
						if(item.getTitle().equals("Beginner"))
						{
							b1.setVisibility(View.VISIBLE);
							//b1.setEnabled(true);
							t4.setText(s1+"at a Core(Beginner) level. We highly recommend you to "+s2);
						}
						if(item.getTitle().equals("Professional"))
						{
							b1.setVisibility(View.VISIBLE);
							//b1.setEnabled(true);
							t4.setText(s1+"at an Advanced(Professional) level. Dive into the pool of questions and "+s2);
						}
						if(item.getTitle().equals("Expert"))
						{
							b1.setVisibility(View.VISIBLE);
							//b1.setEnabled(true);
							t4.setText(s1+"at an Expert level. Take the test on these Topics and dig the depth of your knowledge.");
						}
						Toast.makeText(QuizStartActivity.this,"Selected : " + item.getTitle() + " Level ", Toast.LENGTH_SHORT).show();
						b2.setText(item.getTitle());
						return false;
					}
				});
				pm.show();
			}
		});
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(QuizStartActivity.this, QuizTestActivity.class);
				startActivity(i1);
			}
		});
	}
}
