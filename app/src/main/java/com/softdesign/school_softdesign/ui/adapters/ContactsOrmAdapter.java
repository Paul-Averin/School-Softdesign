package com.softdesign.school_softdesign.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.softdesign.school_softdesign.R;
import com.softdesign.school_softdesign.data.storage.models.OrmUser;

public class ContactsOrmAdapter extends BaseAdapter {

    private final Context mContext;
    private List<OrmUser> mUsers;

    public ContactsOrmAdapter(Context context, List<OrmUser> users) {
        this.mContext = context;
        this.mUsers = users;
    }

    public void resetData(List<OrmUser> users) {
        this.mUsers = users;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrmUser user = mUsers.get(position);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_contact_orm, parent, false);
        TextView name = (TextView) rowView.findViewById(R.id.contact_name);
        TextView command = (TextView) rowView.findViewById(R.id.contact_command);
        name.setText(user.firstName + " " + user.lastName);
        command.setText(user.team.title);
        return rowView;
    }
}