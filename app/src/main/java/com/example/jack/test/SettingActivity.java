package com.example.jack.test;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by jack on 15/8/15.
 */
public class SettingActivity extends Activity {

    private  SettingItemView siv_update;
    //保存软件参数用sharedpreference
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        sp = getSharedPreferences("config",MODE_PRIVATE);

        siv_update = (SettingItemView)findViewById(R.id.siv_update);

        boolean update =  sp.getBoolean("update",false);
        if (update)
        {
            siv_update.setChecked(true);
            siv_update.setDesc("自动升级已经开启");
        }else
        {
            siv_update.setChecked(false);
            siv_update.setDesc("自动升级已经关闭");
        }
        siv_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                //判断是否选中
                if (siv_update.isChecked())
                {
                    //已经打开自动升级
                    siv_update.setChecked(false);
                    siv_update.setDesc("自动升级已经关闭");
                    editor.putBoolean("update",false);
                }
                else
                {
                    //未打开
                    siv_update.setChecked(true);
                    siv_update.setDesc("自动升级已经开启");
                    editor.putBoolean("update",true);
                }

                editor.commit();
            }
        });
    }
}
