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
public class Kilometer implements Serializable{
	private float km;
	private float miles;

	public Kilometer(float km){
		this.km = km;
	}

	public void convertToMiles(){
		this.miles = (float)0.6*this.km;
	}

	public float getMiles(){
		return this.miles;
	}

	@Override
	public String toString(){
		String s = this.km + " km = " + this.miles + " miles";
		TemporaryStore.add(s);
		return s;
	}
}