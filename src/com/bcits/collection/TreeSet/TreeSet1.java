package com.bcits.collection.TreeSet;

import java.util.TreeSet;

public class TreeSet1 
{
public static void main(String[] args) 
{
	TreeSet<Person> t1=new TreeSet<Person>();	
t1.add(new Person(10,"anu"));
t1.add(new Person(16,"divya"));
t1.add(new Person(18,"pooja"));
System.out.println(t1);

}
}
