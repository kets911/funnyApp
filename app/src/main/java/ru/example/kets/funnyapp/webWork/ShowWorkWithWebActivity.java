package ru.example.kets.funnyapp.webWork;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import ru.example.kets.funnyapp.R;

/**
 * Created by kets on 30.12.2017.
 */

public class ShowWorkWithWebActivity extends AppCompatActivity implements ShowWorkWithWebActivityInt {
    WebView webView;
    Button showWeb;
    Button showOkHttp;
    TextView okHttpText;
    WebWorkPresenterInt presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp);
        presenter = (WebWorkPresenter) getLastCustomNonConfigurationInstance();
        if(presenter == null) presenter = new WebWorkPresenter(this);
        else presenter.showMessages();

        webView  = (WebView) findViewById(R.id.webView);
        showWeb = (Button) findViewById(R.id.showWebViewCall);
        showOkHttp = (Button) findViewById(R.id.showOkHttpCall);
        okHttpText = (TextView) findViewById(R.id.okHttpText);
        showWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.setVisibility(View.VISIBLE);
                webView.loadUrl("https://annimon.com/forum/index.php?act=new");
            }
        });
        showOkHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            presenter.showMessages();
            }
        });
    }


    @Override
    public void setMessages(String messages) {
        webView.setVisibility(View.GONE);
        showWeb.setVisibility(View.GONE);
        showOkHttp.setVisibility(View.GONE);
        okHttpText.setText(messages);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }
}
