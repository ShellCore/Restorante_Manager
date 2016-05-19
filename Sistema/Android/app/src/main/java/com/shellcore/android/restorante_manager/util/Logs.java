package com.shellcore.android.restorante_manager.util;

import android.util.Log;

public class Logs {
    public static final String TAG_GET_COMPONENTS = "GET_COMPONENTS";

    public static void errorGetComponents(Exception e) {
        Log.e(TAG_GET_COMPONENTS, "No se pudo instanciar los elementos de la vista");
        Log.e(TAG_GET_COMPONENTS, e.getMessage());
    }
}
