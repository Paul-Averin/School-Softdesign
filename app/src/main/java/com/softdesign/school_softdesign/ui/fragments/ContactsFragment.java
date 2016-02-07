package com.softdesign.school_softdesign.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school_softdesign.R;
import com.softdesign.school_softdesign.MainActivity;

public class ContactsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contacts, null);
        getActivity().setTitle(getResources().getString(R.string.drawer_contacts));
        Activity activity = getActivity();
        ((MainActivity) activity).setSelect(R.id.drawer_contacts);
        return v;
    }
}