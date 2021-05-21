package com.example.mediaplayer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicArtistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<music> mListMusic;

     MusicArtistAdapter(ArrayList ListMusic ){
         mListMusic = ListMusic;
     }
    public interface OnMusicViewlistener{
        public void SetOnmusicViewlistener(music Mmusic,int position);
    }

    OnMusicViewlistener MonMusicViewlistener;

    public void SetOnmusicviewlistener(OnMusicViewlistener monMusicViewlistener){
        this.MonMusicViewlistener =monMusicViewlistener;
    }



    @NonNull
    @Override
    public int getItemCount() {
     if (mListMusic.size() == 0){
         return  0;
     }
     return mListMusic.size();

     }

     class MusicviewHolder  extends RecyclerView.ViewHolder{

         TextView mMusictype;
         ImageView mimageView;



         public MusicviewHolder(@NonNull  View itemView) {
             super(itemView);


          mimageView =itemView.findViewById(R.id.musicviewimage);
          mMusictype = itemView.findViewById(R.id.musictypetextview);
             itemView .setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     music Music = mListMusic.get(getAbsoluteAdapterPosition());
                     if (MonMusicViewlistener != null){
                         MonMusicViewlistener.SetOnmusicViewlistener(Music,getAbsoluteAdapterPosition());
                     }
                     Intent intent =new Intent(v.getContext(),MusicplayList.class);
                     intent.putExtra("MUSIC",Music);
                     v.getContext().startActivity(intent);



                 }
             });


         }
     }



     public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.music_view, null);
         return new MusicviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {



        MusicviewHolder MusicViewHolder = (MusicviewHolder) holder;

        music music = mListMusic.get(position);

        MusicViewHolder.mMusictype.setText(music.getName());
        MusicViewHolder.mimageView.setImageResource(music.getImageId());


     }

}
