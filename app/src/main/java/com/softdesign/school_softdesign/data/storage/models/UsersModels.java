package com.softdesign.school_softdesign.data.storage.models;

import android.graphics.drawable.Drawable;

public class UsersModels {
    private String mFirstName;
    private String mLastName;
    private int mRating;
    private Drawable mImage;
    private String mPersonalPageLink;
    private String mGitHubLink;

    public UsersModels(String mFirstName, String mLastName, Drawable mImage) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mImage = mImage;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getRating() {
        return mRating;
    }

    public Drawable getImage() {
        return mImage;
    }

    public String getPersonalPageLink() {
        return mPersonalPageLink;
    }

    public String getGitHubLink() {
        return mGitHubLink;
    }
}