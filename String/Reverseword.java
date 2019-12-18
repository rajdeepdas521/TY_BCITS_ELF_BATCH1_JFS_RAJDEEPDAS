
public class Reverseword
{
public void reverseString(String str) 
{
	

String []words=str.split(" ");
String reverseS=" ";

for(int i=0;i<words.length;i++)
{
	String word=words[i];
	String reverseW="";
	for(int j=word.length()-1;j>=0;j--)
	{
		reverseW=reverseW+word.charAt(j);
	}
	reverseS=reverseS+reverseW+" ";
}
System.out.println(str);
System.out.println(reverseS);

}
public static void main(String[] args) 
{
Reverseword rv=new Reverseword();
rv.reverseString("how are you doing");
rv.reverseString("hoga beda hudugi nana bittu");
}
}
