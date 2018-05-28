package com.gdut.dkmfromcg.transitionlearn.scenes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

import com.gdut.dkmfromcg.transitionlearn.R;

/**
 * Created by dkmFromCG on 2017/12/2.
 * function:
 */


public class FadeOrSlideActivity extends BaseScenesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_scene);
        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickChange();
            }
        });
        initScene(R.id.rootView,R.layout.fadeorslide_scene1,R.layout.fadeorslide_scene2);
    }

    @Override
    Transition getTransition() {
        //return new Fade();
        return new Slide();
    }
}
