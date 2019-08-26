package com.study.java.multi.future;

public class RealData implements Data{

	private String result ;
	
	public RealData (String queryStr){
		System.out.println( queryStr + "search long ..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("over");
		result = "result";
	}
	
	@Override
	public String getRequest() {
		return result;
	}

}
