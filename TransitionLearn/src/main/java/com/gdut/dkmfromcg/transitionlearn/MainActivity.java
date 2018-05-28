package com.gdut.dkmfromcg.transitionlearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdut.dkmfromcg.customtransition.easytransition.EasyTransition;
import com.gdut.dkmfromcg.customtransition.easytransition.EasyTransitionOptions;

public class MainActivity extends AppCompatActivity {

    Button scene,beginDelayed,contentTHold,contentT,shareAct,shareFra,shareActUnder21;

    ImageView ivShareToAct;
    TextView tvShareToAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppCompatActivity activity=this;
        ivShareToAct=findViewById(R.id.ivShareToAct);
        tvShareToAct=findViewById(R.id.tvShareToAct);

        scene=findViewById(R.id.scene);
        scene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity, SceneActivity.class));
            }
        });

        beginDelayed=findViewById(R.id.beginDelayedTransition);
        beginDelayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity, BeginDelayedActivity.class));
            }
        });

        contentTHold=findViewById(R.id.contentTranHoldView);
        contentTHold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(activity);
                ActivityCompat.startActivity(activity,new Intent(activity,ContentTransitionHoldViewActivity.class),optionsCompat.toBundle());
            }
        });

        contentT=findViewById(R.id.contentTransition);
        contentT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(activity);
                ActivityCompat.startActivity(activity,new Intent(activity,ContentTransitionElementsActivity.class),optionsCompat.toBundle());
            }
        });

        shareAct=findViewById(R.id.shareBetweenAct);
        shareAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity,ShareElementsToActActivity.class);
                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                        new Pair<View, String>(ivShareToAct,"shareIvToAct"),
                        new Pair<View, String>(tvShareToAct,"shareTvToAct"));

                Bundle bundle=optionsCompat.toBundle();

                /**
                 * 共享的数据仍需从这边传递
                 */
                //imageView 转换成Bitmap,可以进行传递,但是:Activity之间传递的数据量不能过大,否则程序会ORM.事实证明确实ORM了
                Bitmap bitmap=((BitmapDrawable)ivShareToAct.getDrawable()).getBitmap();
                //bundle.putParcelable("key_share_iv",bitmap); 所以这里不传递Bitmap
                bundle.putCharSequence("key_share_tv",tvShareToAct.getText());
                intent.putExtra("key_bundle",bundle);


                //startActivity(intent); 这样不会产生共享元素的效果
                ActivityCompat.startActivity(activity,intent,bundle);
            }
        });


        shareFra=findViewById(R.id.shareBetweenFrg);
        shareFra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity,ShareElementsToFrgActivity.class));
            }
        });

        shareActUnder21=findViewById(R.id.shareToActUnder21);
        shareActUnder21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyTransitionOptions options =
                        EasyTransitionOptions.makeTransitionOptions(
                                MainActivity.this,
                                ivShareToAct,tvShareToAct);
                EasyTransition.startActivity(
                        new Intent(MainActivity.this,ShareElementsUnder21Activity.class),
                        options);
            }
        });
    }

}
