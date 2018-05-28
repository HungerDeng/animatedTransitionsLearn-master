package com.gdut.dkmfromcg.transitionlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.gdut.dkmfromcg.transitionlearn.R;

public class BeginDelayedActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView iv1,iv2,iv3,iv4;
    ViewGroup rootView;

    boolean isBig=false;
    int primarySize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_delayed);
        rootView=findViewById(R.id.rootView);
        iv1=findViewById(R.id.imageView1);
        iv2=findViewById(R.id.imageView2);
        iv3=findViewById(R.id.imageView3);
        iv4=findViewById(R.id.imageView4);
        primarySize=iv1.getLayoutParams().width;
        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //start scene 是当前的scene
        TransitionManager.beginDelayedTransition(rootView, TransitionInflater.from(this).inflateTransition(R.transition.explode_fade_changebounds));
        //next scene 此时通过代码已改变了scene statue
        changeScene(v);
    }

    private void changeScene(View v) {
        changeSize(v);
        changeVisibility(iv1,iv2,iv3,iv4);
        v.setVisibility(View.VISIBLE);
    }


    private void changeSize(View v) {

        isBig=!isBig;
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if(isBig){
            layoutParams.width=(int)(1.5*primarySize);
            layoutParams.height=(int)(1.5*primarySize);
        }else {
            layoutParams.width=primarySize;
            layoutParams.height=primarySize;
        }
        v.setLayoutParams(layoutParams);
    }

    /**
     * VISIBLE和INVISIBLE状态切换
     * @param ivs
     */
    private void changeVisibility(ImageView ... ivs) {
        for (View view:ivs){
            view.setVisibility(view.getVisibility()==View.VISIBLE?View.INVISIBLE:View.VISIBLE);
        }
    }
}
