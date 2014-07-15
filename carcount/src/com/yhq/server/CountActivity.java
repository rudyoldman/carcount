package com.yhq.server;

import java.util.ArrayList;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.yhq.carcount.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CountActivity extends Activity {
	private static final int SEND=1;
	private static final int ABOUT=2;
	private static final int LOCAL=3;
	private static final int SAVE=4;
	private String jinko = null;
	private String zhuan = null;
	private String name = null;
	private String iName = null;
	private ListView countList;
	private ArrayList<String> typelist;
	private ArrayList<ShiduanData> container;
	private TextView crossname,fangxiang,zhuanxiang;
	private EditText shiduan;
	public Handler handler;
	@SuppressLint("HandlerLeak")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.count);
		AVOSCloud.initialize(this, 
				"h7fh6xz25ccfw19c3l7lh8kom0lbykjeydf2jgh3x4mb41i5"
				, "4l53bosw4dvf3p0or7id9hwmcaqdesdlibgwg3ciufg7d9rw");
		countList = (ListView) findViewById(R.id.countList);
		crossname = (TextView) findViewById(R.id.name);
		fangxiang = (TextView) findViewById(R.id.jinko);
		zhuanxiang = (TextView) findViewById(R.id.zhuan);
		shiduan = (EditText) findViewById(R.id.shiduan);
		container = new ArrayList<ShiduanData>();
		Bundle data = getIntent().getExtras();
		typelist = data.getStringArrayList("type");
		jinko = data.getString("fangxiang");
		zhuan = data.getString("zhuanxiang");
		name = data.getString("name");
		iName = data.getString("iName");
		crossname.setText(name);
		fangxiang.setText(jinko);
		zhuanxiang.setText(zhuan);
		CountAadpter countAdpater = new CountAadpter(CountActivity.this,typelist);
		countList.setAdapter(countAdpater);
		handler = new Handler(){

			
			@SuppressLint("ShowToast")
			@Override
			public void handleMessage(Message msg) {
				if(msg.what == 0x123){
					AlertDialog.Builder builder= new AlertDialog.Builder(CountActivity.this);
					builder.setMessage("发送成功了！")
					.create()
					.show();
				}
				if(msg.what ==0x456){
					 AlertDialog.Builder builder = new AlertDialog.Builder(CountActivity.this);
					 builder.setTitle("warning!")
					 .setIcon(R.drawable.warn)
					 .setMessage("发送失败了"+"\n"+"请抢救一下你的网络")
					 
					 .setPositiveButton("去抢救", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
						}
					})
					 .create()
					 .show();
				}
			}
			
		};
	}

	class CountAadpter extends BaseAdapter{
		Context mContext;
		LayoutInflater inflater;
		ArrayList<String> typeList;
		public CountAadpter(Context mContext,ArrayList<String> typeArrayList) {
			super();
			this.mContext = mContext;
			this.typeList = typeArrayList;
			inflater=LayoutInflater.from(mContext);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return typeList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return typeList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View item=inflater.inflate(R.layout.countitem, null);
			Button countB = (Button) item.findViewById(R.id.itemB);
			countB.setText(typeList.get(position));
			EditText countE = (EditText) item.findViewById(R.id.itemE);
			countB.setOnClickListener(new CountOnclickListener(position,countE));
			return item;
		
		}
		class CountOnclickListener implements OnClickListener{
			int position;
			EditText countE;
			public CountOnclickListener(int position,EditText countE) {
				super();
				this.position = position;
				this.countE = countE;
			}
			@Override
			public void onClick(View v) {
				int num =StringToInt(countE.getText().toString(),0);
				num++;
				countE.setText(String.valueOf(num));
			}
			public  int StringToInt(String str, int def) {
		        int intRet = def;
		        try {
		            if (str == null || str.trim().equals(""))
		                str = def + "";
		            intRet = Integer.parseInt(str);
		        }
		        catch (NumberFormatException e) {
		            e.printStackTrace();
		        }
		        return intRet;
		    }
			
		}

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0,SEND, 1, R.string.send);
		menu.add(0,ABOUT,2,R.string.about);
		menu.add(0,LOCAL,3,R.string.local);
		menu.add(0,SAVE,4,R.string.save);
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == SEND){
			send();
		}
		if(item.getItemId() == ABOUT){
			
		}
		if(item.getItemId() == LOCAL){
			
		}
		if(item.getItemId() == SAVE){
			ArrayList<String> shiduanList = new ArrayList<String>();
			for(int i = 0; i < countList.getCount(); i++) 
            {             
				 View view = countList.getChildAt(i); 
				 view.setBackgroundColor(Color.GREEN);
			     EditText editText = (EditText) view.findViewById(R.id.itemE);  
			     String valueStr = editText.getText().toString();
			     shiduanList.add(valueStr);
				 editText.setText("0");			     			     
            }
		    ShiduanData shiduanData = new ShiduanData(shiduan.getText().toString()
		    		, shiduanList);
		    shiduan.setText("");
			container.add(shiduanData);
			Toast.makeText(CountActivity.this, "保存成功了"+"\n"+"可继续统计下一时段"
		    		 ,Toast.LENGTH_LONG).show();
		}
		
		return super.onOptionsItemSelected(item);
	}
	public void send(){
		
		for(int i = 0;i < container.size();i++){
			AVObject someOne = new AVObject(iName);
			for(int j = 0;j < container.get(i).shiduanList.size();j++){
				
				someOne.put("crossName",name);
				 someOne.put("jinkodao", jinko);
				 someOne.put("zhuanxiang",zhuan);
				 someOne.put("fenshiduan",container.get(i).time);
				 someOne.put(typelist.get(j),container.get(i).shiduanList.get(j));
				 
			 }
			someOne.saveInBackground(new SaveCallback() {
				
				@Override
				public void done(AVException e) {
					if(e == null){
						handler.sendEmptyMessage(0x123);
					}
					else{
						handler.sendEmptyMessage(0x456);
					}
				}
			});
		 }
		
	}
}
