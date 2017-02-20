package com.project.coordinatortablayout.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.project.coordinatortablayout.R;

public class UIActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button  btn_meterial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        //初始化组件
        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        btn_meterial= (Button) findViewById(R.id.btn_metarial);
        btn_meterial.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_metarial://5.0新控件
                startActivity(new Intent(UIActivity.this,MeterialDesignActivity.class));
                break;
        }
    }
}
