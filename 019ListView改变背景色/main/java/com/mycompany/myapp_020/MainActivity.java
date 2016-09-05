package com.mycompany.myapp_020;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<MyData> list=new ArrayList<>();
    ListView listView;
    MyAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.listView);
        MyData myData=new MyData();
        myData.name="张三";
        list.add(myData);


        myData=new MyData();
        myData.name="李四";
        list.add(myData);

        myData=new MyData();
        myData.name="王五";
        list.add(myData);
        adapter=new MyAdapter(list,this);
        listView.setAdapter(adapter);

        myData=new MyData();
        myData.name="成龙";
        adapter.addItem(myData);

        adapter.remove(0);
        adapter.update(1,"大可");
        radioGroup= (RadioGroup) findViewById(R.id.radio_group);
        r1= (RadioButton) findViewById(R.id.radioButton);
        r2= (RadioButton) findViewById(R.id.radioButton2);
        r3= (RadioButton) findViewById(R.id.radioButton3);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        dr=listView.getSelector();
    }
    RadioGroup radioGroup;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    Drawable dr;

    @Override
    public void onClick(View view) {
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radioButton:
                //默认的颜色
                listView.setSelector(dr);

                break;
            case R.id.radioButton2:
                listView.setSelector(R.drawable.green);
                break;
            case R.id.radioButton3:
                listView.setSelector(R.drawable.spectrum);
                break;

        }
    }
}
