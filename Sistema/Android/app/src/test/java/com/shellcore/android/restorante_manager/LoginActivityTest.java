package com.shellcore.android.restorante_manager;


import android.support.design.widget.TextInputLayout;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityTestCase;

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public static final String USER = "root";
    public static final String PASS = "toor";
    private LoginActivity activity;

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        activity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        activity = null;
    }

    public void testSetUserTest() throws Exception {
        final TextInputLayout tilUser = (TextInputLayout) activity.findViewById(R.id.til_login_user);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (tilUser.getEditText() != null) {
                    tilUser.getEditText().setText(USER);
                }
            }
        });

        getInstrumentation().waitForIdleSync();
        if (tilUser.getEditText() != null) {
            assertEquals("Texto incorrecto en usuario", USER, tilUser.getEditText().getText().toString());
        }
    }

    public void testSetUserTestWithAnnotation() throws Exception {
        TextInputLayout tilUser = (TextInputLayout) activity.findViewById(R.id.til_login_user);

        if (tilUser.getEditText() != null) {
            tilUser.getEditText().setText(USER);
            assertEquals("Texto incorrecto en usuario, en anotaciones", USER, tilUser.getEditText().getText().toString());
        }
    }

    public void testSetPassTest() throws Exception {
        final TextInputLayout tilPass = (TextInputLayout) activity.findViewById(R.id.til_login_password);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (tilPass.getEditText() != null) {
                    tilPass.getEditText().setText(PASS);
                }
            }
        });

        getInstrumentation().waitForIdleSync();
        if (tilPass.getEditText() != null) {
            assertEquals("Texto incorrecto en contraseña", PASS, tilPass.getEditText().getText().toString());
        }
    }

    public void testSetPassTestWithAnnotation() throws Exception {
        TextInputLayout tilPass = (TextInputLayout) activity.findViewById(R.id.til_login_password);

        if (tilPass.getEditText() != null) {
            tilPass.getEditText().setText(PASS);
            assertEquals("Texto incorrecto en contraseña, en anotaciones", PASS, tilPass.getEditText().getText().toString());
        }
    }

    public void testValidData() throws Exception {
        TextInputLayout tilUser = (TextInputLayout) activity.findViewById(R.id.til_login_user);
        TextInputLayout tilPass = (TextInputLayout) activity.findViewById(R.id.til_login_password);

        if (tilUser.getEditText() != null && tilPass.getEditText() != null) {
            tilUser.getEditText().setText(USER);
            tilPass.getEditText().setText(PASS);

            assertEquals("Error en la validación de datos", true, activity.validData());
        }
    }
}
