package logic;

import entities.Hospital;

public class HospitalBuilder implements Builder {

	private Hospital hospital = new Hospital();

	@Override
	public void buildHospital() {
		RoomAbstractFactory raf = new RoomAbstractFactory();
		RoomKindFactory diagnosticFactory = raf.getRoomKindFactory("diagnostic");
		RoomKindFactory internmentFactory = raf.getRoomKindFactory("internment");
		RoomKindFactory childFactory = raf.getRoomKindFactory("child");

		this.hospital.addDiagnosticRoom(diagnosticFactory.getRoom("MRI"));
		this.hospital.addDiagnosticRoom(diagnosticFactory.getRoom("MRI"));
		this.hospital.addDiagnosticRoom(diagnosticFactory.getRoom("ray"));
		this.hospital.addDiagnosticRoom(diagnosticFactory.getRoom("tomography"));

		this.hospital.addInternmentRoom(internmentFactory.getRoom("clinic"));
		this.hospital.addInternmentRoom(internmentFactory.getRoom("clinic"));
		this.hospital.addInternmentRoom(internmentFactory.getRoom("terapy"));
		this.hospital.addInternmentRoom(internmentFactory.getRoom("terapy"));
		this.hospital.addInternmentRoom(internmentFactory.getRoom("terapy"));

		this.hospital.addChildRoom(childFactory.getRoom("neonatal"));
		this.hospital.addChildRoom(childFactory.getRoom("neonatal"));
		this.hospital.addChildRoom(childFactory.getRoom("pediatric"));
		this.hospital.addChildRoom(childFactory.getRoom("pediatric"));
		this.hospital.addChildRoom(childFactory.getRoom("pediatric"));
	}

	@Override
	public Hospital getHospital() {
		return this.hospital;
	}

}
