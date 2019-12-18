package org.btm.fileApp;
import java.io.*;

public class Test1 
{
public static void main(String[] args) throws IOException
{
	File f=new File("java.txt");
	String msg="java is an object oriented";
	byte buffer[]=msg.getBytes();
	FileOutputStream os=new FileOutputStream(f);
	os.write( buffer);
	os.close();
}
}
