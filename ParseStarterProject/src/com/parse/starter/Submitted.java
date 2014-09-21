package com.parse.starter;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.parse.ParseAnalytics;

public class Submitted extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit);
		
		ParseQuery<ParseObject> person = ParseQuery.getQuery("M_K");
		
		ParseObject dude = null;
		try {
			dude = person.getFirst();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String newAddress = (String) dude.get("Address");

		TextView submit = (TextView) findViewById(R.id.datAddress);
		submit.setText(newAddress);
		
		
	}

}
