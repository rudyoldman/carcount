package com.yhq.server;

import java.util.ArrayList;
import java.util.List;

import com.yhq.carcount.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CartypeActivity extends Activity {
	private Button finish;
    CheckBox motuoT;
	CheckBox xiaoqicheT;
	CheckBox xiaokecheT;
	CheckBox zhongkecheT;
	CheckBox dakecheT;
	CheckBox xiaohuocheT;
	CheckBox dahuocheT;
	CheckBox gongjiaoT;
	ArrayList<String> typeList;
	Bundle data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.type);
		finish = (Button) findViewById(R.id.typefi);
		motuoT = (CheckBox) findViewById(R.id.motuoC);
		xiaoqicheT = (CheckBox) findViewById(R.id.xiaoqicheC);
		xiaokecheT = (CheckBox) findViewById(R.id.xiaokecheC);
		zhongkecheT = (CheckBox) findViewById(R.id.zhongkecheC);
		dakecheT = (CheckBox) findViewById(R.id.dakecheC);
		xiaohuocheT = (CheckBox) findViewById(R.id.xiaohuocheC);
		dahuocheT = (CheckBox) findViewById(R.id.dahuocheC);
		gongjiaoT = (CheckBox) findViewById(R.id.gongjiaoC);
		data = getIntent().getExtras();
		typeList = new ArrayList<String>();
		motuoT.setOnClickListener(checklistener); 
		xiaoqicheT.setOnClickListener(checklistener);  
		xiaokecheT.setOnClickListener(checklistener);  
		zhongkecheT.setOnClickListener(checklistener); 
		dakecheT.setOnClickListener(checklistener); 
		xiaohuocheT.setOnClickListener(checklistener);  
		dahuocheT.setOnClickListener(checklistener); 
		gongjiaoT.setOnClickListener(checklistener);
		finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				data.putStringArrayList("type",typeList);
				Intent intent = new Intent();
				intent.putExtras(data);
				intent.setClass(CartypeActivity.this, CountActivity.class);
				startActivity(intent);
			}
		});
		
	}
	private OnClickListener checklistener = new OnClickListener() {
        
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
        	TextView  txt = (TextView)v;

            switch (txt.getId()) {
            case R.id.motuoC:
                if(motuoT.isChecked())
                {
                    typeList.add("motor");
                }else
                {
                	List<String> delList = new ArrayList<String>();
                	for (String string : typeList) {  
                	       if (string.equals("motor")) {  
                	          delList.add(string);  
                	       }  
                	   }  
                	typeList.removeAll(delList);
                }
                break;
            case R.id.xiaoqicheC:
            	 if(xiaoqicheT.isChecked())
                 {
                     typeList.add("xiaoqiche");
                 }else
                 {
                	 List<String> delList = new ArrayList<String>();
                 	for (String string : typeList) {  
                 	       if (string.equals("xiaoqiche")) {  
                 	          delList.add(string);  
                 	       }  
                 	   }  
                 	typeList.removeAll(delList);
                 }
                 break;
            case R.id.zhongkecheC:
            	if(zhongkecheT.isChecked())
                {
                    typeList.add("zhongkeche");
                }else
                {
                	List<String> delList = new ArrayList<String>();
                	for (String string : typeList) {  
                	       if (string.equals("zhongkeche")) {  
                	          delList.add(string);  
                	       }  
                	   }  
                	typeList.removeAll(delList);
                }
                break;
            case R.id.dakecheC:
            	if(dakecheT.isChecked())
                {
                    typeList.add("dakeche");
                }else
                {
                	List<String> delList = new ArrayList<String>();
                	for (String string : typeList) {  
                	       if (string.equals("dakeche")) {  
                	          delList.add(string);  
                	       }  
                	   }  
                	typeList.removeAll(delList);
                }
                break;
            case R.id.xiaohuocheC:
            	if(xiaohuocheT.isChecked())
                {
                    typeList.add("xiaohuoche");
                }else
                {
                	List<String> delList = new ArrayList<String>();
                	for (String string : typeList) {  
                	       if (string.equals("xiaohuoche")) {  
                	          delList.add(string);  
                	       }  
                	   }  
                	typeList.removeAll(delList); 
                }
                break;
            case R.id.dahuocheC:
            	if(dahuocheT.isChecked())
                {
                    typeList.add("dahuoche");
                }else
                {
                	List<String> delList = new ArrayList<String>();
                	for (String string : typeList) {  
                	       if (string.equals("dahuoche")) {  
                	          delList.add(string);  
                	       }  
                	   }  
                	typeList.removeAll(delList); 
                }
                break;
            case R.id.xiaokecheC:
            	if(xiaokecheT.isChecked())
                {
                    typeList.add("xiaokeche");
                }else
                {
                	List<String> delList = new ArrayList<String>();
                	for (String string : typeList) {  
                	       if (string.equals("xiaokeche")) {  
                	          delList.add(string);  
                	       }  
                	   }  
                	typeList.removeAll(delList); 
                }
                break;
            case R.id.gongjiaoC:
            	if(gongjiaoT.isChecked())
                {
                    typeList.add("gongjiao");
                }else
                {
                	List<String> delList = new ArrayList<String>();
                	for (String string : typeList) {  
                	       if (string.equals("gongjiao")) {  
                	          delList.add(string);  
                	       }  
                	   }  
                	typeList.removeAll(delList); 
                }
                break;
            default:
                break;
            }
        }
    };



	

}
