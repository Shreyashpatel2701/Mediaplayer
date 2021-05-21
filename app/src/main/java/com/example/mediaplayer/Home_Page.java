package com.example.mediaplayer;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import static android.graphics.Color.WHITE;
import static com.google.android.material.snackbar.Snackbar.*;

public class Home_Page extends AppCompatActivity {
    private  boolean ENGLISH_SONGS = false;

    public void setENGLISH_SONGS(boolean ENGLISH_SONGS) {
        this.ENGLISH_SONGS = ENGLISH_SONGS;
    }

    public void setMARATHI_SONGS(boolean MARATHI_SONGS) {
        this.MARATHI_SONGS = MARATHI_SONGS;
    }
    public boolean isHINDHI_SONGS() {
        return HINDHI_SONGS;
    }

    public void setHINDHI_SONGS(boolean HINDHI_SONGS) {
        this.HINDHI_SONGS = HINDHI_SONGS;
    }

    public void setGUJARATHI_SONGS(boolean GUJARATHI_SONGS) {
        this.GUJARATHI_SONGS = GUJARATHI_SONGS;
    }
    public void setWORKOUT_SONGS(boolean WORKOUT_SONGS) {
        this.WORKOUT_SONGS = WORKOUT_SONGS;
    }

    public void setPARTY_SONGS(boolean PARTY_SONGS) {
        this.PARTY_SONGS = PARTY_SONGS;
    }

    public void setHIPHOP_SONGS(boolean HIPHOP_SONGS) {
        this.HIPHOP_SONGS = HIPHOP_SONGS;
    }

    public void setROMMANCE_SONGS(boolean ROMMANCE_SONGS) {
        this.ROMMANCE_SONGS = ROMMANCE_SONGS;
    }

     boolean  MARATHI_SONGS = false;
      boolean HINDHI_SONGS = false;
     boolean  GUJARATHI_SONGS = false;
     boolean  WORKOUT_SONGS = false;
     boolean  PARTY_SONGS = false;
     boolean HIPHOP_SONGS = false;
     boolean ROMMANCE_SONGS = false;




    private RecyclerView mMusicView;
    private RecyclerView mMadeforyou;
    private RecyclerView mFreshmusic;
    private RecyclerView mArtistmusic;
    private RecyclerView mPodcasts;
    private RecyclerView mDevotionalmusic;
    private ArrayList<music> mMusicype;
    private ArrayList<music> mDevotionalmusiclist;
    private ArrayList<music> mPodcastmusiclist;
    private ArrayList<music> mArtistlsit;
    private ArrayList<music> mFreshmusiclist;
    private ArrayList<music> mMadeforyoulist;



    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.home_layout);
        super.onCreate(savedInstanceState);


        mMusicView = findViewById(R.id.musictypeid);
        mMusicype = new ArrayList<music>();
        mDevotionalmusic = findViewById(R.id.Devotionalmusic);
        mFreshmusic = findViewById(R.id.FRESH_MUSIC);
        mMadeforyou = findViewById(R.id.Madeforyou);
        mArtistmusic = findViewById(R.id.ARTIST);
        mPodcasts =findViewById(R.id.PODCAST);
        mDevotionalmusiclist = new ArrayList<music>();
        mArtistlsit = new ArrayList<music>();
        mPodcastmusiclist = new ArrayList<music>();
        mMadeforyoulist = new ArrayList<music>();
        mFreshmusiclist = new ArrayList<music>();


        init();

        MusicviewAdapter musicviewAdapter = new MusicviewAdapter(mMusicype);
        MusicDevotionalAdapter musicDevotionalAdapter = new MusicDevotionalAdapter(mDevotionalmusiclist);
        MusicPodcastAdapter musicPodcastAdapter = new MusicPodcastAdapter( mPodcastmusiclist);
        MusicArtistAdapter musicArtistAdapter = new MusicArtistAdapter(mArtistlsit);
        MusicFreshmusicAdapter musicFreshmusicAdapter = new MusicFreshmusicAdapter(mFreshmusiclist);
        MusicMadeforyouAdapter musicMadeforyouAdapter = new MusicMadeforyouAdapter(mMadeforyoulist);






        mMusicView.setAdapter(musicviewAdapter);
        mDevotionalmusic.setAdapter(musicDevotionalAdapter);
        mArtistmusic.setAdapter(musicArtistAdapter);
        mMadeforyou.setAdapter(musicMadeforyouAdapter);
        mFreshmusic.setAdapter(musicFreshmusicAdapter);
        mPodcasts.setAdapter(musicPodcastAdapter);

        //lyout manger for top picks for you
          LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                );
          //Linearlayout manger for devotional music
           LinearLayoutManager linearLayoutManagerdevotional =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                );
        //Linearlayout manger for devotional music
        LinearLayoutManager linearLayoutManagermadeforyou =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                );
        //Linearlayout manger for devotional music
        LinearLayoutManager linearLayoutManagerfreshmusic =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                );
        //Linearlayout manger for devotional music
        LinearLayoutManager linearLayoutManagerartist =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                );
        //Linearlayout manger for devotional music
        LinearLayoutManager linearLayoutManagerpodcast =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                );


        mMusicView.setLayoutManager(linearLayoutManager);
        mDevotionalmusic.setLayoutManager(linearLayoutManagerdevotional);
        mArtistmusic.setLayoutManager(linearLayoutManagerartist);
        mMadeforyou.setLayoutManager(linearLayoutManagermadeforyou);
        mFreshmusic.setLayoutManager(linearLayoutManagerfreshmusic);
        mPodcasts.setLayoutManager(linearLayoutManagerpodcast);

    }

     void init() {
        // Adding to TOP PICKS FOR YOU
        mMusicype.add(new music(" BOLLYWOOD TOP 50", R.drawable.download));
        mMusicype.add(new music("MOST PLAYED IN INDIA", R.drawable.iamge));
        mMusicype.add(new music("MOST PLAYED IN WORLD", R.drawable.music));
        mMusicype.add(new music(" HOOLYWOOD TOP 50", R.drawable.iamge));
        mMusicype.add(new music("STUDY MUSIC", R.drawable.music));
        mMusicype.add(new music("MEDITATION", R.drawable.download));
        mMusicype.add(new music("ELECTRONIC", R.drawable.music));


        //ADDING TO MADE FOR YOU MUSIC
         mMadeforyoulist.add(new music("DAILY MIX", R.drawable.download));
         mMadeforyoulist.add(new music("WEEKLY MIX", R.drawable.download));
         mMadeforyoulist.add(new music("MONDAY MIX", R.drawable.download));
         mMadeforyoulist.add(new music("FRIDAY MIX", R.drawable.download));
         mMadeforyoulist.add(new music("PARTY MIX", R.drawable.download));
         mMadeforyoulist.add(new music("DAILY MIX 2", R.drawable.download));
         mMadeforyoulist.add(new music("LIKES", R.drawable.download));
         mMadeforyoulist.add(new music("DJ MIX", R.drawable.download));
         mMadeforyoulist.add(new music("ELECTRONIC", R.drawable.download));





         //ADDING TO FRESH MUSIC
         mFreshmusiclist.add(new music("NEW HINDI", R.drawable.download));
         mFreshmusiclist.add(new music("NEW ENGLISH", R.drawable.download));
         mFreshmusiclist.add(new music("NEW MARATHI", R.drawable.download));
         mFreshmusiclist.add(new music("NEW GUJARATHI", R.drawable.download));
         mFreshmusiclist.add(new music("NEW HIPHOP", R.drawable.download));
         mFreshmusiclist.add(new music("NEW ROMANCE", R.drawable.download));
         mFreshmusiclist.add(new music("NEW PARTY", R.drawable.download));
         mFreshmusiclist.add(new music("NEW WORKOUT", R.drawable.download));
         mFreshmusiclist.add(new music("NEW TAMIL", R.drawable.download));
         mFreshmusiclist.add(new music("NEW TELEGU", R.drawable.download));




         //ADDING TO Artist  MUSIC
         mArtistlsit.add(new music("KYGO", R.drawable.download));
         mArtistlsit.add(new music("ALAN WALKER", R.drawable.download));
         mArtistlsit.add(new music("DJ SNAKE", R.drawable.download));
         mArtistlsit.add(new music("ZIHU", R.drawable.download));
         mArtistlsit.add(new music("YELLOW CLAWS", R.drawable.download));
         mArtistlsit.add(new music("Doja CAT", R.drawable.download));
         mArtistlsit.add(new music("Amorf", R.drawable.download));
         mArtistlsit.add(new music("Rihanna", R.drawable.download));
         mArtistlsit.add(new music("BTS", R.drawable.download));
         mArtistlsit.add(new music("VIZE", R.drawable.download));
         mArtistlsit.add(new music("R3HAB", R.drawable.download));




         //ADDING TO PODCAST MUSIC
         mPodcastmusiclist.add(new music("THINK FAST", R.drawable.download));
         mPodcastmusiclist.add(new music("SOURCES", R.drawable.download));
         mPodcastmusiclist.add(new music("CODING", R.drawable.download));
         mPodcastmusiclist.add(new music("FINANCIAL", R.drawable.download));
         mPodcastmusiclist.add(new music("STARTUP", R.drawable.download));
         mPodcastmusiclist.add(new music("MOTIVATION", R.drawable.download));
         mPodcastmusiclist.add(new music("COOKING", R.drawable.download));
         mPodcastmusiclist.add(new music("3 THINGS", R.drawable.download));
         mPodcastmusiclist.add(new music("INTELLIGENCE", R.drawable.download));
         mPodcastmusiclist.add(new music("CYRUS SAYS", R.drawable.download));
         mPodcastmusiclist.add(new music("CRIME", R.drawable.download));



         //ADDING TO DEVOTIONAL MUSIC
         mDevotionalmusiclist.add(new music("BOLLWOOD BHAJHAS", R.drawable.download));
         mDevotionalmusiclist.add(new music("JAI SHREE GANESH", R.drawable.iamge));
         mDevotionalmusiclist.add(new music("Divine Bhajans", R.drawable.music));
         mDevotionalmusiclist.add(new music("Guruvani", R.drawable.iamge));
         mDevotionalmusiclist.add(new music("Lakshmi puja", R.drawable.download));
         mDevotionalmusiclist.add(new music("visnu bhajan", R.drawable.music));
         mDevotionalmusiclist.add(new music("JAI MATA JI", R.drawable.iamge));
         mDevotionalmusiclist.add(new music("BHAKTI RASS", R.drawable.download));
         mDevotionalmusiclist.add(new music("GANESH VANDNA", R.drawable.music));
    }




}
