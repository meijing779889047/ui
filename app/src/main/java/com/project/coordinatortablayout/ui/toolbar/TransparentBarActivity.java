package com.project.coordinatortablayout.ui.toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.project.coordinatortablayout.R;
import com.project.coordinatortablayout.ui.toolbar.config.BaseTransparentBarActivity;

/**
 * 使用toolbar做为标题栏并使状态栏透明
 */
public class TransparentBarActivity extends BaseTransparentBarActivity {


    private TextView  tvData;
    private String    info="使用toolbar做为标题栏并使状态栏透明（注意:需要系统的标题栏去掉） \n"
                            +"步骤：\n"
                            +"1.在res下创建values values-v19两个文件夹，并在v19的的style文件中TransparentBarStyle中设置<item name=\"android:windowTranslucentStatus\">true</item> 详情查看style文件  \n"
                            +"2.在values的dimens文件中设置<dimen name=\"toolbar_padding_top\">0dp</dimen>;在values-v19的dimens文件中设置<dimen name=\"toolbar_padding_top\">25dp</dimen>  \n"
                            +"3.创建一个toolbar_layout.xml布局文件并设置toolbar控件，设置paddingTop  \n"
                            +"4.创建BaseTransparentBarActivity.class做为activity的基类，并初始化toolbar以及状态栏，详情查看BaseTransparentBarActivity.class  \n"
                            +"5.创建一个TransparentBarActivity.class并继承BaseTransparentBarActivity \n"
                            +"6.在清单文件中的TransparentBarActivity.class设置  android:theme=\"@style/TransparentBarStyle，在此声明在activity中，当然你可以将此声明到application作为全局"
                            +"\n  运行";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent_bar);
        tvData= (TextView) findViewById(R.id.tv_data);
        tvData.setText(info);

    }
}
