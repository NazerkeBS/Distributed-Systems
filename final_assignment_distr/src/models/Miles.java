package models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlElementRef;

@XmlRootElement 
public class Miles implements Serializable{
	
	private float mile;
	private float km;

	public Miles (float mile){
		this.mile = mile;
	}

	public void convertToKm(){
		this.km = (float)1.61*this.mile;
	}

	public float getKm(){
		return this.km;
	}

	@Override
	@XmlElement
	public String toString(){
		String s = this.mile + " miles = " + this.km + " km";
		TemporaryStore.add(s);
		return s;
	}

}