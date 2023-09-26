package com.example.frameworksample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {


     private String [] report_list = {"CTS Report", "Sanity report", "Sonarqube Report", "All Reports", "Security"};

    private int [] icon_images = {R.drawable.cts, R.drawable.sanity, R.drawable.sonarqube, R.drawable.report_analysis, R.drawable.android_security};


    private ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView = (ListView) findViewById(R.id.Listview);



        MyAdapter1 adapter1 = new MyAdapter1();

        listView.setAdapter(adapter1);





//        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), report_list, icon_images);
//
//
//        listView.setAdapter(customBaseAdapter);


//        card2 =  findViewById(R.id.card_View_1page);
//
//
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("CUSTOM_LIST_VIEW1","Item is clicking @ Position : : " + position);
                if(position== 3) {
                    String str = "http://192.168.1.113:8081/HDK855/Report_all.txt";
                    Intent in = new Intent(getApplicationContext(), MainActivity4.class);
                    in.putExtra("message_key", str);
                    startActivity(in);
                }
//Added From Vishal branch to complete codebase.
                if(position== 0) {
                    String str = "http://192.168.1.113:8081/HDK855/test_result.html";
                    Intent in = new Intent(getApplicationContext(), MainActivity4.class);
                    in.putExtra("message_key", str);
                    startActivity(in);
                }
                

                if(position== 1) {
                    String str = "http://192.168.1.113:8081/HDK855/report.html";
                    Intent in = new Intent(getApplicationContext(), MainActivity4.class);
                    in.putExtra("message_key", str);
                    startActivity(in);
                }

                if(position== 2) {
                    String str = "http://192.168.1.113:9000/dashboard?id=pixel2";
                    Intent in = new Intent(getApplicationContext(), MainActivity4.class);
                    in.putExtra("message_key", str);
                    startActivity(in);
                }

                if(position== 4) {
                    String str = "http://192.168.1.113:8081/HDK855/output.html";
                    Intent in = new Intent(getApplicationContext(), MainActivity4.class);
                    in.putExtra("message_key", str);
                    startActivity(in);
                }
            }
        });




    }



   public class MyAdapter1 extends BaseAdapter{


       @Override
       public int getCount() {
           return icon_images.length;
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

           convertView = getLayoutInflater().inflate(R.layout.card_view,parent,false);
           ImageView imageView1 = convertView.findViewById(R.id.img_view);
           TextView textView1 = convertView.findViewById(R.id.txt_view);


           textView1.setText(report_list[position]);
           imageView1.setImageResource(icon_images[position]);


           return convertView;
       }
   }

}






