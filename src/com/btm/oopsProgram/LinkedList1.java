package com.btm.oopsProgram;
import java.util.*;
public class LinkedList1
{
public static void main(String[] args) 
{
LinkedList<Integer> l1=new LinkedList<Integer>();
l1.add(88);
l1.add(98);
l1.add(11);
l1.add(33);
System.out.println(l1);
l1.add(0,233);
System.out.println("=========================");
System.out.println(l1);
l1.remove(0);
System.out.println("=========================");
System.out.println(l1);
System.out.println(l1.isEmpty());
System.out.println(l1.size());
System.out.println(l1.contains(88));
}
}
