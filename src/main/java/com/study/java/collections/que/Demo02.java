package com.study.java.collections.que;
//�����Զ����ջ
public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack<String> backHistory =new MyStack<String>(3);
		backHistory.push("www.baidu.com");
		backHistory.push("www.google.com");
		backHistory.push("www.sina.com");
		backHistory.push("www.bjsxt.cn");
		
		System.out.println("��С��"+backHistory.size());
		
		//����
		String item=null;
		while(null!=(item=backHistory.pop())){
			System.out.println(item);
		}
	}

}
