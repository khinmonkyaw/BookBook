package com.sparrowmon.bookbook.utilities;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.sparrowmon.bookbook.network.responses.BookList;

import java.io.IOException;
import java.io.InputStream;

public class JsonReader {


    public static BookList readJson(Context context)
    {


        String json = null;
        try {
            InputStream is = context.getAssets().open("booklist.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            BookList data = new Gson().fromJson(json, BookList.class);
            Log.e("json",json);
            return data;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
