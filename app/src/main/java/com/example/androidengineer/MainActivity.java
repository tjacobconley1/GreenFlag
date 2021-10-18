package com.example.androidengineer;

import androidx.appcompat.app.AppCompatActivity;




import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // points to the xml associated with this java class
        setContentView(R.layout.activity_main);
        // find view by id points to the specific element inside that xml
        // the on click listener waits until a button click and then
        // executes whatever is inside of that function
        findViewById(R.id.imageButton).setOnClickListener(view -> {
            navigatetologin();
        });
    }



    // method when invoked navigates to the login_screen activity
    public void navigatetologin(){
        Intent navigate = new Intent(this, login_screen.class);
        navigate.setClass(this, login_screen.class);
        startActivity(navigate);

    }

}