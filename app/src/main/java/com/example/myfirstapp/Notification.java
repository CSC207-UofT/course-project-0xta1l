package com.example.myfirstapp;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.snackbar.Snackbar;

public class Notification {
    /**
     * //        This class is able to give a user a notification by creating a SnackBar
     * //
     */
    public static void displaySnackBar(ViewGroup layout, String message) {
        Snackbar snack = Snackbar.make(layout,
                message,
                Snackbar.LENGTH_SHORT);
        FrameLayout snackView = (FrameLayout) snack.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackView.getChildAt(0).getLayoutParams();
        params.gravity = Gravity.BOTTOM;
        params.setMargins(
                10,
                10,
                10,
                0);
        snackView.setLayoutParams(params);
        snack.show();
    }

    public static void displaySnackBar(ViewGroup layout, String message, String position) {
        Snackbar snack = Snackbar.make(layout,
                message,
                Snackbar.LENGTH_SHORT);
        FrameLayout snackView = (FrameLayout) snack.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackView.getChildAt(0).getLayoutParams();
        switch (position) {
            case "top":
                params.gravity = Gravity.TOP;
                break;
            default:
                params.gravity = Gravity.BOTTOM;
                break;
        }
        params.setMargins(
                10,
                10,
                10,
                0);
        snackView.setLayoutParams(params);
        snack.show();
    }
}
