import java.io.Serializable;
import java.util.ArrayList; 
  
class Student implements Serializable
{
	private int id;
	private String name;
	private double perc;
	
	Student()
	{
		super();
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public double getPerc(){
		return perc;
	}
	public void setPerc(double perc)
	{
		this.perc=perc;
	}
	public String toString()
	{
		return "students[id="+id+",name="+name+",perc="+perc+"]";
	}
}
        
    