package com.dsl.ui_application_08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能：安卓下拉框Spinner详解Demo2
 *
 * 作者：单胜凌
 * 时间：2016.12.16
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextView mTextView1=null;
    private Spinner mSpinner1=null;

    //数据资源
    private String[] name={"李狗蛋","苗翠花","宝强绿","王尼玛","糕富帅","白肤美"};
    private int[] picId ={R.mipmap.tu1,R.mipmap.tu2,R.mipmap.tu33,R.mipmap.tu4,R.mipmap.tu5,R.mipmap.ic_launcher};
    //适配器
    private List<Map<String,Object>> dataList=null;
    private List<String> list = null;
    private ArrayAdapter adapter=null;
    private SimpleAdapter msimpleAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        //使用系统自带的适配器

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msimpleAdapter = new SimpleAdapter(this,getData(),R.layout.item,new String[] {"pic","text"},new int[]{R.id.imageView1,R.id.tv2});
        mSpinner1.setAdapter(msimpleAdapter);
        mSpinner1.setOnItemSelectedListener(this);
        mSpinner1.setDropDownVerticalOffset(30);
    }

    /**
     * 功能：控件初始化
     */
    private void initUI()
    {
        dataList = new ArrayList<>();
        list = new ArrayList<>();
        mTextView1 = (TextView)findViewById(R.id.tv1);
        mSpinner1= (Spinner)findViewById(R.id.spinner1);

        for(int i=0;i<name.length;i++)
        {
            list.add(name[i]);
        }
    }
    private List<Map<String,Object>> getData()
    {
        for(int i=0;i<name.length;i++)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("pic",picId[i]);
            map.put("text",name[i]);
            dataList.add(map);
        }
        return dataList;
    }

    /**
     * 功能：设置Text字体
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    public void onItemSelected(AdapterView<?> parent, View view,int position,long id)
    {
        String namenum = (String) adapter.getItem(position);
        mTextView1.setText("你选择了："+namenum);
    }

    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
