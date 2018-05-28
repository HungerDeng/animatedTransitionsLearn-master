package com.gdut.dkmfromcg.transitionlearn.scenes;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.ViewGroup;

/**
 * Created by dkmFromCG on 2017/12/2.
 * function: 手动切换两个 Scene
 */

public abstract class BaseScenesActivity extends AppCompatActivity {

    protected Scene scene1;
    protected Scene scene2;
    protected boolean isScene1=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //要切换Scene时,需要在OnCreate中实现这个方法
    protected void initScene(@IdRes int rootView, @LayoutRes int scene1_layout, @LayoutRes int scene2_layout) {
        ViewGroup sceneRoot= (ViewGroup) findViewById(rootView);
        scene1= Scene.getSceneForLayout(sceneRoot,scene1_layout,this);
        scene2=Scene.getSceneForLayout(sceneRoot,scene2_layout,this);
        TransitionManager.go(scene1);
    }

    abstract Transition getTransition();
    protected void clickChange(){
        TransitionManager.go(isScene1?scene2:scene1,getTransition());
        isScene1=!isScene1;
    }
}
