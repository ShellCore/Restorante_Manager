package com.shellcore.android.restorante_manager.util;

import android.support.design.widget.TextInputLayout;

public class FormValue {
    public static String getText(TextInputLayout til) {
        if (til.getEditText() != null) {
            String value = til.getEditText().getText().toString();
            if (!value.isEmpty()) {
                return value;
            }
        }
        return "";
    }
}
