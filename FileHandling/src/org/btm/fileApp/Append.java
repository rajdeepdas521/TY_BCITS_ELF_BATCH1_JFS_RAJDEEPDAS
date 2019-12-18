package org.btm.fileApp;
import java.io.*;

public class Append
{


public static void main(String[] args) 
{
	try
	{
		String data="it is the best palace in the world";
		File f1=new File("D:\\fileReader");
		if(!f1.exists())
		{
			f1.createNewFile();
		}
		
		FileWriter f=new FileWriter(f1.getName(),true);
	
		BufferedWriter bw=new BufferedWriter(f);
		bw.write(data);
		bw.close();
		System.out.println("done");
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}
}
