package NFC.VaccinationWebApp;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import NFC.VaccinationWebApp.dao.VaccinationDao;
import NFC.VaccinationWebApp.model.VaccinationNFC;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("nfc")
public class NFCResource {

	private Gson gson = new Gson();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPackages() {
		VaccinationDao packageDao = new VaccinationDao();
		List<VaccinationNFC> vaccinationNfcList = packageDao.getAll();
		
		String jsonString = gson.toJson(vaccinationNfcList);
		
		return Response
				.status(200)
				.entity(jsonString)
				.header("Access-Control-Allow-Origin", "*")
				.build();
	}
	
	@Path("{nic_no}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnItem(@PathParam("nic_no") int nic_no) {
		VaccinationDao packageDao = new VaccinationDao();
		VaccinationNFC package1 = packageDao.getAPackage(nic_no);
		if(package1 != null) {
			String jsonString = gson.toJson(package1);
			return Response
					.status(200)
					.entity(jsonString)
					.header("Access-Control-Allow-Origin", "*")
					.build();
		} else {
			Map<String, String> errorMsg = new HashMap<>();
			errorMsg.put("ERROR", "Invalid Package Code");
			
			String errorString = gson.toJson(errorMsg);
			return Response
					.status(400)
					.entity(errorString)
					.build();
		}
	}
	
//	@Path("{age}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getAnItem(@PathParam("age") int age) {
//		VaccinationDao packageDao = new VaccinationDao();
//		VaccinationNFC package1 = packageDao.getAPackage(age);
//		if(package1 != null) {
//			String jsonString = gson.toJson(package1);
//			return Response
//					.status(200)
//					.entity(jsonString)
//					.header("Access-Control-Allow-Origin", "*")
//					.build();
//		} else {
//			Map<String, String> errorMsg = new HashMap<>();
//			errorMsg.put("ERROR", "Invalid Package Code");
//			
//			String errorString = gson.toJson(errorMsg);
//			return Response
//					.status(400)
//					.entity(errorString)
//					.build();
//		}
//	}
//	
}
