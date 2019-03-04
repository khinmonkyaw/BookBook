package com.sparrowmon.bookbook.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import me.myatminsoe.mdetect.MDetect;
import me.myatminsoe.mdetect.Rabbit;

import static android.content.Context.MODE_PRIVATE;

public class MyanmarSarUtil {

    private static final String MYPREFERENCE = "PREFERENCE";
    private static final String FONT_NAME="fontname";

    public  static void detectFont(Context context)
    {
        if (MDetect.INSTANCE.isUnicode()){
            //user is using Unicode
            SharedPreferences.Editor editor = context.getSharedPreferences(MYPREFERENCE, MODE_PRIVATE).edit();
            editor.putInt(FONT_NAME, 0);
            editor.apply();
        } else {
            //user is using Zawgyi or showing squares
            SharedPreferences.Editor editor = context.getSharedPreferences(MYPREFERENCE, MODE_PRIVATE).edit();
            editor.putInt(FONT_NAME, 1);
            editor.apply();
        }
    }


    public static String convertToUserFont(String rawText,Context context){

        SharedPreferences preferences = context.getSharedPreferences(MYPREFERENCE,MODE_PRIVATE);
       int fontType = preferences.getInt(FONT_NAME,-1);

       if (fontType==0)
       {
           return rawText;
       }
       else if(fontType==1)
        {
           return Rabbit.uni2zg(rawText);
        }

        return rawText;

    }


}
