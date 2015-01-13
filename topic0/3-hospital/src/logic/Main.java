package logic;

import entities.Hospital;

public class Main {

	public static void main(String[] args) {

		HospitalDirector hd = new HospitalDirector(new HospitalBuilder());
		Hospital hospital = null;

		hd.constructHospital();
		hospital = hd.getHospital();

		System.out.println(hospital);
	}

}
