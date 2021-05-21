package com.example.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class users_choice extends AppCompatActivity {


    private  CheckBox mENGLISH_SONGS;
    private  CheckBox  mMARATHI_SONGS;
    private CheckBox  mHINDHI_SONGS;
    private CheckBox mGUJARATHI_SONGS;
    private CheckBox mWORKOUT_SONGS;
    private CheckBox mPARTY_SONGS;
    private CheckBox mHIPHOP_SONGS;
    private CheckBox mROMMANCE_SONGS;


           TextView skip_text;
            TextView next_text;
            Home_Page home_page = new Home_Page();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre);
        init();
        mENGLISH_SONGS.setOnClickListener(new Englishchechboxlistner());




        skip_text.setOnClickListener(new skipbuttonlistener());
        next_text.setOnClickListener(new nextbuttonlistener());



    }

            void init(){
               skip_text=findViewById(R.id.skip_button);
               next_text=findViewById(R.id.NEXT);
               mENGLISH_SONGS =findViewById(R.id.ENGLISH_SONG);
               mGUJARATHI_SONGS = findViewById(R.id.GUJARATHI_SONGS);
               mHINDHI_SONGS = findViewById(R.id.HINDI_SONGS);
               mMARATHI_SONGS = findViewById(R.id.MARATHI_SONGS);
               mHIPHOP_SONGS  = findViewById(R.id.HIPHOP_SONGS);
               mPARTY_SONGS = findViewById(R.id.PARTY_SONGS);
               mROMMANCE_SONGS = findViewById(R.id.ROMACE_SONGS);
               mWORKOUT_SONGS =findViewById(R.id.WORKOUT);

            }

          private  class nextbuttonlistener implements View.OnClickListener{
              @Override
              public void onClick(View v) {
                  Intent intent=new Intent(users_choice.this,Home_Page.class);
                  startActivity(intent);
              }
          }
         private  class skipbuttonlistener implements View.OnClickListener{
             @Override
             public void onClick(View v) {
             Intent intent=new Intent(users_choice.this,Home_Page.class);
               startActivity(intent);
             }

            }

            private class Englishchechboxlistner implements View.OnClickListener{
                @Override
                public void onClick(View v) {
                 if (mENGLISH_SONGS.isChecked()){
                     home_page.setENGLISH_SONGS(true);
                     mt("english songs");
                 }
                 mENGLISH_SONGS.isActivated();
                }
            }



     public  void  mt(String text){
         Toast.makeText(users_choice.this,text,Toast.LENGTH_SHORT).show();
    }





}
