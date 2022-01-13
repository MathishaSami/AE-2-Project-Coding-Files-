package NFC.VaccinationWebApp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import NFC.VaccinationWebApp.coonfig.DbConnection;
import NFC.VaccinationWebApp.model.VaccinationNFC;

public class VaccinationDao {


	private Logger logger = LogManager.getLogger(VaccinationDao.class);
	
	private List<VaccinationNFC> vaccinationNFCsList = new ArrayList<>();

	
	/**
	 * Get all the VaccinationNFCs.
	 * @return
	 */
	public List<VaccinationNFC> getAll(){
		
		
		List<VaccinationNFC> packages = getVaccinationNFCFromDb();
		
		return packages;
	}
	
	/**
	 * Get a VaccinationNFC by nic_no.
	 * @param int
	 * @return
	 */
	public VaccinationNFC getAPackage(int nic_no) {
		
		List<VaccinationNFC> packages = getVaccinationNFCFromDb();
		
		for (VaccinationNFC package1 : packages) {
			if (package1.getNic_no() == nic_no) {
				return package1;
			}
		}
		return null;
	}
	
//public VaccinationNFC getAPackage(int age) {
//		
//		List<VaccinationNFC> packages = getVaccinationNFCFromDb();
//		
//		for (VaccinationNFC package1 : packages) {
//			if (package1.getAge() == age) {
//				return package1;
//			}
//		}
//		return null;
//	}
//		


	



	
	public List<VaccinationNFC> getVaccinationNFCFromDb(){
	
		List<VaccinationNFC> vaccinationNfcList = new ArrayList<>();
		
		Connection conn = DbConnection.getInstance().getConnection();
		
//		SELECT * FROM vaccinated_data
//		WHERE age ='21';
		
		String sql = "SELECT * FROM `nic-vaccine_data`;";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet resultSet = stmt.executeQuery();
						
			while(resultSet.next()) {
				VaccinationNFC user = new VaccinationNFC();
				user.setUnique_id(resultSet.getString("Unique_ID"));
				user.setNic_no(resultSet.getInt("NIC_No"));
				user.setAge(resultSet.getInt("Age"));
				user.setVaccine_dose(resultSet.getString("Vaccine_Dose"));
				user.setVaccine(resultSet.getString("Vaccine"));
				user.setPlace_of_vaccination(resultSet.getString("Place_Of_Vaccination"));
				user.setDate_of_vaccination(resultSet.getString("Date_Of_Vaccination"));
				user.setRemarks(resultSet.getString("Remarks"));
	
				vaccinationNfcList.add(user);
			}
			conn.close();
			return vaccinationNfcList;
			
		} catch (SQLException e) {
			logger.error("DB ERROR :  COULD NOT ACCESS DATA - "+e.getMessage());
			return null;
		}
	}
	
	/**
	 * Add Package into the system.
	 * @param user
	 * @return
	 */
	public int addPackage(VaccinationNFC user) {
		
		Connection connection = DbConnection.getInstance().getConnection();
		
		try {		
			
			//Prepare SQL query.
			String sql = "INSERT INTO `nic-vaccine_data` (`unique_id`,`nic_no`, `age`, `vaccine_dose`, `vaccine`, `place_of_vaccination`,`date_of_vaccination`,"
					+ " `remarks`)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUnique_id());
			stmt.setInt(2, user.getNic_no());
			stmt.setInt(3, user.getAge());
			stmt.setString(4, user.getVaccine_dose());
			stmt.setString(5, user.getVaccine());
			stmt.setString(6, user.getPlace_of_vaccination());
			stmt.setString(7, user.getDate_of_vaccination());
			stmt.setString(8, user.getRemarks());
		
			int response = stmt.executeUpdate();
			connection.close();
			return response;
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SQL ERROR :  COULD NOT INSERT DATA - "+e.getMessage());
			return -1;
		}
	}
	private List<VaccinationNFC> LogFiles() {
	//Log
	logger.fatal("This is a FATAL log");
	logger.error("This is a ERROR log");
	logger.warn("This is a WARN log");
	logger.info("This is a INFO log");
	logger.debug("This is a DEBUG log");
	logger.trace("This is a TRACE log");
	
	return vaccinationNFCsList;
	}
	
	}

