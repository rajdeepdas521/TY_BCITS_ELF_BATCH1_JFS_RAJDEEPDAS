package com.btm.oopsProgram;

import java.util.ArrayList;
import java.util.List;



public class ArrayList1 
{
public static void main(String[] args) 
{
	ArrayList<Integer> al=new ArrayList<Integer>();
	al.add(20);
	al.add(10);
	al.add(30);
	al.add(0, 40);
	al.add(1, 50);
	System.out.println(al);
	al.remove(1);
	System.out.println(al);
	al.set(1, 80);
	al.add(3,40);
	System.out.println(al);
	System.out.println(al.indexOf(40));
	System.out.println(al.lastIndexOf(40));
	for (int i = 0; i < al.size(); i++)
	{
		System.out.println(al.get(i));
	}
	List l=al.subList(1,4);
	System.out.println(l);
}
}
