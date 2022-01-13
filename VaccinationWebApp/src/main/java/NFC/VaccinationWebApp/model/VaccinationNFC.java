package NFC.VaccinationWebApp.model;

//import java.util.Date;

public class VaccinationNFC {

	private String unique_id;
	private int nic_no;
	private int age;
	private String vaccine_dose;
	private String vaccine;
	private String place_of_vaccination;
	private String date_of_vaccination;
	private String remarks;
	public VaccinationNFC() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VaccinationNFC(String unique_id, int nic_no, int age, String vaccine_dose, String vaccine,
			String place_of_vaccination, String date_of_vaccination, String remarks) {
		super();
		this.unique_id = unique_id;
		this.nic_no = nic_no;
		this.age = age;
		this.vaccine_dose = vaccine_dose;
		this.vaccine = vaccine;
		this.place_of_vaccination = place_of_vaccination;
		this.date_of_vaccination = date_of_vaccination;
		this.remarks = remarks;
	}
	public String getUnique_id() {
		return unique_id;
	}
	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}
	public int getNic_no() {
		return nic_no;
	}
	public void setNic_no(int nic_no) {
		this.nic_no = nic_no;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVaccine_dose() {
		return vaccine_dose;
	}
	public void setVaccine_dose(String vaccine_dose) {
		this.vaccine_dose = vaccine_dose;
	}
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	public String getPlace_of_vaccination() {
		return place_of_vaccination;
	}
	public void setPlace_of_vaccination(String place_of_vaccination) {
		this.place_of_vaccination = place_of_vaccination;
	}
	public String getDate_of_vaccination() {
		return date_of_vaccination;
	}
	public void setDate_of_vaccination(String date_of_vaccination) {
		this.date_of_vaccination = date_of_vaccination;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
