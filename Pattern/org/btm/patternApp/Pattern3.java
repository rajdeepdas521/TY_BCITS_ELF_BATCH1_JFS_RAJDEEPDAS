package org.btm.patternApp;

public class Pattern3 
{
public static void main(String[] args)
{
for(int i=1;i<=5;i++)
{
	for(int j=1;j<=i;j++)
	{
		System.out.print("*");
	}
	System.out.println();
}
	for(int k=1;k<=4;k++)
	{
		for(int p=4;p>=k;p--)
		{
			System.out.print("*");
		}
		System.out.println();
	}
	
}
}
