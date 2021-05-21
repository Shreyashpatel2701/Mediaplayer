package com.example.mediaplayer;

import java.io.Serializable;

public class song implements Serializable {

   public static final String KEY_MUSIC = "SONGS_PLAY";

   private String mName;
   private int mRawsongfile;

   public song(String name, int Rawsongfile) {
       this.mName = name;
       this.mRawsongfile = Rawsongfile;
   }
   public String getName() {
       return mName;
   }

   public void setName(String name) {
       this.mName = name;
   }

   public int getRawId() {
       return mRawsongfile;
   }

   public void setRawId(int Rawsongfile) {
       this.mRawsongfile = Rawsongfile;
   }


}
