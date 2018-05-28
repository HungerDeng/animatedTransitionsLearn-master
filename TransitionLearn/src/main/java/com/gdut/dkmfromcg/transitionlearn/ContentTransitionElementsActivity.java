package com.gdut.dkmfromcg.transitionlearn;

import android.animation.Animator;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

public class ContentTransitionElementsActivity extends AppCompatActivity {

    FloatingActionButton fab;
    View image_bg;
    ImageView icon_gg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_transition);
        fab=findViewById(R.id.fab);
        image_bg=findViewById(R.id.image_bg);
        icon_gg=findViewById(R.id.icon_gg);

        getWindow().getEnterTransition().addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(image_bg, image_bg.getWidth() / 2, image_bg.getHeight() / 2
                        , icon_gg.getWidth()/2, Math.max(image_bg.getWidth(), image_bg.getHeight()));
                image_bg.setBackgroundColor(Color.BLACK);
                circularReveal.setDuration(600);
                circularReveal.start();
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                fab.animate()
                        .scaleY(1)
                        .scaleX(1)
                        .start();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
        super.onBackPressed();

    }
}
