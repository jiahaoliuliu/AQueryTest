package com.jiahaoliuliu.aquerytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import org.json.JSONObject;

public class SampleAsync extends Activity {

    private TextView textView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_async);

        textView = (TextView)findViewById(R.id.textView);

        String url = "http://www.google.com/uds/GnewsSearch?q=Obama&v=1.0";
        final AQuery aq = new AQuery(this);

        aq.ajax(url, JSONObject.class, new AjaxCallback<JSONObject>() {

                    @Override
                    public void callback(String url, JSONObject json, AjaxStatus status) {
                        if (json != null) {
                            // Successful ajax call, show status code and json content
                            textView.setText(status.getCode() + ":" + json.toString());
                        } else {
                            // ajax error, show error code
                            textView.setText("Error:" + status.getCode());
                        }
                    }
            }
        );
    }
}
