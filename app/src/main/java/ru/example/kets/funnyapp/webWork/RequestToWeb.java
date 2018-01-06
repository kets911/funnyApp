package ru.example.kets.funnyapp.webWork;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kets on 03.01.2018.
 */

public class RequestToWeb {

    private Messages messages;
    public  RequestToWeb() throws IOException {
        run();
    }

    private void setMessages(Messages messages) {
        this.messages = messages;
    }

    public Messages getMessages() throws IOException {
//        run();
        return messages;
    }

    private void run() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://annimon.com/json/forum/last_posts")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 setMessages(ConverterJsons.createFromJSON(response.body().string()));
            }
        });
    }
}
