package com.learninglanguage.app.Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Func {

    public static boolean isValidemail(String mail) {

        String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern p = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(mail);
        return m.matches();
    }

}
