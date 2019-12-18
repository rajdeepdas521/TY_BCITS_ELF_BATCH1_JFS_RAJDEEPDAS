package com.ty.bcits.dsAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class SelectionSort 
{
	    public static void selectionSort(int []arr1)
	    {  
	        for (int i = 0; i < arr1.length - 1; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < arr1.length; j++)
	            {  
	                if (arr1[j] < arr1[index])
	                {  
	                    index = j;  
	                }  
	            }  
	            int smallerNumber = arr1[index];   
	            arr1[index] = arr1[i];  
	            arr1[i] = smallerNumber;  
	        }  
	    }  
	       static void countDuration()
	       {
	    	   int[] arr1 = {99,90,88,77,66,55,45,43,42,41,38,34,33,32,21,9,8,7,6,5,4,3,2};
	    	   
	    	   Instant start=Instant.now();
	    		Instant end=Instant.now();
	    		Long duration=Duration.between(start, end).toMillis();
	    		double seconds=duration/1000.0;
	    		System.out.println("addupto took  " + seconds+"Seconds");
	       }
	    public static void main(String a[])
	    {  
	        int[] arr1 = {99,90,88,77,66,55,45,43,42,41,38,34,33,32,21,9,8,7,6,5,4,3,2};  
	        System.out.println("Before Selection Sort");  
	        for(int i:arr1)
	        {  
	            System.out.print(i+" ");  
	        }  
	        System.out.println();  
	          
	        selectionSort(arr1);
	        countDuration();
	         
	        System.out.println("After Selection Sort");  
	        for(int i:arr1)
	        {  
	            System.out.print(i+" ");  
	        }  
	        countDuration();
	    }  
	}  

