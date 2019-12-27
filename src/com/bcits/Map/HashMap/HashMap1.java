package com.bcits.Map.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap1 
{
public static void main(String[] args)
{
HashMap<Integer,String> hm=new HashMap<Integer, String>();
hm.put(24,"divya");
hm.put(25,"abhi");
hm.put(21,"rajdeep");
Set<Map.Entry<Integer,String>> s=hm.entrySet();
for (Map.Entry<Integer, String> entry : s)
{
	System.out.println(entry.getKey());
	System.out.println(entry.getValue());
	System.out.println("-----------------------");
}
System.out.println(hm.get(21));
System.out.println("-----------------------");
Set<Integer>s1=hm.keySet();
for (Integer integer : s1)
{
	System.out.println(integer);	
}
Collection<String>s2=hm.values();
for (String string : s2) {
	System.out.println(string);
}
}
}
