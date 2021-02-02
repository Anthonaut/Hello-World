package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // define variables outside of methods
    private Button button_hi;
    private int number = 0;
    private TextView textView_count; //Creating a bunch of variables for each view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //part of the android lifecycle

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //links the activity to the xml layout called activity_main

        //look up the button by its id
        button_hi = findViewById(R.id.button_hello); // Finds the particular view with the given id and assign it to the variable
        textView_count = findViewById(R.id.textView_count);

        // create logs to keep track of the errors
        Log.d("MainActivity", "I was not able to see the toast when clicking the button");
        // tag -> location where this is found
        // msg -> log information, what happened

        // add an event listener to listen for the click

        button_hi.setOnClickListener(new View.OnClickListener() { // 1st method - Implementation in Java
            @Override
            public void onClick(View v) {
                // handle what happens after I click
                //sayHello(v);
                launchNextActivity(v);

            }
        });


        // when click happens, do something
    }


    public void sayHello(View view) { //We put the method here as a way to modularize the code
        // Create a toast with a message saying hello
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT); // short --> 2 seconds?
        toast.show();
    }

    public void countUp(View view) { //2nd method - just use the "onClick" attribute in the XML - assign the method as the onClick
        // increment the value and display in the text view
        //Set the text of the text view to the number
        number++;
        // when you see an object, you want to check to make sure its not null
        if(textView_count != null) {
            textView_count.setText(Integer.toString(number)); //setText takes a string
        }

    }

    public void countDown(View view) { // Implemented using the XML onClick
        number = Integer.parseInt(textView_count.getText().toString()); // To count down, we must count down from the current number in textView
        if (number != 0) {
            if (textView_count != null) {
                number--;
                textView_count.setText(Integer.toString(number));
            }

        }
    }

    public void launchNextActivity(View viwe) {
        // create an intent and you need to specify from and to
        Intent intent = new Intent(this, SecondActivity.class); // Intents only connect from one specific activity to another specified activity
        startActivity(intent);
    }
}