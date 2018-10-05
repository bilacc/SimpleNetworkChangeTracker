package com.bilac.josip.simplenetworkchangetracker.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Helper class used to determine availability of internet connection.
 */
public final class NetworkHelper {

    private static NetworkHelper networkHelper;
    //singleton network helper

    private NetworkHelper() {
    }

    public static synchronized NetworkHelper getInstance() {
        if (networkHelper == null) {
            networkHelper = new NetworkHelper();
        }
        return networkHelper;
    }

    public boolean isNetworkAvailable(final Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = null;

        if (connectivityManager != null) {
            activeNetwork = connectivityManager.getActiveNetworkInfo();
        }

        // return isConnected true/false
        return activeNetwork != null && activeNetwork.isConnected(); // isConnectedOrConnecting
    }

}
