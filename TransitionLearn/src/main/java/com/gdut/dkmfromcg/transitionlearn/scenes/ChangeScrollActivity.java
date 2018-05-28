package com.gdut.dkmfromcg.transitionlearn.scenes;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeScroll;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

import com.gdut.dkmfromcg.transitionlearn.R;


/**
 * 捕捉到Scroll模式的变化,为实现
 */
public class ChangeScrollActivity extends BaseScenesActivity {

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
        initScene(R.id.rootView,R.layout.changebounds_scene1,R.layout.changebounds_scene2);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    Transition getTransition() {
        return new ChangeScroll();
    }
}
