package com.example.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MusicplayList extends AppCompatActivity {
     private RecyclerView mSongnames;
     private MusicplaylistADPATER musicplaylistADPATER;
     ImageView PlaylistimageView;
    TextView  PlaylisttextView;
    Button ButtonPlaylist;
    ArrayList<song> msonglist;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplaylistview);
        init();
        mSongnames.setAdapter(musicplaylistADPATER);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL,false
        );
        mSongnames.setLayoutManager(linearLayoutManager);


    }


    void init(){
     PlaylistimageView =findViewById(R.id.musicplaylist);
     PlaylisttextView = findViewById(R.id.displaylist);
      ButtonPlaylist = findViewById(R.id.PLAYLISTSONGS);
      mSongnames = findViewById( R.id.playlistrecyclerview);
        msonglist = new ArrayList<song>();


        msonglist.add(new song("sooraj",R.raw.song));
        msonglist.add(new song(" i be there for you",R.raw.ibethere));

        music Music = (music) getIntent().getSerializableExtra("MUSIC");
        PlaylisttextView.setText(Music.getName());
        PlaylistimageView.setImageResource(Music.getImageId());
        ButtonPlaylist.setOnClickListener(new Platbuttonlistener());



        musicplaylistADPATER = new MusicplaylistADPATER(msonglist);




    }

    private class Platbuttonlistener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(),songplay.class);
            startActivity(intent);


        }
    }



}
