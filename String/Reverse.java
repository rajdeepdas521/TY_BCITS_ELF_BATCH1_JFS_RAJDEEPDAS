
import java.util.*;
public class Reverse
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);

System.out.println("Enter the string");
String s=sc.next();
int l=s.length();
String rev="";
for(int i=l-1;i>=0;i--)
{
	rev=rev+s.charAt(i);
}
System.out.println(rev);
}
}
