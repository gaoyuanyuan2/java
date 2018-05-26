package com.study.java.gof23.factory.factorymethod;



public class BenzFactory implements CarFactory {

	@Override
	public Car createCar() {
		return new Benz();
	}

}
