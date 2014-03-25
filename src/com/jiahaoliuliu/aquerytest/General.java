package com.jiahaoliuliu.aquerytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class General extends Activity {

    private Button asyncButton;
    private Button asyncGsonButton;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general);

        asyncButton = (Button)findViewById(R.id.asyncButton);
        asyncButton.setOnClickListener(onClickListener);

        asyncGsonButton = (Button)findViewById(R.id.asyncGsonButton);
        asyncGsonButton.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.asyncButton:
                    Intent startAsyncActivityIntent = new Intent(General.this, SampleAsync.class);
                    startActivity(startAsyncActivityIntent);
                    break;
                case R.id.asyncGsonButton:
                    Intent startAsyncGsonActivityIntent = new Intent(General.this, SampleAsyncWithCustomType.class);
                    startActivity(startAsyncGsonActivityIntent);
                    break;
            }
        }
    };
}
