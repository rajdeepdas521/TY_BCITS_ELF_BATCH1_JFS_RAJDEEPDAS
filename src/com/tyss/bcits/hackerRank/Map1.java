package com.tyss.bcits.hackerRank;

import java.util.*;

public class Map1 {
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Entry");
		int n=Integer.parseInt(sc.nextLine());
		
		Map<String,Integer> hm=new HashMap<String,Integer>();
		
		for(int i=1;i<=n;i++)
		{
			System.out.println("ENTER THE NAME");
			String name=sc.nextLine();
			System.out.println("ENTER THE PHONE NUMBER");
			int phone=Integer.parseInt(sc.nextLine());
			hm.put(name, phone);
		}
		System.out.println(hm);
	
		System.out.println("enter the queries");
		int q=Integer.parseInt(sc.nextLine());
		
		for (int i= 1;i <=q; i++)
		{
			System.out.println("enter the name searching...");
			String name=sc.nextLine();
			System.out.println("enter the number searching...");
			Integer number=Integer.parseInt(sc.nextLine());
			if(hm.get(number)!=null)
			{
				System.out.println(name +"="+number);
			}
			else
			{
				System.err.println("not found");
			}
		}
		
	}
}
