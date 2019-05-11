package models;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlElementRef;

@XmlRootElement 
public class TemporaryStore implements Serializable{
	
	protected static List<String> list = new ArrayList<>();

	public static void add(String s){
		list.add(s);
	}

	public static List<String> getAll(){
		return list;
	}
}