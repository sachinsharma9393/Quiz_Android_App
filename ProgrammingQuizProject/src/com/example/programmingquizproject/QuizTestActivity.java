package com.example.programmingquizproject;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizTestActivity extends Activity implements OnClickListener {

	String answers,solution;
	String ques;
	SQLiteDatabase db;
	Button b1,b2,b3,submit,b5,b6;
	TextView answer,question;
	
	Cursor quesc,optionc,optioncursor,questioncursor;
	
	int i=1,j=0,k=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz_test);
		
		question=(TextView)findViewById(R.id.ques);
		
		db=openOrCreateDatabase("Quiz", MODE_PRIVATE, null);
		//db.execSQL("Drop table QuesAns;");
		//db.execSQL("Drop table Options;");
		
		//db.execSQL("Create table Mode(mid int(10) PRIMARY KEY, mname varchar(50));");
		db.execSQL("Create table QuesAns(mid int(10), qid int(10) PRIMARY KEY, qname TEXT, answer TEXT, solution TEXT);");
		db.execSQL("Create table Options(qid int(10), optionid int(10), optionname TEXT);");
		
		//db.execSQL("Insert into Mode values(1, 'Beginner');");
		//db.execSQL("Insert into Mode values(2, 'Professional');");
		//db.execSQL("Insert into Mode values(3, 'Expert');");

		db.execSQL("Insert into QuesAns values(1,1,'Q>. How many times can a constructor be called during lifetime of the object ? ','Only once.',' A Constructor is always called immediately after creating objects for filing the data into object. Hence, Constructor can called only once during the lifetime of the object. ');");
		db.execSQL("Insert into Options values(1,1,'A>. Only once. ');");
		db.execSQL("Insert into Options values(1,2,'B>. As many times as we call it. ');");
		db.execSQL("Insert into Options values(1,3,'C>. Any number of times before the object gets garbage collected. ');");
		
		
		db.execSQL("Insert into QuesAns values(1,2,'Q>. What will be the value of i when executing int i= 20/6 ? ','3',' Since i is integer, the decimal part will be ignored. Hence Answer is 3 ');");
		
		db.execSQL("Insert into Options values(2,1,'A>. 3.3333');");
		db.execSQL("Insert into Options values(2,2,'B>. 4');");
		db.execSQL("Insert into Options values(2,3,'C>. 3');");
		
		db.execSQL("Insert into QuesAns values(1,3,'Q>. What is the purpose of the Dynamic Host Configuartion Protocol server ? ','Dynamically Assign IP addresses to PCs',' DHCP is a network protocol used to configure devices that are connected to a network so they can communicate on that network using IP ');");
		
		db.execSQL("Insert into Options values(3,1,'A>. Dynamically assign MAC addresses to PCs');");
		db.execSQL("Insert into Options values(3,2,'B>. Dynamically Assign IP addresses to PCs');");
		db.execSQL("Insert into Options values(3,3,'C>. Increase Security of a network');");
		
db.execSQL("Insert into QuesAns values(1,4,'Q>. Which file is used to prevent web crawlers from accessing parts of a website ? ','robots.txt',' Most search engines check if robot.txt file exists in a websites root directory and respect the exclusion rules defined within ');");
		
		db.execSQL("Insert into Options values(4,1,'A>. robots.txt');");
		db.execSQL("Insert into Options values(4,2,'B>. robots.config');");
		db.execSQL("Insert into Options values(4,3,'C>. hosts.allow');");
		
db.execSQL("Insert into QuesAns values(1,5,'Q>. What is the purpose of this condition : i % 5 == 0 && i % 7 == 0  ','Check if i is a multiple of 5 and 7',' % is modulo operator, which is used for returning the remainder of dividing i by n, here n is 5 and 7 ');");
		
		db.execSQL("Insert into Options values(5,1,'A>. Check if i is a multiple of 5 or 7');");
		db.execSQL("Insert into Options values(5,2,'B>. Check if i is a multiple of 5 and 7');");
		db.execSQL("Insert into Options values(5,3,'C>. Check if i contains value of 5 or 7');");
		
db.execSQL("Insert into QuesAns values(1,6,'Q>. How to Check the available disk space in GNU/LINUX ? ','df -h',' The command df -h, df stands for disk free and -h makes output more human-friendly');");
		
		db.execSQL("Insert into Options values(6,1,'A>. free -m');");
		db.execSQL("Insert into Options values(6,2,'B>. diskusage');");
		db.execSQL("Insert into Options values(6,3,'C>. df -h');");
		
db.execSQL("Insert into QuesAns values(1,7,'Q>. What is the low-level system programming Language ? ','Assembly',' Assembly is a low level language, designed for writing system software as distinct from application software. ');");
		
		db.execSQL("Insert into Options values(7,1,'A>. Assembly');");
		db.execSQL("Insert into Options values(7,2,'B>. C Programming');");
		db.execSQL("Insert into Options values(7,3,'C>. Brainfuck');");
		
db.execSQL("Insert into QuesAns values(1,8,'Q>. Which command will change to your home directory in UNIX ? ','cd',' The cd command without arguments changes to home directory in UNIX and GNU/Linux systems. ');");
		
		db.execSQL("Insert into Options values(8,1,'A>. cd .. ');");
		db.execSQL("Insert into Options values(8,2,'B>. cd ');");
		db.execSQL("Insert into Options values(8,3,'C>. cd - ');");
		
db.execSQL("Insert into QuesAns values(1,9,'Q>. Which file is used as a websites bookmark icon in browsers ? ','favicon.ico',' favicon.ico file is used in past browsers in webserver root as the websites icon in bookmarks. In modern browsers the name and location of file can be customized using a <link> tag. ');");
		
		db.execSQL("Insert into Options values(9,1,'A>. icon.png');");
		db.execSQL("Insert into Options values(9,2,'B>. bookmark.png');");
		db.execSQL("Insert into Options values(9,3,'C>. favicon.ico');");
		
db.execSQL("Insert into QuesAns values(1,10,'Q>. What is the purpose of mounting a disk ? ','Make a filesystem accessible',' Mounting a disk is the process of making a file system accessible. ');");
		
		db.execSQL("Insert into Options values(10,1,'A>. Format a disk to store data ');");
		db.execSQL("Insert into Options values(10,2,'B>. Make a filesystem accessible ');");
		db.execSQL("Insert into Options values(10,3,'C>. Make a disk unusable ');");
		
db.execSQL("Insert into QuesAns values(1,11,'Q>. What is the standard port numbers used by secure web servers (HTTPS) ? ','443',' The standard port number of HTTPS protocol is 443 ');");
		
		db.execSQL("Insert into Options values(11,1,'A>. 443');");
		db.execSQL("Insert into Options values(11,2,'B>. 80');");
		db.execSQL("Insert into Options values(11,3,'C>. 465');");
		
db.execSQL("Insert into QuesAns values(1,12,'Q>. Which of the following is not a correct rule with respect to variables in C language ? ','Underscores are not allowed in defining variable names ',' Underscores are not allowed in defining variable names. ');");
		
		db.execSQL("Insert into Options values(12,1,'A>. Variables are case sensitive ');");
		db.execSQL("Insert into Options values(12,2,'B>. Variable names should not be keywords ');");
		db.execSQL("Insert into Options values(12,3,'C>. Underscores are not allowed in defining variable names ');");
		
db.execSQL("Insert into QuesAns values(1,13,'Q>. When might you see this error : 404 File Not Found ? ','When Visiting a URL that does not exist',' 404 is the HTTP status code, returned by the web server when the requested URL is unknown to the server. ');");
		
		db.execSQL("Insert into Options values(13,1,'A>. When running a command that does not exist');");
		db.execSQL("Insert into Options values(13,2,'B>. When opening an email attachment ');");
		db.execSQL("Insert into Options values(13,3,'C>. When Visiting a URL that does not exist ');");
		
db.execSQL("Insert into QuesAns values(1,14,'Q>. What is the Notation of Quadratic Time Complexity ? ','O(n^2) : Order of n^2',' O(n^2) indicates quadratic time complexity ');");
		
		db.execSQL("Insert into Options values(14,1,'A>. O(n^2) : Order of n^2');");
		db.execSQL("Insert into Options values(14,2,'B>. O(n logn) : Order of n logn ');");
		db.execSQL("Insert into Options values(14,3,'C>. O(1) : Order of 1 ');");
		
db.execSQL("Insert into QuesAns values(1,15,'Q>. How many Primary partitions are allowed on PC hard disk ? ','Four',' The total data storage space of PC HDD can be divided at most four primary partitions, or alternatively three primary partitions and an extended Partion(3P + 1E). ');");
		
		db.execSQL("Insert into Options values(15,1,'A>. Four ');");
		db.execSQL("Insert into Options values(15,2,'B>. Three ');");
		db.execSQL("Insert into Options values(15,3,'C>. Unlimited ');");
		
db.execSQL("Insert into QuesAns values(1,16,'Q>. Which control flow operations might you use to process each line of a file ? ','repeat;until',' You probably want to repeatedly read a line until the end of file is reached. ');");
		
		db.execSQL("Insert into Options values(16,1,'A>. begin;end ');");
		db.execSQL("Insert into Options values(16,2,'B>. if;then;else ');");
		db.execSQL("Insert into Options values(16,3,'C>. repeat;until ');");
		
db.execSQL("Insert into QuesAns values(1,17,'Q>. In Web Programming, which variable stores the input data of a GET request ? ','QUERY_STRING',' The QUERY_STRING is the part of a URL after the Question Mark(?), for eg. URL = google.com?search=Android, here QUERY_STRING : search=Android ');");
		
		db.execSQL("Insert into Options values(17,1,'A>. QUERY_INPUT ');");
		db.execSQL("Insert into Options values(17,2,'B>. QUERY_STRING ');");
		db.execSQL("Insert into Options values(17,3,'C>. INPUT ');");
		
db.execSQL("Insert into QuesAns values(1,18,'Q>. In a Relational database, what is the term for minimizing redundancy and dependency ? ','Normalization',' Normalization usually involves dividing large tables into smaller, less redundant tables and defining relationships between them. ');");
		
		db.execSQL("Insert into Options values(18,1,'A>. Denormalization ');");
		db.execSQL("Insert into Options values(18,2,'B>. Normalization ');");
		db.execSQL("Insert into Options values(18,3,'C>. Optimization ');");
		
db.execSQL("Insert into QuesAns values(1,19,'Q>. How to run script2.sh file only after script1.sh is successful ? ','script1.sh && script2.sh',' The effect of the && operator is that the second command will only run if the first command is successful. ');");
		
		db.execSQL("Insert into Options values(19,1,'A>. script1.sh | script2.sh ');");
		db.execSQL("Insert into Options values(19,2,'B>. script1.sh & script2.sh');");
		db.execSQL("Insert into Options values(19,3,'C>. script1.sh && script2.sh ');");
		
db.execSQL("Insert into QuesAns values(1,20,'Q>. In UNIX, How to put the Current Command in the background ? ','Press Ctrl - z and run the command:bg',' Ctrl - z pauses execution of the current job, and the bg program puts the paused jo in the background. ');");
		
		db.execSQL("Insert into Options values(20,1,'A>. Press Ctrl - z and run the command:bg & ');");
		db.execSQL("Insert into Options values(20,2,'B>. Press Ctrl - z and run the command:bg ');");
		db.execSQL("Insert into Options values(20,3,'C>. Press Ctrl - c and run the command:bg ');");

		
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b5=(Button)findViewById(R.id.button5);
		b6=(Button)findViewById(R.id.button6);
		
		submit=(Button)findViewById(R.id.button4);
		
		submit.setOnClickListener(this);
		submit.setVisibility(View.INVISIBLE);
		
		b5.setVisibility(View.INVISIBLE);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b5.setOnClickListener(this);
		
		
		
		
		answer=(TextView)findViewById(R.id.ans);
		answer.setVisibility(View.INVISIBLE);
		Toast.makeText(QuizTestActivity.this, "All the Best for your Test", Toast.LENGTH_LONG).show();
		
		quesc=db.rawQuery("Select * from QuesAns where mid = 1", null);
		quesc.moveToNext();
		ques=quesc.getString(2);
		answers=quesc.getString(3);
		solution=quesc.getString(4);
		question.setText(ques);
		answer.setText(" " + solution);
		
		optionc=db.rawQuery("Select * from Options where qid = 1", null);
		optionc.moveToNext();
		b1.setText(optionc.getString(2));
		optionc.moveToNext();
		b2.setText(optionc.getString(2));
		optionc.moveToNext();
		b3.setText(optionc.getString(2));
		
		
		b6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				//j=quesc.getColumnCount();
				i++;
				k++;
				if(i<=20)
				{
					questioncursor=db.rawQuery("Select * from QuesAns where mid = 1", null);
					questioncursor.moveToPosition(i-1);
					answers=questioncursor.getString(3);
					solution=questioncursor.getString(4);
					question.setText(questioncursor.getString(2));
					answer.setVisibility(View.INVISIBLE);
					b1.setTextColor(Color.WHITE);
					b2.setTextColor(Color.WHITE);
					b3.setTextColor(Color.WHITE);
					
				}
				if(k<=20)
				{
					optioncursor=db.rawQuery("Select * from Options where qid = " + k + "", null);
					optioncursor.moveToNext();
					b1.setText(optioncursor.getString(2));
					optioncursor.moveToNext();
					b2.setText(optioncursor.getString(2));
					optioncursor.moveToNext();
					b3.setText(optioncursor.getString(2));
					
					b1.setEnabled(true);
					b2.setEnabled(true);
					b3.setEnabled(true);
					b5.setVisibility(View.VISIBLE);
				}
				if(k==20 && i==20)
				{
					b6.setVisibility(View.INVISIBLE);
					submit.setVisibility(View.VISIBLE);
				}
			}
		});
		
		//db.close();
		
		
	}

	@Override
	public void onClick(View v) {

		Button b=(Button)v;
		String text=b.getText().toString();
		if(b==b1 && text.contains(answers))
		{
			Toast.makeText(QuizTestActivity.this, "Correct Answer", Toast.LENGTH_LONG).show();
			b1.setTextColor(Color.GREEN);
			answer.setText(" " + solution);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			answer.setVisibility(View.VISIBLE);
		}
		else if(b==b2 && text.contains(answers))
		{
			Toast.makeText(QuizTestActivity.this, "Correct Answer", Toast.LENGTH_LONG).show();
			b2.setTextColor(Color.GREEN);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			answer.setVisibility(View.VISIBLE);
			answer.setText(" " + solution);
			
		}
		else if(b==b3 && text.contains(answers))
		{
			Toast.makeText(QuizTestActivity.this, "Correct Answer", Toast.LENGTH_LONG).show();
			b3.setTextColor(Color.GREEN);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			answer.setVisibility(View.VISIBLE);
			answer.setText(" " + solution);
		}
		else
		{
			Toast.makeText(QuizTestActivity.this, "Wrong Answer", Toast.LENGTH_LONG).show();
			b.setTextColor(Color.RED);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			answer.setVisibility(View.VISIBLE);
			answer.setText(" " + solution);
		}
		
		if(b==b5 && (text.contains(answers)==false))
		{
			while(quesc.moveToPrevious())
			{
				ques=quesc.getString(2);
				answers=quesc.getString(3);
				solution=quesc.getString(4);
				question.setText(ques);
			}
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			answer.setVisibility(View.VISIBLE);
		}
		if(b==b5 && (text.contains(answers)==true))
		{
			while(quesc.moveToPrevious())
			{
				ques=quesc.getString(2);
				answers=quesc.getString(3);
				solution=quesc.getString(4);
				question.setText(ques);
			}
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			answer.setVisibility(View.VISIBLE);
		}
		if(b==b5)
		{
			while(quesc.moveToPrevious())
			{
				ques=quesc.getString(2);
				answers=quesc.getString(3);
				solution=quesc.getString(4);
				question.setText(ques);
			}
		}
	}
}
