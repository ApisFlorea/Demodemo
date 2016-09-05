package com.mycompany.myapp_018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MyData> list=new ArrayList<MyData>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listView);

        MyData myData=new MyData();
        myData.value="张三";
        myData.data=100;
        list.add(myData);

        myData=new MyData();
        myData.value="李四";
        myData.data=200;
        list.add(myData);
        myData=new MyData();
        myData.value="五麻子";
        myData.data=300;
        list.add(myData);

        MyAdapter myAdapter=new MyAdapter(list,this);
        listView.setAdapter(myAdapter);

        myData=new MyData();
        myData.value="李小龙";
        myData.data=200;

        myAdapter.addItem(myData);

        myAdapter.remove(0);
        myAdapter.modify(2, "小小");


    }
}
