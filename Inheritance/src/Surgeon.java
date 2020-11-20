
public class Surgeon extends Doctor{
	
	protected boolean isOperating;

	public String toString() {
		return  name + "\t" + number+ "\t" + speciality + "Operating" + " : "  + isOperating ;
	}

	public Surgeon(String name, int number, String speciality,
			boolean isOperating) {
		super(name, number, speciality);
		this.isOperating = isOperating;
	}

	public boolean isOperating() {
		return isOperating;
	}

	public void setOperating(boolean isOperating) {
		this.isOperating = isOperating;
	}
	
	
}
