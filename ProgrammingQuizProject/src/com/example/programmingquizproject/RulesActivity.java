package com.example.programmingquizproject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class RulesActivity extends Activity {

	
	TextView t3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rules);
		setTitle("Rules - Quizoid");
		
		
		t3=(TextView)findViewById(R.id.rulestext);
		
		t3.append("\n\t\t\t\t *Total number of questions : 20");
		t3.append("\n\t\t\t\t *Attempt All Questions");
		t3.append("\n\t\t\t\t *Time alloted : 30 minutes");
		t3.append("\n\t\t\t\t *Each question carry 1 mark\n\t\t\t\t\t  with no Negative Marking.");
	}
}
