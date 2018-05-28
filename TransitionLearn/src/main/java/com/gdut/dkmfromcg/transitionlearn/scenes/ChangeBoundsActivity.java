package com.gdut.dkmfromcg.transitionlearn.scenes;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

import com.gdut.dkmfromcg.transitionlearn.R;

/**
 * Path生成动画
 */
public class ChangeBoundsActivity extends BaseScenesActivity {

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

    @Override
    Transition getTransition() {
        return new ChangeBounds();
    }
}
