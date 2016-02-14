package com.softdesign.school_softdesign.ui.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school_softdesign.R;


public class ContactsHolder extends RecyclerView.ViewHolder {

    public TextView mFullName;
    public ImageView mAvatar;

    public ContactsHolder(View itemView) {
        super(itemView);
        mFullName = (TextView) itemView.findViewById(R.id.user_name);
        mAvatar = (ImageView) itemView.findViewById(R.id.user_avatar);
    }
}