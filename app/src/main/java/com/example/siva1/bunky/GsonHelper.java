package com.example.siva1.bunky;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class GsonHelper {
    public static Gson mGson = new Gson();

    static Type type = new TypeToken<Map<String, String>>() {
    }.getType();

    public static Object getGson(String json, Class<?> class1) {

        return mGson.fromJson(json, class1);
    }
}
