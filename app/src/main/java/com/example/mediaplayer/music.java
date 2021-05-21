package com.example.mediaplayer;

import java.io.Serializable;

public class music implements Serializable {
    private String mName;
    private int mImageId;


    public music(String name, int imageId) {
        this.mName = name;
        this.mImageId = imageId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        this.mImageId = imageId;
    }
}
