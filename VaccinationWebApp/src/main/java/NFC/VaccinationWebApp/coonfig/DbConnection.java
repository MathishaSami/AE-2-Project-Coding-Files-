package NFC.VaccinationWebApp.coonfig;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.mysql.cj.callback.UsernameCallback;
import com.mysql.cj.jdbc.Driver;

public class DbConnection {

	//<<<<<<< HEAD
		private static Logger logger = LogManager.getLogger(DbConnection.class);
	//=======
//		private static Logger logger = LogManager.getLogger(DbConnection.class);

//		private static final String DB_URL="jdbc:mysql://localhost:3306/vaccine_db";
//		private static final String DB_USER="root";
//		private static final String DB_PASSWORD ="Root@1234";

	//	mysql://b5abbe2c87da73:c29df0ae@us-cdbr-east-05.cleardb.net/heroku_48999058ce9af82?reconnect=true
		
    // Username = b4aaf7d919b207
	// Password 4fd0bd59
	// Server = us-cdbr-east-05.cleardb.net

		private static final String DB_URL="jdbc:mysql://us-cdbr-east-05.cleardb.net/heroku_48999058ce9af82";
		private static final String DB_USER="b5abbe2c87da73";
		private static final String DB_PASSWORD ="c29df0ae";
		
		private static DbConnection newInstance = null;

		private DbConnection() {

	}

	public static DbConnection getInstance() {
		if (newInstance == null) {
			newInstance = new DbConnection();
		}
		
		return newInstance;
	}

	public Connection getConnection() {
	  	try {
	  				Driver driver =new Driver();
	  				DriverManager.registerDriver(driver);
	  				
	  				Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);  				
	  				logger.info("DB SUCCESS :  Connection Successful");
	  				return conn;			
	  				
	  			} catch (SQLException e) {
	  				e.printStackTrace();
	  				logger.error(e.hashCode()+" DB ERROR :  Connection failed - "+e.getMessage());
	  				return null;
	  			}
	  			
	  		}

	  	}

