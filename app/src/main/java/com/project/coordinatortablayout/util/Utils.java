package com.project.coordinatortablayout.util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 * Created by meijing on 2017/2/12.
 */

public class Utils {


    /**
     * 对邮箱进行验证
     * @param email
     * @return
     */
    public static  boolean validateEmail(String email) {
        String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    /**
     * 隐藏按键
     */
    public static  void hideKeyboard(Context context,View view) {
        if (view != null) {
            ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * recycerview 滑动到指定位置
     * @param mLayoutManager
     * @param postion
     */
    public static void scrollToPosition(LinearLayoutManager  mLayoutManager,int postion){
        mLayoutManager.scrollToPositionWithOffset(postion, 0);
        mLayoutManager.setStackFromEnd(true);
    }
}
