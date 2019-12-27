package com.btm.oopsProgram;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 
{
public static void main(String[] args) {
	Collection<Integer> c1=new ArrayList<Integer>();
	c1.add(38);
	c1.add(70);
	c1.add(300);
	System.out.println(c1);
Collection<Integer> c2=new  ArrayList<Integer>();
c2.add(1);
c2.add(88);
c2.add(38);
System.out.println(c2);

System.out.println("--------------retainAll------------------------");
c2.retainAll(c1);
System.out.println(c1);
System.out.println(c2);
System.out.println("-----------to Array-----------");
Object[] ol=c2.toArray();
for (int i = 0; i <ol.length; i++)
{
	System.out.println(ol[i]);
}
}
}
