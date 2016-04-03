package com.example.liyuehui.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = MainActivity2.class.getSimpleName();

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

        webView.loadUrl("file:///android_asset/form4.html");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

//                Log.e(TAG, TAG + str);
                webView.loadUrl("javascript:showData()");
//                webView.loadUrl("javascript:fromHtmlJs()");

            }
        });

        webView.addJavascriptInterface(new DemoJavascriptInterface(), "fromAndroidObj");

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

    class DemoJavascriptInterface {

        @JavascriptInterface
        public String fromAndroid(){
            JSONObject object = new JSONObject();
            try {
                object.put("age","12");
                object.put("name","Tom");
            } catch (JSONException e) {
                e.printStackTrace();
            }
           return object.toString();
        }
    }

}
