package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ConnectMYSQL {
	
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void testDB() throws ClassNotFoundException, SQLException{
		

		//Create object for Report with filepath
		report=new ExtentReports("target/dbreport.html");
		
		//Start the test
		logger=report.startTest("verifyDBdeatils");
	
		//Log the status in report
		logger.log(LogStatus.INFO, "verifyDBdeatils ");
		
		 Class.forName("com.mysql.jdbc.Driver");
	     System.out.println("Driver Loaded");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/seleniumpractice","komal","admin");            
	     
	       System.out.println("Connection created");
	       
	       
	        Statement smt=con.createStatement();
	          
	        System.out.println("Statement created");
	 
	    
	        ResultSet rs=  smt.executeQuery("Select * from seleniumuser");
	 
	        System.out.println("Query Executed");
	        while(rs.next()){
	        	   
	            String uname=    rs.getString("firstname");
	            String email=      rs.getString("email");
	      
	             System.out.println("Uname is "+uname+" email id is "+email);
	        }

	        
	      //Pass the test in report
			logger.log(LogStatus.PASS, "Test Verified");
			
			//End the test
			report.endTest(logger);
			
			//Flush the data to report
			report.flush();   
}
}
