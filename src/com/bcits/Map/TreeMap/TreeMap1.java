package com.bcits.Map.TreeMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 
{
public static void main(String[] args) 
{
TreeMap<Integer,String> t=new TreeMap<Integer, String>();	
t.put(24, "Anu");
t.put(26, "Ganesh");
t.put(28, "Mahesh");

Set<Entry<Integer,String>> s=t.entrySet();

for (Entry<Integer, String> entry : s)
{
	System.out.println(entry);
}
}
}
