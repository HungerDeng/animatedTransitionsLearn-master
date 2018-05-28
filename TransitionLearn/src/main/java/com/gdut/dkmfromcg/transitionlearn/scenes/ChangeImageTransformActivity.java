package com.gdut.dkmfromcg.transitionlearn.scenes;

import android.graphics.Matrix;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.gdut.dkmfromcg.transitionlearn.R;

/**
 * 效果不明显
 */
public class ChangeImageTransformActivity extends BaseScenesActivity {

    private static final String TAG = "ChangeImageTransformAct";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_scene);
        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickChange();
                Log.d(TAG, ": "+isScene1);
            }
        });

        //捕捉matrix的变化,貌似不明显?
/*        ViewGroup rootView=findViewById(R.id.rootView);


        View view1= LayoutInflater.from(this).inflate(R.layout.imagetransform_scene1,null);
        View view2= LayoutInflater.from(this).inflate(R.layout.imagetransform_scene2,null);

        ImageView iv1=view1.findViewById(R.id.imageView4);
        Matrix matrix1=new Matrix();
        matrix1.setTranslate(150,50);
        matrix1.preScale(0.8f,0.8f);
        iv1.setImageMatrix(matrix1);

        ImageView iv2=view2.findViewById(R.id.imageView4);
        Matrix matrix2=new Matrix();
        matrix2.setTranslate(50,50);
        matrix2.preScale(0.5f,0.5f);
        iv2.setImageMatrix(matrix2);


        scene1=new Scene(rootView,view1);
        scene2=new Scene(rootView,view2);
        TransitionManager.go(scene1);*/

        initScene(R.id.rootView,R.layout.imagetransform_scene1,R.layout.imagetransform_scene2);
    }

    @Override
    Transition getTransition() {
        return new ChangeImageTransform();
    }
}
