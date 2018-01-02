package com.example.programmingquizproject;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class StartQuizActivity extends Activity {

	PopupMenu pm;
	Button b1,b2;
	TextView t1,t2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_quiz);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		setTitle("QUIZOID");
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.quiz);
		t2.setSelected(true);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				pm=new PopupMenu(StartQuizActivity.this,b2);
				pm.getMenuInflater().inflate(R.menu.menu_popup, pm.getMenu());
				pm.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						Toast.makeText(StartQuizActivity.this,"Selected : " + item.getTitle() + " Level ", 2000).show();
						b2.setText(item.getTitle());
						return false;
					}
				});
				pm.show();
			}
		});
		
	}
}
