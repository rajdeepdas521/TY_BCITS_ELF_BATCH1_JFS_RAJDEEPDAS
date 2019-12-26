package com.tyss.bcits.hackerRank;
import java.util.*;
public class HashSet1
{
public static void main(String[] args)
{
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the numbers");
   int n=Integer.parseInt(sc.nextLine());
   
   HashSet<String> set=new HashSet<String>();
   
   for(int i=1;i<=n;i++)
   {
	   System.out.println("Enter the first name");
	   String fname=sc.nextLine();
	   System.out.println("Enter the second name");
	   String lname=sc.nextLine();
	   set.add(fname+" "+lname);
	   System.out.println(set.size());
   }
}
}
