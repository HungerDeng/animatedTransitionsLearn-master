package com.gdut.dkmfromcg.transitionlearn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdut.dkmfromcg.transitionlearn.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends Fragment {


    public ShareFragment() {
        // Required empty public constructor
    }

    View mView;
    ImageView imageView;
    TextView textView;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_share, container, false);
        imageView=mView.findViewById(R.id.iv);
        textView=mView.findViewById(R.id.tv);
        btn=mView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextFragment fragment=new TextFragment();
                fragment.setSharedElementEnterTransition(new ChangeBounds());
                fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                getFragmentManager().beginTransaction()
                        .replace(R.id.rootView,fragment)
                        .addToBackStack(null)
                        .addSharedElement(imageView,"iv_share_to_frg")
                        .addSharedElement(textView,"tv_share_to_frg")
                        .commit();
            }
        });

        return mView;
    }

}
