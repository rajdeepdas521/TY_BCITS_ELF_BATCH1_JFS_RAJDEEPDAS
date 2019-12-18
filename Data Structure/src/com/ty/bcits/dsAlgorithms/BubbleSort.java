package com.ty.bcits.dsAlgorithms;
import java.util.*;
import java.util.Random;

import java.time.Duration;
import java.time.Instant;

public class BubbleSort 


{
	
	   static void bubbleSort(int[] arr)
	    {  
	    	
	        int n = arr.length;  
	        int temp = 0;  
	         for(int i=0; i < n; i++)
	         {  
	                 for(int j=1; j < (n-i); j++)
	                 {  
	                             if(arr[j-1] > arr[j])
	                          {  
	                               	 temp = arr[j-1];  
	                                 arr[j-1] = arr[j];  
	                                 arr[j] = temp;  
	                           }  
	                          
	                  }  
	          } 
	  	 }
	    
	 static  void countDrution()
	   {
		   
		    Instant start=Instant.now();
		    int arr[] ={500,499,498,488,480,121,120,113,31,30,28,27,14,13,9,8,7,6,5,4,3,2};
			Instant end=Instant.now();
			Long duration=Duration.between(start, end).toMillis();
			double seconds=duration/1000.0;
			System.out.println("bubblesort takes  " +  seconds  +"  Seconds");
	    }
	 
	    public static void main(String[] args) 
	    {  
	    
	       int arr[] ={500,499,498,488,480,121,120,113,31,30,28,27,14,13,9,8,7,6,5,4,3,2}; 
	                 
	                System.out.println("Array Before Bubble Sort");  
	                for(int i=0; i < arr.length; i++)
	                   {  
	                        System.out.print(arr[i] + " ");  
	                   }
	                System.out.println();  
	                  
	                bubbleSort(arr); 
	                           
	                System.out.println("Array After Bubble Sort");  
	                for(int i=0; i < arr.length; i++)
	                    {  
	                        System.out.print(arr[i] + " ");  
	                    }  
	                System.out.println();
	                           countDrution();
	        }  
	}  

