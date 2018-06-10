package com.study.java.gof23.templateMethod;

/*
		1、什么时候用到模板方法模式:
		实现一个算法时,整体步骤很固定。
		但是,某些部分易变。易变部分可以抽象成出来,供子类实现。
		2、开发中常见的场景:
		非常频繁。各个框架、类库中都有他的影子。
		比如常见的有:
		数据库访问的封装Junit单元测试
		servlet中关于doGet/doPost方法调用Hibernate中模板程序
		spring中JDBCTemplate、HibernateTemplate等。
*/

public class Client {
	public static void main(String[] args) {
		BankTemplateMethod btm = new DrawMoney();
		btm.process();
		
		//采用匿名内部类
		BankTemplateMethod btm2 = new BankTemplateMethod() {
			
			@Override
			public void transact() {
				System.out.println("我要存钱！");
			}
		};
		btm2.process();
		
		BankTemplateMethod btm3 = new BankTemplateMethod() {
			@Override
			public void transact() {
				System.out.println("我要理财！我这里有2000万韩币");
			}
		};
		
		btm3.process();
		
	}
}



class DrawMoney extends BankTemplateMethod {

	@Override
	public void transact() {
		System.out.println("我要取款！！！");
	}
	
}
