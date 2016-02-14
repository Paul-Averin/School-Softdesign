package com.softdesign.school_softdesign.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.softdesign.school_softdesign.R;
import com.softdesign.school_softdesign.data.storage.models.UsersModels;
import com.softdesign.school_softdesign.ui.view.ContactsHolder;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsHolder> {

    ArrayList<UsersModels> mArrayUsers;

    public ContactsAdapter(ArrayList<UsersModels> users) {
        this.mArrayUsers = users;
    }

    @Override
    public ContactsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View converView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacts, parent, false);
        return new ContactsHolder(converView);
    }

    @Override
    public void onBindViewHolder(ContactsHolder holder, int position) {
        UsersModels users = mArrayUsers.get(position);
        holder.mFullName.setText(users.getFirstName() + " " + users.getLastName());
        holder.mAvatar.setImageDrawable(users.getImage());

    }

    @Override
    public int getItemCount() {
        return mArrayUsers.size();
    }
}