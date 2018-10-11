package com.gdut.dkmfromcg.transitionlearn.scenes;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.transition.ChangeClipBounds;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.gdut.dkmfromcg.transitionlearn.R;

public class ChangeClipBoundsActivity extends BaseScenesActivity {

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
        ViewGroup sceneRoot=findViewById(R.id.rootView);


        View view1= LayoutInflater.from(this).inflate(R.layout.changeclipbounds_scene,null);
        View view2= LayoutInflater.from(this).inflate(R.layout.changeclipbounds_scene,null);

        ImageView iv1=view1.findViewById(R.id.imageView);
        ImageView iv2=view2.findViewById(R.id.imageView);

        iv1.setClipBounds(new Rect(0,0,100,100));
        iv2.setClipBounds(new Rect(100,100,200,200));

        scene1=new Scene(sceneRoot,view1);
        scene2=new Scene(sceneRoot,view2);
        TransitionManager.go(scene1);
    }

    @Override
    Transition getTransition() {
        return new ChangeClipBounds();
    }
}
