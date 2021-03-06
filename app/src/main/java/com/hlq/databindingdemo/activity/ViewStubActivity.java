package com.hlq.databindingdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hlq.databindingdemo.R;
import com.hlq.databindingdemo.databinding.ActivityViewStubBinding;

/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2018/02/22
 * desc   : ViewStub Study
 * version: 1.0
 */
public class ViewStubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewStubBinding viewStubBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
        viewStubBinding.viewStub.getViewStub().inflate();
    }
}
