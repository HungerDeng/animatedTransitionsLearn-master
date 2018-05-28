package com.gdut.dkmfromcg.transitionlearn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeTransform;
import android.view.View;
import android.widget.Button;

import com.gdut.dkmfromcg.transitionlearn.R;
import com.gdut.dkmfromcg.transitionlearn.scenes.ChangeBoundsActivity;
import com.gdut.dkmfromcg.transitionlearn.scenes.ChangeClipBoundsActivity;
import com.gdut.dkmfromcg.transitionlearn.scenes.ChangeImageTransformActivity;
import com.gdut.dkmfromcg.transitionlearn.scenes.ChangeScrollActivity;
import com.gdut.dkmfromcg.transitionlearn.scenes.ChangeTransformActivity;
import com.gdut.dkmfromcg.transitionlearn.scenes.FadeOrSlideActivity;

public class SceneActivity extends AppCompatActivity {

    Button changeBounds,changeClipBounds,changeImageTransform,changeScroll,changeTransform,fadeOrSlide;
    Context tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        tx=this;

        changeBounds=findViewById(R.id.changeBounds);
        changeBounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tx,ChangeBoundsActivity.class));
            }
        });

        changeClipBounds=findViewById(R.id.changeClipBounds);
        changeClipBounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tx,ChangeClipBoundsActivity.class));
            }
        });

        changeImageTransform=findViewById(R.id.changeImageTransform);
        changeImageTransform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tx,ChangeImageTransformActivity.class));
            }
        });

        changeScroll=findViewById(R.id.changeScroll);
        changeScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tx,ChangeScrollActivity.class));
            }
        });

        changeTransform=findViewById(R.id.changeTransform);
        changeTransform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tx,ChangeTransformActivity.class));
            }
        });

        fadeOrSlide=findViewById(R.id.fadeOrSlide);
        fadeOrSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tx,FadeOrSlideActivity.class));
            }
        });
    }
}
