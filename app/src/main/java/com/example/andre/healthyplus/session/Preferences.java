package com.example.andre.healthyplus.session;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static Preferences INSTANCE;

    public static Preferences get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Preferences(context);
        }
        return INSTANCE;
    }

    private Preferences(Context context) {
        mPrefs = context.getApplicationContext()
                .getSharedPreferences(PREF_user_ID, Context.MODE_PRIVATE);
    }

    public static final String PREF_user_ID = "PREF_user_ID";
    public static final String PREF_user_NAME = "PREF_user_NAME";
    public static final String PREF_user_EMAIL = "PREF_user_EMAIL";
    public static final String PREF_user_PASS = "PREF_user_PASS";
    public static final String PREF_user_AGE = "PREF_user_AGE";
    public static final String PREF_user_ADDRESS = "PREF_user_ADDRESS";
    public static final String PREF_user_WEIGHT = "PREF_user_WEIGHT";
    public static final String PREF_user_HEIGHT= "PREF_user_HEIGHT";
    public static final String PREF_user_SEX = "PREF_USER_SEX";
    public static final String PREF_user_ALLERGY = "PREF_USER_ALLERGY";
    public static final String PREF_user_IMC = "PREF_user_IMC";
    public static final String PREF_user_STATUS = "PREF_user_STATUS";

    private final SharedPreferences mPrefs;

    /*public boolean isLoggedIn(){

        return !TextUtils.isEmpty(mPrefs.getString(PREF_user_TOKEN, null));
    }*/

    public void saveAuthData(String[] user) {
        if (user != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_user_ID, user[0]);
            editor.putString(PREF_user_NAME, user[1]);
            editor.putString(PREF_user_EMAIL, user[2]);
            editor.putString(PREF_user_PASS, user[3]);
            editor.putString(PREF_user_AGE, user[4]);
            editor.putString(PREF_user_ADDRESS, user[5]);
            editor.putString(PREF_user_WEIGHT, user[6]);
            editor.putString(PREF_user_HEIGHT, user[7]);
            editor.putString(PREF_user_SEX, user[8]);
            editor.putString(PREF_user_ALLERGY, user[9]);
            editor.putString(PREF_user_IMC, user[10]);
            editor.putString(PREF_user_STATUS, user[11]);

            editor.apply();
        }
    }

   /* public void sessionDestroy() {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_user_ID, null);
            editor.putString(PREF_user_EMAIL, null);
            editor.putString(PREF_user_TOKEN, null);
            editor.apply();
    }*/

    public String getValue(String s){
        return mPrefs.getString(s, null);
    }
}
