package com.gdut.dkmfromcg.transitionlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdut.dkmfromcg.transitionlearn.fragment.ShareFragment;
import com.gdut.dkmfromcg.transitionlearn.fragment.TextFragment;

public class ShareElementsToFrgActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button btn;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_elements_to_frg);


        /*imageView=findViewById(R.id.iv);
        textView=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        container=findViewById(R.id.container);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextFragment fragment=new TextFragment();
                fragment.setSharedElementEnterTransition(new ChangeBounds());
                fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,fragment)
                        .addToBackStack(null)
                        .addSharedElement(imageView,"iv_share_to_frg")
                        .addSharedElement(textView,"tv_share_to_frg")
                        .commit();
            }
        });*/


        ShareFragment fragment=new ShareFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.rootView,fragment).commit();
    }
}
