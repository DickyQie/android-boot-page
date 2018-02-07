package com.channeloffdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.channeloffdemo.HomeActivity;
import com.channeloffdemo.R;


/**
 * Created by zhangqie on 2016/11/12.
 */


public class Fragment3 extends Fragment {
    private View view;
    private RelativeLayout mRelativeLayout;
    private ImageView mImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view=getView();
        initView();
    }
    private void initView() {
        mRelativeLayout= (RelativeLayout) view.findViewById(R.id.fragment_background);
        mRelativeLayout.setBackgroundResource(R.mipmap.three);
        mImageView= (ImageView) view.findViewById(R.id.fragment_text);
        mImageView.setVisibility(View.VISIBLE);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                Intent intent=new Intent(getActivity(),HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
