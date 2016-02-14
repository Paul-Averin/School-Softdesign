package com.softdesign.school_softdesign.ui.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school_softdesign.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContactsHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.user_name) public TextView mFullName;
    @Bind(R.id.user_avatar) public ImageView mAvatar;

    public ContactsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}