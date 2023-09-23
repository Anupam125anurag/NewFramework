package com.example.frameworksample;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String report_list[];
    int icon[];
    LayoutInflater inflater;


    public CustomBaseAdapter(Context ctx, String [] reportList, int[] icons){
        this.context =ctx;
        this.report_list=reportList;
        this.icon=icons;
        inflater=LayoutInflater.from(ctx);
    }


    @Override
    public int getCount() {
        return report_list.length;
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
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView txtview = (TextView) convertView.findViewById(R.id.textView2_1page);
        ImageView iconimg = (ImageView) convertView.findViewById(R.id.imageView_1page);
        txtview.setText(report_list[position]);
        iconimg.setImageResource(icon[position]);

        iconimg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                Log.i("CUSTOM_LIST_VIEW","Item is clicked @ Position : : " + position);
                if(position== 3) {
                    Intent in = new Intent(v.getContext(), MainActivity5.class);
                    context.startActivity(in);
                }

            }
        });
        return convertView;
    }
}
