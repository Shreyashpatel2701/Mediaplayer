package com.example.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonsignin;
    EditText editTextphone;
    TextView textView_enternumber;

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
          init();
          buttonsignin.setOnClickListener(new sign_in());
          super.onCreate(savedInstanceState);
    }
    void init(){
        buttonsignin = findViewById(R.id.sign_in);
        editTextphone = findViewById(R.id.PHONE_NUMBER);
        textView_enternumber = findViewById(R.id.ENTER_NUMBER);


    }

    public class sign_in implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String phonemuber = editTextphone.getText().toString();

            Intent intent=new Intent(MainActivity.this,users_choice.class);


            if ( !phonemuber.isEmpty()  && phonemuber.length() == 10   ) {
                startActivity(intent);
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("PLEASE ENTER VALID PHONE NUMBER");
                builder.setPositiveButton("ENTER DETAILS", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }


            }
    }



}


