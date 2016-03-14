package com.softdesign.school_softdesign.ui.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import com.softdesign.school_softdesign.data.storage.models.OrmUser;

public class UserLoader extends AsyncTaskLoader<List<OrmUser>> {

    public UserLoader(Context context) {
        super(context);
    }

    @Override
    public List<OrmUser> loadInBackground() {
        return OrmUser.getAll();
    }
}
