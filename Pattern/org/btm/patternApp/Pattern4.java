package org.btm.patternApp;

public class Pattern4
{
public static void main(String[] args) 
{
 for(int i=1;i<=5;i++)
 {
	for(int j=4;j>=i;j--)
	{
		System.out.print(" ");
	}

	for(int p=1;p<=i;p++)
	{
		System.out.print("*");
	}
	System.out.println();
 }
}
}
