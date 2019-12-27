package com.bcits.collection.hashSet;
import java.util.*;
public class HashSet1
{
public static void main(String[] args) 
{
HashSet<Integer> h=new HashSet<Integer>();	
h.add(10);
h.add(11);
h.add(14);
h.add(13);
h.add(12);
h.add(1);
h.add(null);
h.add(10);
System.out.println(h);
h.remove(12);
System.out.println(h);
}
}
