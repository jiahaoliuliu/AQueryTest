package com.jiahaoliuliu.aquerytest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.Transformer;
import org.json.JSONObject;
import com.google.gson.Gson;

public class SampleAsyncWithCustomType extends Activity {


    private AQuery aq;
    private Context context;
    private TextView textView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_async_with_custom_type);
        aq = new AQuery(this);
        context = this;
        textView = (TextView)findViewById(R.id.textView);
        async_transformer();
    }

    private static class Profile{
        public String id;
        public String name;
        public String category;
    }

    private static class GsonTransformer implements Transformer {

        public <T> T transform(String url, Class<T> type, String encoding, byte[] data, AjaxStatus status) {
            Gson g = new Gson();
            return g.fromJson(new String(data), type);
        }
    }

    private void async_transformer(){

        String url = "https://graph.facebook.com/205050232863343";
        GsonTransformer t = new GsonTransformer();

        aq.transformer(t).ajax(url, Profile.class, new AjaxCallback<Profile>() {
            public void callback(String url, Profile profile, AjaxStatus status) {
                Gson gson = new Gson();
                textView.setText("GSON Object:" + gson.toJson(profile).toString());
            }
        });

    }
}
