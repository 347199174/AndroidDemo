package com.example.jack.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jack on 15/8/15.
 * 自定义的组合控件
 */
public class SettingItemView extends RelativeLayout {

    private CheckBox cb_status;
    private TextView tv_desc,tv_name;
    /**
     * 初始化布局文件
     */
    private void initView(Context context)
    {
        //把一个布局文件变成一个view 并且加载在SettingItemView里边
        View.inflate(context,R.layout.setting_item_view,this);
        cb_status = (CheckBox)this.findViewById(R.id.cb_status);
        tv_desc = (TextView)this.findViewById(R.id.tv_desc);
        tv_name = (TextView)this.findViewById(R.id.tv_name);
    }

    public SettingItemView(Context context) {
        super(context);
        initView(context);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }
    /**
     * 校验组合空间是否有选中
     */
    public boolean isChecked()
    {
        return cb_status.isChecked();
    }
    //设置组合空间的焦点
    public  void setChecked(boolean checked)
    {
        cb_status.setChecked(checked);
    }
    //设置组合空间的描述信息aaaccc
    public void setDesc(String text)
    {
        tv_desc.setText(text);
    }
}
