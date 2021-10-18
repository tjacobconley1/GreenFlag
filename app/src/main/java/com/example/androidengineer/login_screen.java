package com.example.androidengineer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login_screen extends AppCompatActivity {

    EditText email, password, passwordcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // points to the xml
        setContentView(R.layout.activity_login_screen);





        // this onclicklistener will run the methods to check
        // whether the fields are null
        // the passwords match
        findViewById(R.id.createbutton).setOnClickListener(view -> {
            checkFields();
        });


        // this one is for the back button
        findViewById(R.id.backicon).setOnClickListener(view -> {
            backbutton();
        });




    }

    // method when invoked navigates to the login_screen activity
    public void backbutton() {
        Intent backbutton = new Intent(this, MainActivity.class);
        backbutton.setClass(this, MainActivity.class);
        startActivity(backbutton);

    }



    // method to check if the fields are null
    public void checkFields() {

        ImageView IVemailx = findViewById(R.id.emailx);
        ImageView IVemailcross = findViewById(R.id.emailcross);
        ImageView IVemailtick = findViewById(R.id.emailtick);

        ImageView IVpasswordx = findViewById(R.id.passwordx);
        ImageView IVpasswordcheckx = findViewById(R.id.passwordcheckx);
        ImageView IVpasswordcross = findViewById(R.id.passwordcross);
        ImageView IVpasswordtick = findViewById(R.id.passwordtick);
        ImageView IVpasswordchecktick =findViewById(R.id.passwordchecktick);

        TextView TVpassworderror = findViewById(R.id.passworderror);
        TextView TVcredreq = findViewById(R.id.credreq);
        TextView TVemailerror = findViewById(R.id.emailerror);

        // pulls the value typed into the email field into
        // the email variable then converts it to a String value
        // then assigns that to a string variable
        email = (EditText) findViewById(R.id.email);
        String emailstr = email.getText().toString();
        // same thing for the password
        password = (EditText) findViewById(R.id.password);
        String passwordstr = password.getText().toString();
        //same thing for the passwordcheck
        passwordcheck = (EditText) findViewById(R.id.passwordcheck);
        String passwordcheckstr = passwordcheck.getText().toString();

        // booleans to hold check values
        boolean hasUpper = !passwordstr.equals(passwordstr.toUpperCase());
        boolean hasLower = !passwordstr.equals(passwordstr.toLowerCase());
        boolean hasNumber = !passwordstr.matches("0123456789");

        // check to see if email meets criteria
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(emailstr);

        if(mat.matches()){
            IVemailx.setVisibility(View.INVISIBLE);
            IVemailcross.setVisibility(View.INVISIBLE);
            TVemailerror.setVisibility(View.INVISIBLE);

            IVemailtick.setVisibility(View.VISIBLE);
        }
        else{
            IVemailx.setVisibility(View.VISIBLE);
            IVemailcross.setVisibility(View.VISIBLE);
            TVemailerror.setVisibility(View.VISIBLE);

            IVemailtick.setVisibility(View.INVISIBLE);
        }

        // if the password field and the passwordcheck field are not equal
        // and whether or not the password mets the criteria
        if (passwordstr.compareTo(passwordcheckstr) != 0 || passwordstr.length() <= 8 ) {
            // return false
            IVpasswordx.setVisibility(View.VISIBLE);
            IVpasswordcheckx.setVisibility(View.VISIBLE);
            IVpasswordcross.setVisibility(View.VISIBLE);
            TVpassworderror.setVisibility(View.VISIBLE);
            TVcredreq.setVisibility(View.VISIBLE);

            IVpasswordtick.setVisibility(View.INVISIBLE);
            IVpasswordchecktick.setVisibility(View.INVISIBLE);

            return;
        }

        else{
            // if all criteria are met set return value equal to true
            IVpasswordx.setVisibility(View.INVISIBLE);
            IVpasswordcheckx.setVisibility(View.INVISIBLE);
            IVpasswordcross.setVisibility(View.INVISIBLE);
            TVpassworderror.setVisibility(View.INVISIBLE);
            TVcredreq.setVisibility(View.INVISIBLE);

            IVpasswordtick.setVisibility(View.VISIBLE);
            IVpasswordchecktick.setVisibility(View.VISIBLE);

            return;
        }
    }
}




