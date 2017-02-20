package com.project.coordinatortablayout.config;

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

public class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private LinearLayout  rootLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        //代码设置状态栏透明
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.flags=WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS|layoutParams.flags;
        }
        initToolBar();
    }



    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(View.inflate(this,layoutResID,null));
    }

    @Override
    public void setContentView(View view) {
        rootLayout=(LinearLayout) findViewById(R.id.root_layout);
        if(rootLayout!=null){
            rootLayout.addView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            initToolBar();
        }
    }

    private void initToolBar() {
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar!=null) {
         //   mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
            mToolbar.setTitle("ToolBar");
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    protected  void hideToolBar(){
          if(mToolbar!=null){
              mToolbar.setVisibility(View.GONE);
          }
    }
    protected  void showToolBar(){
        if(mToolbar!=null){
            mToolbar.setVisibility(View.VISIBLE);
        }
    }

    protected  void setTitle(String title){
           if(mToolbar!=null){
               mToolbar.setTitle(title);
           }
    }

}
