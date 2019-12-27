package com.btm.oopsProgram;

public interface Idemo
{
int a=10;
abstract  public void meth();
default void meth1() { 
	System.out.println("hiii");
}
}
