package com.study.java.collections.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

import java.util.Map;
import java.util.Set;

/**
 * ˫����Map -->Table -->rowKey+columnKey+value
 * 1������
 *  ���е�������:cellSet()
 *  ���е�ѧ��: rowKeySet()
 *  ���еĿγ�:columnKeySet()
 *  ���еĳɼ�: values()
 *  ѧ����Ӧ�Ŀγ�: rowMap() +get(ѧ��)
 *  				row(ѧ��)
 *  �γ̶�Ӧ��ѧ��: columnMap +get(�γ�)
 *  				column(�γ�)
 * @author Administrator
 *
 */
public class Demo08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table<String,String,Integer> tables=HashBasedTable.create();
		//��������
		tables.put("a", "javase", 80);
		tables.put("b", "javase", 90);
		tables.put("a", "oracle", 100);
		tables.put("c", "oracle", 95);
		
		//���е�������
		Set<Cell<String,String,Integer>> cells =tables.cellSet();
		for(Cell<String,String,Integer> temp:cells){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
		System.out.println("==========ѧ���鿴�ɼ�==============");
		System.out.print("ѧ��\t");
		//���еĿγ�
		Set<String> cours =tables.columnKeySet();
		for(String t:cours){
			System.out.print(t+"\t");
		}
		System.out.println();
		//���е�ѧ��
		Set<String> stus =tables.rowKeySet();
		for(String stu:stus){
			System.out.print(stu+"\t");
			Map<String,Integer> scores =tables.row(stu);
			for(String c:cours){
				System.out.print(scores.get(c)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("==========�γ̲鿴�ɼ�==============");
		System.out.print("�γ�\t");
		//���е�ѧ��
		Set<String> stuSet =tables.rowKeySet();
		for(String t:stuSet){
			System.out.print(t+"\t");
		}
		System.out.println();
		//���еĿγ�
		Set<String> courSet =tables.columnKeySet();
		for(String c:courSet){
			System.out.print(c+"\t");
			Map<String,Integer> scores =tables.column(c);
			for(String s:stuSet){
				System.out.print(scores.get(s)+"\t");
			}
			System.out.println();
		}
		System.out.println("===========ת��===========");
		Table<String,String,Integer> tables2 =Tables.transpose(tables);
		//���е�������
		Set<Cell<String,String,Integer>> cells2 =tables2.cellSet();
		for(Cell<String,String,Integer> temp:cells2){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
	}

}
