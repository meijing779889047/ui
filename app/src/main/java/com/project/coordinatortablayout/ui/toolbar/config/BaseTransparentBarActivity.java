package com.project.coordinatortablayout.ui.toolbar.config;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.project.coordinatortablayout.R;
/**
 * 基类  使用toolbar作为标题栏，并使状态栏透明与标题栏的背景色一致
 */
public class BaseTransparentBarActivity extends AppCompatActivity {

    private LinearLayout  rootLayout;
    private Toolbar       mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_transparent_bar);
        //初始化状态栏透明
        initTransparentBar();
        // 初始化toolbar
        initToolbar();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(View.inflate(this,layoutResID,null));
    }

    @Override
    public void setContentView(View view) {
         rootLayout= (LinearLayout) findViewById(R.id.activity_base_transparent_bar);
        if(rootLayout!=null){
            rootLayout.addView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            initToolbar();
        }
    }

    /**
     * 初始化状态栏透明
     */
    private void initTransparentBar() {
        if(Build.VERSION.SDK_INT> Build.VERSION_CODES.KITKAT){
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.flags= (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS|params.flags);
        }
    }

    /**
     * 初始化toolbar
     */
    private void initToolbar() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        if(mToolbar!=null){
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }


    /**
     * 获取toolbar
     * @return
     */
    public Toolbar getTooBar(){
           return   mToolbar;
    }


    /**
     * 显示toolbar
     */
    public   void showToolbar(){
          if(mToolbar!=null){
              mToolbar.setVisibility(View.VISIBLE);
          }
    }

    /**
     * 隐藏toolbar
     */
    public  void  hideToolbar(){
        if(mToolbar!=null){
            mToolbar.setVisibility(View.GONE);
        }
    }
}
