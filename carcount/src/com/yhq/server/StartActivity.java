package com.yhq.server;

import com.avos.avoscloud.AVOSCloud;
import com.yhq.carcount.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class StartActivity extends Activity {
	private Spinner fangxiang;
	private Spinner zhuanxiang;
	private Button finish;
	private EditText crossname,iName;
	private String jinko = null;
	private String zhuan = null;
	private String name = null;
	private String inName = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		fangxiang = (Spinner) findViewById(R.id.jinfang);
		zhuanxiang = (Spinner) findViewById(R.id.zhuanxiang);
		finish = (Button) findViewById(R.id.finish);
		crossname = (EditText) findViewById(R.id.crossname);
		iName = (EditText) findViewById(R.id.iName);
		@SuppressWarnings("rawtypes")
		ArrayAdapter adapter1 = ArrayAdapter.createFromResource(
				this,R.array.fangxiang,android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		@SuppressWarnings("rawtypes")
		ArrayAdapter adapter2 = ArrayAdapter.createFromResource(
				this, R.array.zhuanxiang, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		fangxiang.setAdapter(adapter1);
		fangxiang.setVisibility(View.VISIBLE);
		zhuanxiang.setAdapter(adapter2);		
		fangxiang.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				jinko = arg0.getItemAtPosition(arg2).toString();
			
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		zhuanxiang.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				zhuan = arg0.getItemAtPosition(arg2).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		finish.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				name = crossname.getText().toString();
				inName = iName.getText().toString();
				if(inName!="" && name!=""){
					Intent intent = new Intent();
					Bundle data = new Bundle();
					data.putString("name",name);
					data.putString("fangxiang", jinko);
					data.putString("zhuanxiang", zhuan);
					data.putString("iName",inName);
					intent.putExtras(data);
					intent.setClass(StartActivity.this, CartypeActivity.class);
					startActivity(intent);
				}
				else{
					Toast.makeText(StartActivity.this, "请填写完整信息", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}
