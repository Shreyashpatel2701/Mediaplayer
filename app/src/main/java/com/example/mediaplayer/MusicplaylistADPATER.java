package com.example.mediaplayer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicplaylistADPATER extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<song> mSongslist;
    public interface OnMusicplaylistener{
        public void SetOnmusicplaylistener(song Msong,int position);
    }

    OnMusicplaylistener onMusicplaylistener;

    public void SetOnmusicplaylistener(OnMusicplaylistener moMusicplaylsitener){
        this.onMusicplaylistener =moMusicplaylsitener;
    }


    MusicplaylistADPATER(ArrayList<song> songslist){
        mSongslist = songslist;
    }

    @Override
    public int getItemCount() {
        if (mSongslist.size() == 0){
            return  0;
        }
        return mSongslist.size();

    }

    public class Songplayviewholder extends RecyclerView.ViewHolder{

        public TextView songname;
        int songplay;



        public Songplayviewholder(@NonNull  View itemView) {
            super(itemView);
            songname = itemView.findViewById(R.id.song_names);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    song Song = mSongslist.get(getAbsoluteAdapterPosition());
                    if (onMusicplaylistener !=null){
                        onMusicplaylistener.SetOnmusicplaylistener(Song,getAbsoluteAdapterPosition());
                    }
                    Intent intent =new Intent(v.getContext(),songplay.class);
                    intent.putExtra("SONGS_PLAY",Song);
                    v.getContext().startActivity(intent);

                }
            });


        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.songname, null);
        return new Songplayviewholder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        Songplayviewholder songplayviewholder = (Songplayviewholder) holder;

        song song = mSongslist.get(position);
        int songplay;
        songplayviewholder.songname.setText(song.getName());
        songplayviewholder.songplay =song.getRawId();
    }

}
