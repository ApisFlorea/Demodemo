package com.mycompany.myapp_020;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by huden on 2016/8/2.
 */
public class MyAdapter  extends BaseAdapter{
    Context context;
    List<MyData> list;

    LayoutInflater inflater;

    public MyAdapter(List<MyData> list, Context context) {
        this.list = list;
        this.context = context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DataHolder holder=null;
        if(view==null){
            view=inflater.inflate(R.layout.item,null);
            holder=new DataHolder();
            holder.name= (TextView) view.findViewById(R.id.textView);
            holder.imageView= (ImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        }else{
            holder= (DataHolder) view.getTag();
        }
        holder.name.setText(list.get(i).name);
        holder.imageView.setImageResource(R.drawable.ic_launcher);
        return view;
    }
    //添加数据
    public void addItem(MyData myData){
        if(myData==null)
            return;
        list.add(myData);
        Log.v("你好","口口口kkkkkkkkkkkkkkkkkkkk");
        notifyDataSetChanged();
    }
    public void remove(int i){
        list.remove(i);
        notifyDataSetChanged();
    }
    public void update(int i,String string){
        MyData myData=list.get(i);
        myData.name=string;
        notifyDataSetChanged();
    }

    public static class DataHolder{
        public TextView name;
        public ImageView imageView;
    }
}
