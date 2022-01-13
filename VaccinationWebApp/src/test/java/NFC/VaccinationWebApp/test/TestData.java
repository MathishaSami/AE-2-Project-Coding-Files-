package NFC.VaccinationWebApp.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import NFC.VaccinationWebApp.dao.VaccinationDao;
import NFC.VaccinationWebApp.model.VaccinationNFC;


public class TestData {

int unexpected = 0;
	
	@Test
	public void testUserDbCall() {
		VaccinationDao vaccinationDao = new VaccinationDao();
		List<VaccinationNFC> vaccinationNFCs = vaccinationDao.getAll();
		int actual = vaccinationNFCs.size();
		
		assertNotEquals(unexpected, actual);
	}
	
	
	int NIC_No = 2000114585;
	
	@Test
	public void testAPackage() {
		VaccinationDao vaccinationDao = new VaccinationDao();
		VaccinationNFC vaccinationNFC = vaccinationDao.getAPackage(NIC_No);
		
		assertNotNull(vaccinationNFC);
	}
}
