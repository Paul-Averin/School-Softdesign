package com.softdesign.school_softdesign;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.softdesign.school_softdesign.R;
import com.softdesign.school_softdesign.ui.fragments.ContactsFragment;
import com.softdesign.school_softdesign.ui.fragments.ProfileFragment;
import com.softdesign.school_softdesign.ui.fragments.SettingsFragment;
import com.softdesign.school_softdesign.ui.fragments.TasksFragment;
import com.softdesign.school_softdesign.ui.fragments.TeamFragment;
import com.softdesign.school_softdesign.utils.Lg;

/**
 * Главный класс приложения.
 * Инициализирует основные компоненты приложения.
 */
public class MainActivity extends AppCompatActivity {

    Toolbar mActionBarToolbar;
    NavigationView mNavigationView;
    DrawerLayout mDrawerLayout;
    Fragment mFragment;
    AppBarLayout mApplictionBar;
    CollapsingToolbarLayout mCollapsingToolbar;
    CoordinatorLayout mCordinator;

    /**
     * Метод инициализации необходимых полей и функций для работы с интерфейсом приложения.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lg.e(this.getLocalClassName(), "onCreate");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mApplictionBar = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCordinator = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        setToolbar();
        setupNavigation();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_conteiner, new ProfileFragment()).commit();
        }
    }

    /**
     * Метод старта активити и компонентов приложения.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "onStart");
    }

    /**
     * Метод возвращения в работу приложения.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "onResume");
    }

    /**
     * Метод временной остановки приложения.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "onPause");
    }

    /**
     * Метод приостановки работы приложения.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "onStop");
    }

    /**
     * Метод удаления приложения из памяти.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "onDestroy");
    }

    /**
     * Метод перезагрузки приложения.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "onRestart");
    }

    /**
     * Метод создания логики пунктов меню.
     */
    private void setupNavigation() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        break;
                    case R.id.drawer_settings:
                        mFragment = new SettingsFragment();
                        break;
                }
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_conteiner, mFragment).addToBackStack(null).commit();
                }
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    /**
     * Метод вызываемый в фрагментах при нажатии на пункт меню.
     *
     * @param id
     */
    public void setSelect(int id) {
        mNavigationView.setCheckedItem(id);
    }

    /**
     * Метод инициализации тулбара.
     */
    private void setToolbar() {
        setSupportActionBar(mActionBarToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.menu_config_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Метод активации параметров загружаемого фрагмента.
     *
     * @param item
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Метод вызывающийся при нажатии на кнопку "назад".
     */

    public void onBackPressed() {
            super.onBackPressed();
            mFragment = getSupportFragmentManager().findFragmentById(R.id.main_frame_conteiner);
    }

    public void collapsingApplicationBar(boolean collapse, String title) {

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mApplictionBar.getLayoutParams();
        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        if (behavior != null) {
            behavior.onNestedFling(mCordinator, mApplictionBar, null, 0, 1000, collapse);
        }
        mApplictionBar.setExpanded(collapse);
        mCollapsingToolbar.setTitle(title);
    }
    
    /**
     * Метод сохранения при смене ориентации экрана.
     *
     * @param outState
     */
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "onSaveInstanceState");
    }

    /**
     * Метод восстановления данных.
     * Передает настройки текста и цветов в элементы активити.
     *
     * @param savedInstanceState
     */
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "onRestoreInstanceState");
    }
}