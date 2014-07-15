package com.yhq.server;

import java.io.Serializable;
import java.util.ArrayList;

public class ShiduanData implements Serializable{
	public String time;
	public ArrayList<String> shiduanList;
	public ShiduanData(String time,ArrayList<String> shiduanList) {
		this.time = time;
		this.shiduanList = shiduanList;
	}
}
