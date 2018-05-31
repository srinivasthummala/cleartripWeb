package com.cleartripweb.bean;

import com.qmetry.qaf.automation.data.BaseDataBean;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;
import com.qmetry.qaf.automation.util.Randomizer;

public class TrainsBean extends BaseDataBean {

	String fromaStation;
	
	String toStation;
	
	String trainClass;
	
	String date;
	@Randomizer(type=RandomizerTypes.DIGITS_ONLY, minval=1, maxval=6)
	String adults;
	@Randomizer(type=RandomizerTypes.DIGITS_ONLY, minval=1, maxval=6)
	String children;
	
	public String getFromaStation() {
		return fromaStation;
	}
	public void setFromaStation(String fromaStation) {
		this.fromaStation = fromaStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getTrainClass() {
		return trainClass;
	}
	public void setTrainClass(String trainClass) {
		this.trainClass = trainClass;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdults() {
		return adults;
	}
	public void setAdults(String adults) {
		this.adults = adults;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	

}
