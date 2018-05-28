package com.gdut.dkmfromcg.transitionlearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareElementsToActActivity extends AppCompatActivity {

    private static final String TAG = "ShareElementsToActActiv";
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_elements_to_act);
        imageView=findViewById(R.id.iv);
        textView=findViewById(R.id.tv);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("key_bundle");
        Log.d(TAG, ": "+bundle);
        if (bundle!=null){
            //imageView.setImageBitmap((Bitmap) bundle.getParcelable("key_share_iv"));
            textView.setText(bundle.getCharSequence("key_share_tv"));
        }


    }
}
