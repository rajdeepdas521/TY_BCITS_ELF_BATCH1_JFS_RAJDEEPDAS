package com.tyss.bcits.hackerRank;
import java.util.*;

public class ArrrayListSolution1
{
public static void main(String[] args) 
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter The Number Of Lines");
	int n=sc.nextInt();
	
	ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>(n);
	ArrayList<Integer> al1=null;
	
	for(int i=1;i<=n;i++)
	{
		System.out.println("Enter The Number Of Digits..");
		int d=sc.nextInt();
		al1=new ArrayList<Integer>(d);
		al1.add(0,d);
		for(int j=1;j<=d;j++)
		{
			System.out.println("enter the number of element"+ j+"th position");
			al1.add(j, sc.nextInt());
	    }
		System.out.println(al1.toString());
		al.add(al1);
	}
	System.out.println(al.toString());
	System.out.println("Enter the number of queries");
	int q=sc.nextInt();
	for(int i=1;i<=q;i++) 
	{
	System.out.println("Enter the Query"+i);
	System.out.println("Enter the Number Of Lines");
   
    
	}
	sc.close();
}
}
