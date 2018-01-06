package ru.example.kets.funnyapp.webWork;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kets on 29.12.2017.
 */

class ConverterJsons {

    public static Messages createFromJSON(String json) {
        Gson gson = new GsonBuilder().create();
        Messages messages = new Messages(Arrays.asList(gson.fromJson(json, Messages[].class)));
        return messages;
    }
    public String asJSON(List<Messages> messages){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(messages);
    }
}
