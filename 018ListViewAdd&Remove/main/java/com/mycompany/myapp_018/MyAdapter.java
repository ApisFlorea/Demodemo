package com.mycompany.myapp_018;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by huden on 2016/8/1.
 */
public class MyAdapter extends BaseAdapter {
    private List<MyData>list;
    private LayoutInflater layoutInflater;
    private  Context context;

    public MyAdapter(List<MyData> list, Context context) {
        this.list = list;
        this.context = context;
        this.layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        DataDHolder dataHolder=null;
        if(view==null){
            //得到布局
            view=layoutInflater.inflate(R.layout.item,null);
            dataHolder=new DataDHolder();
            dataHolder.value= (TextView) view.findViewById(R.id.textView);
            dataHolder.data= (TextView) view.findViewById(R.id.textView2);
            dataHolder.imageView= (ImageView) view.findViewById(R.id.imageView);

            view.setTag(dataHolder);
        }else{
            dataHolder= (DataDHolder) view.getTag();
        }
        //设置值
        dataHolder.value.setText(list.get(i).value);
        dataHolder.data.setText(String.valueOf(list.get(i).data));
        dataHolder.imageView.setImageResource(R.drawable.ic_launcher);
        return view;
    }
    //添加值111
    public  void addItem(MyData myData){
        if(myData==null)
            return;
            list.add(myData);
        //添加到GetView中
        notifyDataSetChanged();
    }

    public void remove(int position)
    {
        list.remove(position);
        notifyDataSetChanged();
    }

    public void modify(int position, String value)
    {
        MyData myData = list.get(position);
        myData.value = value;
        notifyDataSetChanged();
    }

    public static class DataDHolder{
        public TextView value;
        public TextView data;
        public ImageView imageView;
    }
}
