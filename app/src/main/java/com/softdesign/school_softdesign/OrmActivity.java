package com.softdesign.school_softdesign;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.DialogInterface;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import com.softdesign.school_softdesign.R;
import com.softdesign.school_softdesign.data.storage.models.OrmTeam;
import com.softdesign.school_softdesign.data.storage.models.OrmUser;
import com.softdesign.school_softdesign.ui.adapters.ContactsOrmAdapter;
import com.softdesign.school_softdesign.ui.fragments.ContactsOrmFragment;
import com.softdesign.school_softdesign.ui.loaders.UserLoader;
import com.softdesign.school_softdesign.utils.Lg;

public class OrmActivity extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<OrmUser>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orm);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.orm_coordinator_layout, new ContactsOrmFragment()).commit();
        }
    }

    @Override
    public void onClick(View v) {
        LayoutInflater inflater = getLayoutInflater();
        switch (v.getId()) {
            case R.id.button_add_team:
                View dialogView = inflater.inflate(R.layout.dialog_add_team, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Добавление команды").setView(dialogView).setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText teamName = (EditText) ((AlertDialog) dialog).findViewById(R.id.team_add_name);
                        OrmTeam.add(teamName.getText().toString());
                        dialog.cancel();
                    }
                }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
            case R.id.button_add_user:

                dialogView = inflater.inflate(R.layout.dialog_add_user, null);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, OrmTeam.getAllNames());
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                Spinner spinner = (Spinner) dialogView.findViewById(R.id.teamSpinner);
                spinner.setAdapter(adapter);
                spinner.setPrompt("Новый пользователь");

                builder = new AlertDialog.Builder(this);
                builder.setTitle("Добавление пользователя")
                        .setView(dialogView)
                        .setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText firstName = (EditText) ((AlertDialog) dialog).findViewById(R.id.contact_add_first_name);
                                EditText lastName = (EditText) ((AlertDialog) dialog).findViewById(R.id.contact_add_last_name);
                                Spinner spinner = (Spinner) ((AlertDialog) dialog).findViewById(R.id.teamSpinner);
                                OrmTeam team = OrmTeam.findByAttribute("title", spinner.getSelectedItem().toString());
                                OrmUser.add(firstName.getText().toString(), lastName.getText().toString(), team);

                                getLoaderManager().initLoader(0, null, OrmActivity.this).forceLoad();

                                dialog.cancel();
                            }
                        }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                alert = builder.create();
                alert.show();

                break;
        }
    }

    @Override
    public Loader<List<OrmUser>> onCreateLoader(int id, Bundle args) {
        return new UserLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<OrmUser>> loader, List<OrmUser> data) {
        ListView listView = (ListView) findViewById(R.id.listView);
        ContactsOrmAdapter listViewAdapter = (ContactsOrmAdapter) listView.getAdapter();
        listViewAdapter.resetData(OrmUser.getAll());
    }

    @Override
    public void onLoaderReset(Loader<List<OrmUser>> loader) {
        ListView listView = (ListView) findViewById(R.id.listView);
        ContactsOrmAdapter listViewAdapter = (ContactsOrmAdapter) listView.getAdapter();
        listViewAdapter.resetData(new ArrayList<OrmUser>());
    }
}
