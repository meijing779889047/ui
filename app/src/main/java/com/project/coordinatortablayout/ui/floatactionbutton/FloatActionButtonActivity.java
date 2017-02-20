package com.project.coordinatortablayout.ui.floatactionbutton;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lnyp.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.project.coordinatortablayout.R;
import com.project.coordinatortablayout.config.BaseActivity;
import com.project.coordinatortablayout.ui.coordinatorlayout.adapter.RecyclerViewAdapter;
import com.project.coordinatortablayout.ui.coordinatorlayout.model.WeChatModel;

import java.util.ArrayList;
import java.util.List;


public class FloatActionButtonActivity extends BaseActivity {

    private FloatingActionButton fab;
    private CoordinatorLayout   main_layout;
    private RecyclerView         mRecyclerView;
    private List<WeChatModel> mData=new ArrayList<>();
    private RecyclerViewAdapter<RecyclerView.ViewHolder> weChatListAdapter;
    private HeaderAndFooterRecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_action_button);
        //初始化组件
        initView();
        //初始化数据
        initData();
    }



    /**
     * 初始化组件
     */
    private void initView() {
        main_layout= (CoordinatorLayout) findViewById(R.id.layout);
        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.hide();
        mRecyclerView= (RecyclerView) findViewById(R.id.rv_data);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Utils.scrollToPosition(mLayoutManager,0);
//                fab.hide();
              Snackbar snackbar=  Snackbar.make(main_layout,"无网络",Snackbar.LENGTH_SHORT).
                        setAction("设置", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(FloatActionButtonActivity.this,"去设置网络",Toast.LENGTH_SHORT).show();
                    }
                })      .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                        .setText("hehe")
                        .setCallback(new Snackbar.Callback() {
                            @Override
                            public void onDismissed(Snackbar snackbar, int event) {
                                super.onDismissed(snackbar, event);
                            }

                            @Override
                            public void onShown(Snackbar snackbar) {
                                super.onShown(snackbar);
                            }
                        });

                View view = snackbar.getView();//获取Snackbar的view
                if(view!=null){
                    //设置背景色
                    view.setBackgroundColor(getResources().getColor(R.color.colorAccent));//修改view的背景色
                    //文字颜色
                    ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(getResources().getColor(R.color.colorPrimary));//获取Snackbar的message控件，修改字体颜色
                }
//                setSnackbarColor(snackbar,R.color.colorPrimaryDark);
                snackbar.show();


            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i <30 ; i++) {
            WeChatModel model=new  WeChatModel();
            model.setId(""+i);
            model.setFirstImg("http://zxpic.gtimg.com/infonew/0/wechat_pics_-214279.jpg");
            model.setMark("2222");
            model.setTitle("标题 集宁到乌兰花的班车出事了");
            model.setUrl("url : http://v.juhe.cn/weixin/redirect?wid=wechat_20150401071581");
            model.setSource("内蒙那点事儿");
            mData.add(model);
        }
        mLayoutManager=new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        weChatListAdapter = new RecyclerViewAdapter<RecyclerView.ViewHolder>(this, mData, null);
        recyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(weChatListAdapter);
        mRecyclerView.setAdapter(recyclerViewAdapter);


    }
}
