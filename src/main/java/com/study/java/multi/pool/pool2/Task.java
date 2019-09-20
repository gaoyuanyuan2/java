package com.study.java.multi.pool.pool2;

public class Task implements Runnable {

	private int id ;
	private String name ;
	
	public Task(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		//
		System.out.println("Current:" + this.id +", " + this.name);
		try {
			Thread.sleep(5*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String toString(){
		return "{ id : " + this.id + ", name : " + this.name + "}";
	}
	

}
