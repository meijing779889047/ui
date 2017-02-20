package com.project.coordinatortablayout.ui.cardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.coordinatortablayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * cardview
 * 1.依赖包：  compile 'com.android.support:cardview-v7:24.1.0'
 * 2.cardview继承与framelayout，是一个viewgroup，
 * 3.特点：有设置shadow（阴影），rounded conrner（圆角）的属性
 * 3.属性方法：
 *   CardView.cardBackgroundColor 设置背景色
     CardView.cardCornerRadius 设置圆角大小
     CardView.cardElevation 设置z轴阴影
     CardView.cardMaxElevation 设置z轴最大高度值
     CardView.cardUseCompatPadding 是否使用CompadPadding  设置内边距
     CardView.cardPreventCornerOverlap  在xml文件中设置内边距，在V20和之前的版本中添加内边距，这个属性为了防止内容和边角的重叠
     CardView.contentPadding 内容的padding
     CardView.contentPaddingLeft 内容的左padding
     CardView.contentPaddingTop 内容的上padding
     CardView.contentPaddingRight 内容的右padding
     CardView.contentPaddingBottom 内容的底padding
   4.margin低版本兼容：可以在/res/value和/res/value-v21分别创建dimens.xml文件，在dimens.xml里，随意命名，
                          对于Android 5.0以上的设置数值0dp，对于Android 5.0以下的设置数值（根据实际需求）
   5.使用情景：需要显示层次性的内容，可以考虑使用。
               需要显示列表或网格时，可以考虑使用。
 */
public class CardViewActivity extends AppCompatActivity {

    private RecyclerView  mRecyclerView;
    //数据源
    private List<ImageInfor>  list=new ArrayList<>();
    private RecyclerviewAdapter  mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        //初始化组件
        initView();
        //初始化数据
        initData();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.activity_card_view);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        list.add(new ImageInfor(R.drawable.empty_default_img, "数据1"));
        list.add(new ImageInfor(R.drawable.empty_default_img, "数据1"));
        list.add(new ImageInfor(R.drawable.empty_default_img, "数据1"));
        list.add(new ImageInfor(R.drawable.empty_default_img, "数据1"));
        list.add(new ImageInfor(R.drawable.empty_default_img, "数据1"));
        list.add(new ImageInfor(R.drawable.empty_default_img, "数据1"));
        list.add(new ImageInfor(R.drawable.empty_default_img, "数据1"));
        list.add(new ImageInfor(R.drawable.empty_default_img, "数据1"));

        LinearLayoutManager  layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter=new RecyclerviewAdapter(this,list);
        mRecyclerView.setAdapter(mAdapter);
    }
}
