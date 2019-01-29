package mishkat.mdrd.com.mishkat.UtilsTools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

import mishkat.mdrd.com.mishkat.R;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class UtilsTool {

    // Preference files
    // http://5.189.136.85:810/      -> Old domain
    // http://api.mytinytales.in/    -> New domain
    private static ProgressDialog progressDialog;
    static String emailPattern = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static void generateHashKey_Local(Context context) {
        // Add code to print out the key hash
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("MY KEY HASH:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }


    public static AlertDialog custoAlert(final Context ctx, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setMessage(message);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                //((AppCompatActivity)ctx).finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.setCancelable(false);
        return dialog;
    }


    public static String getKeyHash_GooglePlay(final Context context) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                Log.w("error", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
        return null;
    }


    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e) {
            Log.e("keyboard_error", e.toString());
        }
    }


    public static String getMobileBrand() {
        return Build.BRAND;
    }

    public static String getMobileModel() {
        return Build.MODEL;
    }

    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }


    public static String getWifiMacAddress(Context mContext) {
        WifiManager wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        String macAddress = wInfo.getMacAddress();
        return macAddress;
    }

    public static String getDeviceMacAddress() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            Log.e("mac_error", ex.toString());
        }
        return "02:00:00:00:00:00";
    }


    public static boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() <= 0;
    }


    public static void showProgressDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setMessage("Please wait...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public static void hideProgressDialog() {
        progressDialog.dismiss();

    }

    public static boolean removePreference(Context context, String preference, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(preference, Context.MODE_PRIVATE);
        return sharedPref.edit().remove(key).commit();
    }


    public static void offlineMessage(Context context) {
        //Toast.makeText(context, context.getResources().getString(R.string.device_offline_message), Toast.LENGTH_LONG).show();
    }


    public static Toast customMessage(Context ctx, String message) {
        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return toast;

    }

    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }

    public static boolean isInternetOn(Context context) {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {
            return true;
        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {
            return false;
        }
        return false;
    }

    public static boolean checkMobileValidation(EditText mobile_no) {
        if (mobile_no.getText().toString().trim().length() < 10 || mobile_no.getText().toString().trim().length() > 13) {
            mobile_no.requestFocus();
            mobile_no.setError("Minimum 10 digits required !");
            return false;
        }
        return true;
    }


    public static boolean checkEmailValidation(EditText email_id) {
        if (!email_id.getText().toString().trim().matches(emailPattern)) {
            email_id.requestFocus();
            email_id.setError("Invalid Email-ID!");
            return false;
        }
        return true;
    }

    public static void ChackNull(EditText text) {
        String mNmae = text.getText().toString().trim();
        if (mNmae == null || mNmae.equalsIgnoreCase("null") || mNmae.length() == 0) {
            text.setError("Cannot be empty !");
        }
    }


}
