package logic;

import entities.Hospital;

public class HospitalDirector {

	private Builder builder;

	public HospitalDirector(Builder builder) {
		this.builder = builder;
	}

	public void constructHospital() {
		this.builder.buildHospital();
	}

	public Hospital getHospital() {
		return this.builder.getHospital();
	}
}
