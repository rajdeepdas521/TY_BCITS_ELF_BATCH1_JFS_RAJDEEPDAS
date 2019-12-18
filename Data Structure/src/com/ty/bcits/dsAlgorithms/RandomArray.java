package com.ty.bcits.dsAlgorithms;
import java.util.Random;
public class RandomArray 
{
public static void main(String[] args)
{
	Random r=new Random();
	int intArray[]=new int[500];
	for(int i=0;i<intArray.length;i++)
	{
		intArray[i]=r.nextInt(100);
		System.out.println(intArray[i]);
	}
}
}
