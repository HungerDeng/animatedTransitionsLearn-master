package com.gdut.dkmfromcg.transitionlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;

import com.gdut.dkmfromcg.customtransition.easytransition.EasyTransition;


/**
 * 可以在 enter和 exit时,设置Animator.AnimatorListener listener来实现ContentTransition的效果
 *
 * 可参考 : EasyTransition : https://github.com/huzenan/EasyTransition
 * http://blog.csdn.net/u012199331/article/details/72137112
 */
public class ShareElementsUnder21Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_elements_under21);
        EasyTransition.enter(this);
    }

    @Override
    public void onBackPressed() {

        EasyTransition.exit(this,800, new DecelerateInterpolator());
        //super.onBackPressed();
    }
}
