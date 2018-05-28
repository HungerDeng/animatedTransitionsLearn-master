package com.gdut.dkmfromcg.transitionlearn.scenes;

import android.os.Bundle;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

import com.gdut.dkmfromcg.transitionlearn.R;

public class ChangeTransformActivity extends BaseScenesActivity {

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
        initScene(R.id.rootView,R.layout.changetransform_scene1,R.layout.changetransform_scene2);
    }

    @Override
    Transition getTransition() {
        return new ChangeTransform();
    }
}
