
public class Doctor extends HospitalEmployee {

	protected  String speciality;

	

	public String toString() {
		return name + "\t" + number + "\t" + speciality ;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Doctor(String name, int number, String speciality) {
		super(name, number);
		this.speciality = speciality;
	}
	
	public void work(){
		System.out.println(name+ " works for the hospital. "+ name
				+ " is a(n) " + speciality + " doctor");
	}
	
}
