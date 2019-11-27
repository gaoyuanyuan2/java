package com.study.java.algorithm.sort;

//简单选择排序
public class SelectSort {

	public void selectSort(int[] array) {
		int min;
		int tmp = 0;
		for (int i = 0; i < array.length; i++) {
			min = array[i];
			for (int j = i; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					tmp = array[i];
					array[i] = min;
					array[j] = tmp;
				}
			}
		}
		for(int num:array){
			System.out.println(num);
		}
	}
	
	public static void main(String [] args){
		SelectSort selertSort = new SelectSort();
		selertSort.selectSort(new int[]{9,4,2,6,7,3,10,33,88,1,17});
	}
}
