package com.project.coordinatortablayout.ui.toolbar;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.project.coordinatortablayout.R;
import com.project.coordinatortablayout.ui.toolbar.config.BaseTransparentBarActivity;

/**
 * 该界面使用toolbar作为标题栏，并说明一些toolbar的属性
 */
public class ToolBarAttributeActivity extends BaseTransparentBarActivity {

    private Toolbar  mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_too_lbar_attribute);
        mToolbar=getTooBar();
        setToolbarAttribute();
    }

    /**
     * 设置toolbar属性
     */
    private void setToolbarAttribute() {
        if(mToolbar!=null){
            //设置导航图标
            initNavatation();
            //设置title
            initTitle();
            //设置menu
            initMenu();
        }
    }
    /**
     * 设置toolbar的导航图标
     */
    private void initNavatation() {
        //设置图标
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        // xml  app:navigationIcon="?attr/homeAsUpIndicator"
        //设置监听
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    /**
     * 设置标题
     */
    private void initTitle() {
        //设置标题
        mToolbar.setTitle("Title");
        //设置子标题
        mToolbar.setSubtitle("subtitle");
        //设置applogo图标
        mToolbar.setLogo(R.mipmap.ic_launcher);
    }

    private void initMenu() {
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    Toast.makeText(ToolBarAttributeActivity.this ,"搜索" , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_settings) {
                    Toast.makeText(ToolBarAttributeActivity.this , "通知" , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_cut) {
                    Toast.makeText(ToolBarAttributeActivity.this ,"设置", Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_cut1) {
                    Toast.makeText(ToolBarAttributeActivity.this ,"更多" , Toast.LENGTH_SHORT).show();

                }else if(menuItemId==R.id.menu){
                    Toast.makeText(ToolBarAttributeActivity.this ,"菜单" , Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
