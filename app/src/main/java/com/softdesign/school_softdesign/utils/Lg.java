package com.softdesign.school_softdesign.utils;

import android.util.Log;
import com.softdesign.school_softdesign.BuildConfig;

/**
 *  Класс для вывода сообщений в лог.
 */
public class Lg {

    private static final String PREFIX = "HTC ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;
    public static final String FAULT = "Logger is off! Please, include the logger in a config file (BuildConfig).";

    /**
     *  Метод возвращающий значение из конфига BuildConfig.
     *  Константа может принимать значение
     *  true - доггер включен
     *  false - логгер выключен
     *
     *  @return boolean
     */
    private static boolean shouldLog() {
        //return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return BuildConfig.DEBUG;
    }

    /**
     *  Метод реализующий вывод в лог кастомных сообщений.
     *
     *  @param level
     *  @param tag
     *  @param text
     */
    private static void Logging(int level, String tag, String text) {
        if (shouldLog()) {
            if (text.length() > LOGCAT_BUFFER_SIZE) {
                String stringLog = text;
                while (stringLog.length() > LOGCAT_BUFFER_SIZE) {
                    String substringLog = stringLog.substring(0, LOGCAT_BUFFER_SIZE);
                    stringLog = stringLog.substring(LOGCAT_BUFFER_SIZE);
                    Log.println(level, PREFIX + tag, substringLog);
                }
                Log.println(level, PREFIX + tag, stringLog);
            } else {
                Log.println(level, PREFIX + tag, text);
            }
        } else {
            Log.i(PREFIX + tag, FAULT);
        }
    }

    /**
     *  Вывод лога на уровне verbose.
     *
     *  @param tag
     *  @param text
     */
    public static void v(String tag, String text) {

        Logging(Log.VERBOSE, tag, text);
    }

    /**
     *  Вывод лога на уровне debug.
     *
     *  @param tag
     *  @param text
     */
    public static void d(String tag, String text) {

        Logging(Log.DEBUG, tag, text);
    }

    /**
     *  Вывод лога на уровне info.
     *
     *  @param tag
     *  @param text
     */
    public static void i(String tag, String text){

        Logging(Log.INFO, tag, text);
    }

    /**
     *  Вывод лога на уровне error.
     *
     *  @param tag
     *  @param text
     */
    public static void e(String tag, String text) {

        Logging(Log.ERROR, tag, text);
    }

    /**
     *  Вывод лога на уровне warn.
     *
     *  @param tag
     *  @param text
     */
    public static void w(String tag, String text) {
        Logging(Log.WARN, tag, text);
    }

    /**
     *  Вывод лога на уровне assert.
     *
     *  @param tag
     *  @param text
     */
    public static void a(String tag, String text) {

        Logging(Log.ASSERT, tag, text);
    }
}
