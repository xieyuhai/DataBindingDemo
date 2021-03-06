package com.hlq.databindingdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hlq.databindingdemo.R;
import com.hlq.databindingdemo.bean.ClassBean;
import com.hlq.databindingdemo.bean.LoveBean;
import com.hlq.databindingdemo.bean.MissBean;
import com.hlq.databindingdemo.databinding.ActivityObservableBinding;

/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2018/02/22
 * desc   : 观察者模式 绑定数据
 * version: 1.0
 */
public class ObservableActivity extends AppCompatActivity {

    private ActivityObservableBinding mBinding;

    private ClassBean mClassBean = new ClassBean("001", "100", "A1T105");
    private LoveBean mLoveBean = new LoveBean("Who are you", "H.L.Q.", true);

    private MissBean mMissBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
        mBinding.setClassX(mClassBean);
        mBinding.setLove(mLoveBean);
        mBinding.setPresenter(new Presenter());

        mMissBean = new MissBean();
        mMissBean.missWho.set("在思念谁？");
        mMissBean.missYou.set("在思念你~");
        mBinding.setMissBean(mMissBean);

        mBinding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMissBean.missWho.set("人生路，路漫漫~");
                mMissBean.missYou.set("累的时候，抬头看看天空！");
            }
        });

    }

    public class Presenter {

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mClassBean.setClassNo("No：" + s);
            mClassBean.setClassNum("Num：" + s);
            mClassBean.setClassName("Name：" + s);

            mLoveBean.setYouSelf("Who are you?" + s);
            mLoveBean.setMySelf("H.L.Q." + s);
            mLoveBean.setIsTrueLove(!mLoveBean.getIsTrueLove().get());

        }

    }

}
