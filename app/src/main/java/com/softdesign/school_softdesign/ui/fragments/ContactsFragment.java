package com.softdesign.school_softdesign.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school_softdesign.R;
import com.softdesign.school_softdesign.data.storage.models.UsersModels;
import com.softdesign.school_softdesign.MainActivity;
import com.softdesign.school_softdesign.ui.adapters.ContactsAdapter;

import java.util.ArrayList;

public class ContactsFragment extends Fragment {

    ArrayList<UsersModels> mArrayUsers = new ArrayList<UsersModels>();
    RecyclerView mListView;
    RecyclerView.LayoutManager mLayoutManager;
    ContactsAdapter mContactsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contacts, null);
        ((MainActivity) getActivity()).setSelect(R.id.drawer_contacts);
        ((MainActivity) getActivity()).collapsingApplicationBar(false, getResources().getString(R.string.drawer_contacts));
        addData();
        mListView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mListView.setLayoutManager(mLayoutManager);
        mContactsAdapter = new ContactsAdapter(mArrayUsers);
        mListView.setAdapter(mContactsAdapter);
        return v;
    }

    public void addData() {
        mArrayUsers.add(new UsersModels("Павел", "Аверин", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
        mArrayUsers.add(new UsersModels("Иван", "Иванов", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
        mArrayUsers.add(new UsersModels("Иван", "Петров", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
        mArrayUsers.add(new UsersModels("Иван", "Сидоров", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
        mArrayUsers.add(new UsersModels("Петр", "Иванов", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
        mArrayUsers.add(new UsersModels("Петр", "Петров", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
        mArrayUsers.add(new UsersModels("Петр", "Сидоров", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
        mArrayUsers.add(new UsersModels("Сидор", "Иванов", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
        mArrayUsers.add(new UsersModels("Сидор", "Петров", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
        mArrayUsers.add(new UsersModels("Сидор", "Сидоров", getResources().getDrawable(R.drawable.ic_account_box_24dp)));
    }
}