package com.example.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class internal_Test {

    public static void main(String[] args) {
        String basename = "test";
        // CN
        i18n(basename, Locale.CHINA);
        // US
        i18n(basename, Locale.US);
        // Auto
        i18n(basename, Locale.getDefault());
    }

    static void i18n(String baseName, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, locale);
        String date = resourceBundle.getString("date");
        String salary = resourceBundle.getString("salary");
        System.out.println(date + " " + salary);
    }
}
