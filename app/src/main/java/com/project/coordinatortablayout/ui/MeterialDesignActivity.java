package com.project.coordinatortablayout.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.coordinatortablayout.R;
import com.project.coordinatortablayout.config.BaseActivity;
import com.project.coordinatortablayout.ui.cardview.CardViewActivity;
import com.project.coordinatortablayout.ui.coordinatorlayout.CoordinatorLayoutActivity;
import com.project.coordinatortablayout.ui.floatactionbutton.FloatActionButtonActivity;
import com.project.coordinatortablayout.ui.inputlayout.LoginActivity;
import com.project.coordinatortablayout.ui.toolbar.CollapsingToolBarLayoutActivity;
import com.project.coordinatortablayout.ui.toolbar.CustomToolbarActivity;
import com.project.coordinatortablayout.ui.toolbar.ToolBarAttributeActivity;
import com.project.coordinatortablayout.ui.toolbar.TransparentBarActivity;

public class MeterialDesignActivity extends BaseActivity implements View.OnClickListener {

    private Button  btnToolBar;
    private Button  btnToolBarAttribute;
    private Button  btnToolBarCustom;
    private Button  btnCoordicatorLayout;
    private Button  btnTextInput;
    private Button  btnFloatingActionButton;
    private Button  btnCardView;
    private Button  btnCollapsingToolBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meterial_design);
        //初始化组件
        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
         btnToolBar= (Button) findViewById(R.id.btn_toolbar);
         btnToolBar.setOnClickListener(this);
         btnToolBarAttribute= (Button) findViewById(R.id.btn_toolbar_attributes);
         btnToolBarAttribute.setOnClickListener(this);
         btnToolBarCustom= (Button) findViewById(R.id.btn_toolbar_custom);
         btnToolBarCustom.setOnClickListener(this);
         btnCoordicatorLayout= (Button) findViewById(R.id.btn_coordication);
         btnCoordicatorLayout.setOnClickListener(this);
         btnTextInput= (Button) findViewById(R.id.btn_textinput);
         btnTextInput.setOnClickListener(this);
         btnFloatingActionButton= (Button) findViewById(R.id.btn_floatactionbutton);
         btnFloatingActionButton.setOnClickListener(this);
         btnCardView= (Button) findViewById(R.id.btn_cardview);
         btnCardView.setOnClickListener(this);
         btnCollapsingToolBarLayout= (Button) findViewById(R.id.btn_CollapsingToolBarLayout);
         btnCollapsingToolBarLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_toolbar://toolba最为标题栏并使状态栏透明
                startActivity(new Intent(this,TransparentBarActivity.class));
                break;
            case R.id.btn_toolbar_attributes://toolbar的一些常用属性
                startActivity(new Intent(this,ToolBarAttributeActivity.class));
                break;
            case R.id.btn_toolbar_custom://自定义toolbar
                startActivity(new Intent(this,CustomToolbarActivity.class));
                break;
            case R.id.btn_coordication://5.0新控件之CoordinatorLayout
                startActivity(new Intent(this,CoordinatorLayoutActivity.class));
                break;
            case R.id.btn_textinput://5.0新控件之TextInputLayout与textInputEdit的使用
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.btn_floatactionbutton://5.0新控件之floatActionButton的使用
                startActivity(new Intent(this,FloatActionButtonActivity.class));
                break;
            case R.id.btn_cardview://5.0新控件之cardview的使用
                startActivity(new Intent(this,CardViewActivity.class));
                break;
            case R.id.btn_CollapsingToolBarLayout://5.0新控件之CollapsingToolBarLayout的使用
                startActivity(new Intent(this,CollapsingToolBarLayoutActivity.class));
                break;
        }
    }
}
