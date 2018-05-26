package com.study.java.gof23.factory.factorymethod;


public class BydFactory implements CarFactory {

	@Override
	public Car createCar() {
		return new Byd();
	}

}
