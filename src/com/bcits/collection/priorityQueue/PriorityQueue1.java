package com.bcits.collection.priorityQueue;

import java.util.*;

public class PriorityQueue1 
{
public static void main(String[] args) 
{
PriorityQueue<Integer> p=new PriorityQueue<Integer>();
p.add(11);
p.add(12);
p.add(8);
p.add(88);
p.add(44);
p.add(88);
//p.add(null);
System.out.println(p);
p.remove();
System.out.println(p);
}
}
