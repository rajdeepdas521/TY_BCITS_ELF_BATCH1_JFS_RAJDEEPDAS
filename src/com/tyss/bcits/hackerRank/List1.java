package com.tyss.bcits.hackerRank;
import java.util.*;
public class List1
{
static Scanner sc=new Scanner(System.in);
static List<Integer> list=null;
public static void main(String[] args)
{
	System.out.println("ENTER the number of Elements..");
	int n=Integer.parseInt(sc.nextLine());
	list =new ArrayList<Integer>(n);
	
	for(int i=0;i<n;i++)
	{
		System.out.println("ENTER THE ELEMENT"+ i  +"th index");
		list.add((i),Integer.parseInt(sc.nextLine()));
	}
	System.out.println(list);
	System.out.println("ENTER THE NUMBER OF QUERY");
	int q=Integer.parseInt(sc.nextLine());
	for (int i=1;i<=q;i++)
	{
	
	System.out.println("enter the querry type insert/delete");
	String query=sc.nextLine();
	if(query.equalsIgnoreCase("INSERT"))
	{
		System.out.println("ENTER THE INDEX");
		int x=Integer.parseInt(sc.nextLine());
		System.out.println("ENTER THE VALUE");
		int y=Integer.parseInt(sc.nextLine());
		list.add(x, y);
		n++;
	}
	else if (query.equalsIgnoreCase("DELETE"))
	{ 
		System.out.println("ENTER THE INDEX");
		int x=Integer.parseInt(sc.nextLine());
		list.remove(x);
		n--;
	}
	else
	{
		System.out.println("enter valid option");
	}
}
	System.out.println(list);
}
}