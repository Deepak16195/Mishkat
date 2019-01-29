package mishkat.mdrd.com.mishkat.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

public class SharePrefarence {

    private static SharePrefarence mInstance;
    private static Context mctx;
    private static final String SHARE_PRE_NAME = "Meshkat_Data";
    private static final String USER_NAME = "UserName";
    private static final String EMAIL = "Emails";
    private static final String USERID = "UserID";
    private static final String PHONE = "PHONE";
    private static final String PASSWORD = "password";
    private static final String LOGOUTVALUE = "log";
    private static final String Image = "Image";
    private static final String PRESENCE = "Presence";
    public static final String ENGLISH = "en";
    public static final String ARBIC = "ar";
    public static final String imagelink = "http://thedigitaldhol.com/healthyhunger/";
    public static final String Productslist = "http://thedigitaldhol.com/healthyhunger/uploads/product/";
    public static final String RecipesList = "http://thedigitaldhol.com/healthyhunger/uploads/recipes/";

    public SharePrefarence(Context context) {
        mctx = context;
    }

    public static SharePrefarence getmInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharePrefarence(context);
        }
        return mInstance;
    }

    public boolean SaveDataLocal(int mid, String m_name, String m_email, String mphone) {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(USERID, mid);
        editor.putString(USER_NAME, m_name.toString().trim());
        editor.putString(EMAIL, m_email.toString().trim());
        editor.putString(PHONE, mphone.toString().trim());
        editor.apply();
        return true;
    }


    public boolean setMobile(String pass) {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PHONE, pass);
        editor.apply();
        return true;
    }


    public String getMobile() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PHONE, null);
    }

    public String GetPresence() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PRESENCE, null);
    }

    public boolean SeTPresence(String prese) {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PRESENCE, prese);
        editor.apply();
        return true;
    }


    public boolean setPassword(String pass) {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PASSWORD, pass);
        editor.apply();
        return true;
    }

    public String getPassword() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PASSWORD, null);
    }

    public boolean logout() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().commit();
        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(USER_NAME, null) != null) {
            return true;
        }
        return false;
    }

    public String getLogout() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(LOGOUTVALUE, null);
    }

    public int getUserId() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(USERID, 0);
    }

    public String getUserNAme() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_NAME, null);
    }

    public String getEmail() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMAIL, null);
    }


    public String getImagepath() {
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Image, null);
    }


}
