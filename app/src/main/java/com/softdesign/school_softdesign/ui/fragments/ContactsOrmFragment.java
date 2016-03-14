package com.softdesign.school_softdesign.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import com.softdesign.school_softdesign.R;
import com.softdesign.school_softdesign.data.storage.models.OrmUser;
import com.softdesign.school_softdesign.OrmActivity;
import com.softdesign.school_softdesign.ui.adapters.ContactsOrmAdapter;

public class ContactsOrmFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_contacts_orm, null, false);

        OrmActivity activity = (OrmActivity) getActivity();
        ListView listView = (ListView) convertView.findViewById(R.id.listView);

        Button addTeam = (Button) convertView.findViewById(R.id.button_add_team);
        Button addUser = (Button) convertView.findViewById(R.id.button_add_user);

        addTeam.setOnClickListener(activity);
        addUser.setOnClickListener(activity);

        List<OrmUser> users = OrmUser.getAll();
        ContactsOrmAdapter adapter = new ContactsOrmAdapter(activity, users);
        listView.setAdapter(adapter);

        return convertView;
    }
}
