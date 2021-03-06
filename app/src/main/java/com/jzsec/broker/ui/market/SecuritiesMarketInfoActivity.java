package com.jzsec.broker.ui.market;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mzule.activityrouter.annotation.Router;
import com.jzsec.broker.R;
import com.jzsec.broker.base.BaseActivity;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by zhaopan on 16/7/29.
 * e-mail: kangqiao610@gmail.com
 */
@Router("main")
public class SecuritiesMarketInfoActivity extends BaseActivity {
    private static final String TAG = "SecuritiesMarketInfoActivity";
    private static final boolean DEBUG = true;

    public static void open(Context context) {
        Intent intent = new Intent(context, SecuritiesMarketInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_securities_market_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String id2 = getIntent().getStringExtra("id");
        String qq2 = getIntent().getStringExtra("qq");
        String action = intent.getAction();
        if (Intent.ACTION_VIEW.equals(action)) {
            Uri uri = intent.getData();
            if (uri != null) {
                String id = uri.getQueryParameter("id");
                Toast.makeText(this, id, Toast.LENGTH_LONG).show();
            }
        }

        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainMarketInfoFragment.newInstance(getIntent().getExtras()));
        }
        //RootActivity不需要Back功能.
        setSwipeBackEnable(false);
    }

    @Override
    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }
}
