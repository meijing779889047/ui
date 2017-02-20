package com.project.coordinatortablayout.ui.inputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.coordinatortablayout.R;
import com.project.coordinatortablayout.util.Utils;


public class LoginActivity extends AppCompatActivity   implements View.OnClickListener{

    private TextView  tvLogin;
    private TextView  tvData;
    private TextInputEditText etEmail;
    private TextInputEditText  etPassword;
    private TextInputLayout  til_email;
    private TextInputLayout  til_password;

    public String  str="TextInputLayout的使用说明：  \n"
            +"TextInputLayout用于当用户输入内容时，将hint在上方显示，也可用于判断  \n"
            +"1.TextInputLayout不能单独使用,必须和edittext嵌套  \n"
            +"2.TextInputLayout只能包含一个edittext  \n"
            +"3.TextInputLayout将提示语显示在edittext的上方；将错误语显示在edittext的下方   \n"
            +"4.TextInputLayout.setHint() 显示提示语  \n"
            +"5.TextInputLayout.setError()   显示错误信息   \n"
            +"6.TextInputLayout.setEtrorEnabled() 设置错误信息师傅显示 false:不显示 true:显示  \n"
            +"7.TextInputLayout.getEdittext()  获取edittext的示例  \n ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化组件
        initView();
        //初始化事件
        initEvent();

    }



    /**
     * 初始化组件
     */
    private void initView() {
        etEmail=(TextInputEditText) findViewById(R.id.et_email);
        etEmail.setHint("请输入邮箱");
        etPassword=(TextInputEditText) findViewById(R.id.et_password);
        etPassword.setHint("请输入密码");
        til_email=(TextInputLayout)findViewById(R.id.til_email);
        til_email.setHint("");
        til_email.setHintTextAppearance(R.style.MyStyle);////设置hint的文本属性，改变hint文字的大小颜色等属性

        til_password=(TextInputLayout)findViewById(R.id.til_password);
        til_password.setCounterEnabled(false);
        /**
         *  设置hint的相关属性（由于TextInputLayout也是一个自定义控件，所以以app开头,并且需要给予命名空间：xmlns:app="http://schemas.android.com/apk/res-auto"）
            app:hintAnimationEnabled="true"//设置是否可以使用动画，默认是true
            app:hintEnabled="true"//设置是否可以使用hint属性，默认是true
            app:hintTextAppearance="@style/MyStyle"//设置hint的文本属性，改变hint文字的大小颜色等属性
         */

        til_password.setHint("");
        til_password.setHintAnimationEnabled(true);//设置是否可以使用动画，默认是true
        til_password.setEnabled(true);//设置是否可以使用hint属性，默认是true
        til_password.setHintTextAppearance(R.style.MyStyle);////设置hint的文本属性，改变hint文字的大小颜色等属性

        /**
         * 设置Counter（计数器）的相关属性
         app:counterEnabled="true"//设置是否可以开启计数器，默认是false
         app:counterOverflowTextAppearance="@style/MyStyle2"//设置计算器越位后的文字颜色和大小
         app:counterTextAppearance="@style/MyStyle"//设置正常情况下的计数器文字颜色和大小
         app:counterMaxLength="11"//设置计算器的最大字数限制
         */
        tvData= (TextView) findViewById(R.id.tv_data);
        tvLogin= (TextView) findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(this);
    }
    private void initEvent() {
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                 String data=  s.toString();
                if(TextUtils.isEmpty(data)){
                    til_email.setHint("");
                    til_email.setError("");
                    etEmail.setHint("请输入密码");
                    til_email.setErrorEnabled(false);
                    tvData.setVisibility(View.GONE);
                }else{
                    tvData.setVisibility(View.GONE);
                    til_email.setHint("请输入邮箱");
                    if(!Utils.validateEmail(data)){
                        til_email.setError("请输入正确的邮箱");
                        til_email.setErrorEnabled(true);
                    }else{
                        til_email.setError("请输入正确的邮箱");
                        til_email.setErrorEnabled(false);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String data=  s.toString();
                if(TextUtils.isEmpty(data)){
                    til_password.setHint("");
                    til_password.setError("");
                    etPassword.setHint("请输入密码");
                    til_password.setErrorEnabled(false);
                    tvData.setVisibility(View.GONE);
                    til_password.setCounterEnabled(false);
                }else{
                    til_password.setCounterEnabled(true);
                    tvData.setVisibility(View.GONE);
                    til_password.setHint("请输入邮箱");
                    if(data.length()<6){
                        til_password.setError("请输入密码(6-16位)");
                        til_password.setErrorEnabled(true);
                    }else{
                        til_password.setError("请输入密码");
                        til_password.setErrorEnabled(false);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                Utils.hideKeyboard(LoginActivity.this,etEmail);
                Utils.hideKeyboard(LoginActivity.this,etPassword);
                login();
                break;
        }
    }

    /**
     * 登录
     */
    private void login() {
        String  email=etEmail.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(LoginActivity.this,"邮箱不能为空",Toast.LENGTH_SHORT).show();;
            tvData.setVisibility(View.GONE);
            return;
        }
        if(!Utils.validateEmail(email)){
            til_email.setError("请输入正确的邮箱");
            tvData.setVisibility(View.GONE);
            return;
        }
        String password=etPassword.getText().toString();
        if(TextUtils.isEmpty(password)){
            tvData.setVisibility(View.GONE);
            Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();;
            return;
        }
        if(password.length()<6){
            tvData.setVisibility(View.GONE);
            til_password.setError("密码长度不能小于六位");
            return;
        }
        til_email.setErrorEnabled(false);
        til_password.setErrorEnabled(false);
        Toast.makeText(getApplicationContext(), "OK! I'm performing login.", Toast.LENGTH_SHORT).show();
        tvData.setVisibility(View.VISIBLE);
        tvData.setText(str);

    }




}
