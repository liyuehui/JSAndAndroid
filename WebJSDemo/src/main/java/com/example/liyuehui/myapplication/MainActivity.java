package com.example.liyuehui.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.JavascriptInterface;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        webView.setWebChromeClient(new MyChromeClient());
        webView.loadUrl("file:///android_asset/index.html");

        //供JS调用的android代码
        webView.addJavascriptInterface(new DemoJavascriptInterface(), "fromAndroidObj");

        //android调用js代码
        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:fromHtmlJs()");
            }
        });
    }


    class DemoJavascriptInterface {

        @JavascriptInterface
        public void fromAndroid(){
            Log.e(TAG,TAG+" TTTTT ");
        }
    }


    class MyChromeClient extends WebChromeClient{

        //弹出Alert，弹不出来,要用log看
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Log.e(TAG,TAG+" message:"+message);
            result.confirm();
            return true;
        }
    }
}
