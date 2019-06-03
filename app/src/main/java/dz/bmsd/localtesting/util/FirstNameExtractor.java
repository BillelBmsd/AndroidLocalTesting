package dz.bmsd.localtesting.util;

import android.util.Log;

public class FirstNameExtractor {
    private static final String TAG = "FirstNameExtractor";

    public static String extractFirstName(String fullName){

        if (fullName == null || fullName.isEmpty()) {
            return "";
        }

        String[] split = fullName.split(" ");
        for (String word : split) {
            if (!word.isEmpty()) {
                return word;
            }
        }

        return null;
    }
}
