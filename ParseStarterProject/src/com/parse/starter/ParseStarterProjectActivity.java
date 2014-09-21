package com.parse.starter;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseAnalytics;

public class ParseStarterProjectActivity extends Activity {
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final Intent moveNext = new Intent(this, Submitted.class);
		final EditText lastName = (EditText) findViewById(R.id.lastName);
		final EditText firstName = (EditText) findViewById(R.id.firstName);
		final EditText address = (EditText) findViewById(R.id.Address);
		final EditText courses = (EditText) findViewById(R.id.Courses);
		final Button submit = (Button) findViewById(R.id.submit);

		submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (!lastName.getText().toString().equals("Last Name")
						&& !lastName.getText().toString().equals("")
						&& !firstName.getText().toString().equals("First Name")
						&& !firstName.getText().toString().equals("")
						&& !address.getText().toString()
								.equals("Campus Address")
						&& !address.getText().toString().equals("")
						&& !courses.getText().toString()
								.equals("Courses: separated by commas")
						&& !courses.getText().toString()
								.equals("Courses: separated by commas")) {
					// save to database and move on to next activity.

					ParseObject testObject = new ParseObject(lastName.getText()
							.toString() + "_" + firstName.getText().toString());
					testObject.put("LastName", lastName.getText().toString());
					testObject.put("FirstName", firstName.getText().toString());
					testObject.put("Address", address.getText().toString());
					testObject.put("Courses", courses.getText().toString());
					testObject.saveInBackground();
					ParseUser.enableAutomaticUser();
					ParseACL defaultACL = new ParseACL();

					// If you would like all objects to be private by default,
					// remove this line.
					defaultACL.setPublicReadAccess(true);
					ParseACL.setDefaultACL(defaultACL, true);

					submit.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {
							// Perform action on click
							startActivity(moveNext);
						}
					});
				}
			}
		});

		ParseAnalytics.trackAppOpened(getIntent());
	}
}