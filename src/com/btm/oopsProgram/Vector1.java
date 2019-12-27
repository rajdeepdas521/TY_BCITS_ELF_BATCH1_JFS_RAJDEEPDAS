package com.btm.oopsProgram;
import java.util.*;
public class Vector1 
{
public static void main(String[] args) 
{
Vector<Integer> v1=new Vector<Integer>();	
  v1.add(10);
  v1.add(20);
  v1.add(30);
  v1.add(40);
  v1.add(20);
  v1.add(null);
       System.out.println(v1);
  v1.remove(1);
  v1.ensureCapacity(6);
System.out.println(v1.capacity());
v1.insertElementAt(22, 3);
v1.removeElementAt(5);

       System.out.println(v1);
       System.out.println(v1.isEmpty());
       System.out.println(v1.size());
       System.out.println(v1.contains(20));
       System.out.println("========using for loop=============================");
       for (int i = 0; i < v1.size(); i++) 
       {
		System.out.println(v1.get(i));
	   }
       System.out.println("=========using for each loop===========================");
       for (Integer integer : v1)
       {
		System.out.println(integer);
	   }
       System.out.println("==========using iterator ==========================");
       Iterator itr=v1.iterator();
       while(itr.hasNext())
       {
    	   System.out.println(itr.next());
       }
       System.out.println("===========using backward diretion iteration=========================");
       ListIterator itr1=v1.listIterator(v1.size());
       while(itr1.hasPrevious())
       {
    	   System.out.println(itr1.previous());
    	   
       }
}
}
