import java.io.*;
public class Person implements Serializable{
	private String name;
	private String family_name;
	private String message;

	public Person(String name, String family_name, String message){
		this.name = name;
		this.family_name = family_name;
		this.message = message;
	}

	public String getName(){
		return this.name;
	}
	public String getFamilyName(){
		return this.family_name;
	}

	public String getMessage(){
		return this.message;
	}

	public void setFamilyName(String family_name){
		this.family_name = family_name;
	}
	public void setMessage(String message){
		this.message = message;
	}
}