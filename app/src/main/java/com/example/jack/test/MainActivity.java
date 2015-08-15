package com.example.jack.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GridView gv_list_home;
    private MyAdapter adapter;
    private  static String [] names = {
            "手机防盗" ,"通讯卫士","软件管理",
            "进程管理","流量统计","手机杀毒",
            "缓存管理","高级工具","设置中心"
    };

    private  static int[] ids = {
            R.drawable.safe,R.drawable.callmsgsafe,R.drawable.app,
            R.drawable.taskmanager,R.drawable.netmanager,R.drawable.trojan,
            R.drawable.sysoptimize,R.drawable.atools,R.drawable.settings
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv_list_home = (GridView)findViewById(R.id.gv_list_home);
        adapter = new MyAdapter();
        gv_list_home.setAdapter(adapter);

        gv_list_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //1.gv 2 点击的某一个 3 位置 4 ID
                switch (position)
                {
                    case 8://进入设置中心
                        Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });

    }

    private  class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view =  View.inflate(MainActivity.this, R.layout.list_item_home, null);
            ImageView imageView =(ImageView) view.findViewById(R.id.iv_item);
            TextView textView = (TextView)view.findViewById(R.id.tv_item);

            textView.setText(names[position]);
            imageView.setImageResource(ids[position]);
            return view;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
