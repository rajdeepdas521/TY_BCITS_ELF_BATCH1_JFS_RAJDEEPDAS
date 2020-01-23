package com.bcits.springcoreannotations.beans;

import com.bcits.springcoreannotations.interfaces.Animal;

public class Elephant implements Animal {

	@Override
	public void eat() {
		System.out.println("SugarCane!!!!!!");
	}

	@Override
	public void speak() {
		System.out.println("Trumpet!!!!!");
	}

}
