package com.softdesign.school_softdesign;

import android.annotation.TargetApi;
import android.os.Build;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.softdesign.school_softdesign.utils.Lg;

/**
 *  Главный класс приложения.
 *  Инициализирует основные компоненты приложения.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButtonBlue;
    Button mButtonGreen;
    Button mButtonRed;
    Toolbar mActionBarToolbar;
    EditText mEditText;
    CheckBox mCheckBox;
    String mString;
    TextView mTextView;
    public static final String TOOLBAR_COLOR_KEY = "toolbar_color";
    public static final String STATUSBAR_COLOR_KEY = "statusbar_color";

    /**
     *  Метод инициализации необходимых полей для работы с интерфейсом приложения.
     *
     *  @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lg.e(this.getLocalClassName(), "onCreate");
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mButtonBlue = (Button) findViewById(R.id.button_blue);
        mButtonGreen = (Button) findViewById(R.id.button_green);
        mButtonRed = (Button) findViewById(R.id.button_red);
        mEditText = (EditText) findViewById(R.id.edit_text_one);
        mEditText = (EditText) findViewById(R.id.edit_text_two);
        mCheckBox = (CheckBox) findViewById(R.id.checkbox_one);
        mTextView = (TextView) findViewById(R.id.text_view);
        mButtonBlue.setOnClickListener(this);
        mButtonGreen.setOnClickListener(this);
        mButtonRed.setOnClickListener(this);
        mCheckBox.setOnClickListener(this);
        setToolbar();
    }

    /**
     * Метод обработки нажатий.
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button_blue:
                setColor(R.color.colorPrimary, R.color.colorPrimaryDark);
                break;
            case R.id.button_green:
                setColor(R.color.green, R.color.green_dark);
                break;
            case R.id.button_red:
                setColor(R.color.red, R.color.red_dark);
                break;
            case R.id.checkbox_one:
                mString = mEditText.getText().toString();
                mTextView.setText(mString);
                break;
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
     * С помощью аннотаций добавляем возможность использовать функции 21 версии андройда.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    /**
     * Метод сохранения текста, цвета тулбара и статусбара при смене ориентации экрана.
     *
     * @param outState
     */
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "onSaveInstanceState");
        outState.putString("text", mString);
        outState.putInt(STATUSBAR_COLOR_KEY, getWindow().getStatusBarColor());
        outState.putInt(TOOLBAR_COLOR_KEY, ((ColorDrawable) mActionBarToolbar.getBackground()).getColor());
    }

    /**
     * Метод восстановления данных текста, цвета тулбара и статусбара.
     * Передает настройки текста и цветов в элементы активити.
     *
     * @param savedInstanceState
     */
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "onRestoreInstanceState");
        mString = savedInstanceState.getString("text");
        mTextView.setText(mString);
        setColor(savedInstanceState.getInt(TOOLBAR_COLOR_KEY), savedInstanceState.getInt(STATUSBAR_COLOR_KEY));
    }

    /**
     * С помощью аннотаций добавляем возможность использовать функции 21 версии андройда.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    /**
     * Метод устанавливает цвет тулбара и статусбара.
     *
     * @param toolbar_color
     * @param statusbar_color
     */
    private void setColor(int toolbar_color, int statusbar_color) {
        mActionBarToolbar.setBackgroundColor(this.getResources().getColor(toolbar_color));
        getWindow().setStatusBarColor(this.getResources().getColor(statusbar_color));
    }
}