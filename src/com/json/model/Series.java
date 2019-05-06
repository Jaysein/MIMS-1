package com.json.model;

import java.util.List;

public class Series {
	public String name;
    public String type;
    public List<?> data;// ����Ҫ��int ������String ��Ȼǰ̨��ʾ���������ر���������ѧ�����ʱ��
    
    public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getType() {
		return type;
	}
 
	public void setType(String type) {
		this.type = type;
	}
	
	public List<?> getData() {
		return data;
	}
 
	public void setData(List<?> data) {
		this.data = data;
	}
 
	public Series(String name, String type, List<?> data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

	@Override
	public String toString() {
		return "Series [name=" + name + ", type=" + type + ", data=" + data + "]";
	}
}
