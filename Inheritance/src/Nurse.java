
public class Nurse extends HospitalEmployee {

	protected int numOfPatients;

	public int getNumOfPatients() {
		return numOfPatients;
	}

	public void setNumOfPatients(int numOfPatients) {
		this.numOfPatients = numOfPatients;
	}

	public String toString() {
		return  name + number + " has " + numOfPatients +" patients" ;
	}

	public Nurse(String name, int number, int numOfPatients) {
		super(name, number);
		this.numOfPatients = numOfPatients;
	}
	
	public void work(){
		System.out.println(name+ " works for the hospital. "+ name
				+ " is a(n) nurse with " + numOfPatients + " patients");
	}
}
