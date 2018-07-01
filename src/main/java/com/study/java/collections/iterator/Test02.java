package com.study.java.collections.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试Map的遍历方式
 * @author Administrator
 *
 */
public class Test02 {
	
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("aa", "aaaa");
		map.put("bb", "bbbb");
		
		//遍历Map的第一种方式
		Set keys = map.keySet();
		for(Iterator iter = keys.iterator();iter.hasNext();){
			String keyStr = (String) iter.next();
			System.out.println(keyStr+"---"+map.get(keyStr)); 
		}
		
		//遍历Map的第二种方式
		Set<Entry> set2 = map.entrySet();
		for(Iterator iter = set2.iterator();iter.hasNext();){
			Entry e = (Entry) iter.next();
			System.out.println(e.getKey()+"---"+e.getValue());
			
		}
	}

}
