package com.project.coordinatortablayout.ui.toolbar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.project.coordinatortablayout.R;

/**
 * 自定义toolbar
 * Created by meijing on 2017/2/12.
 */

public class ToolBarHelper {

      //上下文
     private Context  mContext;
     /*视图构造器*/
     private LayoutInflater  mLayoutInflater;
     //帧布局 容器父布局
     private FrameLayout mRootView;
     //用户的布局
     private View        mUserView;
     //toolbar
     private Toolbar     mToolBar;
    /**
     * 两个属性
     * 1.toolbar是否悬浮在窗口之上
     * 2.toolbar的高度获取
     */
    private  static  int[]  ATTRS=new int[]{
            R.attr.windowActionBarOverlay,
            R.attr.actionBarSize};

    public ToolBarHelper(Context context, int resId) {
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
        //初始化父布局
        initRootView();
        //初始化用户定义的布局
        initUserView(resId);
        //初始化toolbar
        initToolBar();
    }
    /**
     * 初始化布局  直接创建一个帧布局，作为视图容器的父布局
     */
    private void initRootView() {
        mRootView=new FrameLayout(mContext);
        ViewGroup.LayoutParams  params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mRootView.setLayoutParams(params);
    }
    /**
     * 初始化用户定义的布局
     * @param resId
     */
    private void initUserView(int resId) {
        mUserView = mLayoutInflater.inflate(resId, null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(ATTRS);
        /*获取主题中定义的悬浮标志*/
        boolean overly = typedArray.getBoolean(0, false);
        /*获取主题中定义的toolbar的高度*/
        int toolBarSize = (int) typedArray.getDimension(1,(int) mContext.getResources().getDimension(R.dimen.abc_action_bar_default_height_material));
        typedArray.recycle();
        /*如果是悬浮状态，则不需要设置间距*/
        params.topMargin = overly ? 0 : toolBarSize;
        mRootView.addView(mUserView, params);
    }
    /**
     * 初始化toolbar
     */
    private void initToolBar() {
        View toolbarView=mLayoutInflater.inflate(R.layout.toolbar,mRootView);
        mToolBar= (Toolbar) toolbarView.findViewById(R.id.id_tool_bar);
    }

    /**
     * 获取父布局
     * @return
     */
    public   FrameLayout  getRootView(){
        return   mRootView;
    }

    /**
     * 获取toolbar布局
     * @return
     */
    public  Toolbar  getToolBarView(){
        return  mToolBar;
    }
}
