package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	public static void generateJvmReport(String jsonFile) {
//		1. Mention the path of where to store the JVM report 
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\AdactinHotelAutomation\\src\\test\\resources");
//		2. Create object for Configuration class
		Configuration configuration = new Configuration(file,"Adactin");
//		3. pass the os ,version details to display in report
		configuration.addClassifications("OS","WIN10");
		configuration.addClassifications("browser", "chrome");
		configuration.addClassifications("browserversion", "101");
//		4.Create  the list and add the Json file
		List<String>jsonfiles =new ArrayList<String>();
		jsonfiles.add(jsonFile);
//		5.Create object for ReporterBuilder Class
		ReportBuilder builder = new ReportBuilder(jsonfiles,configuration);
//		6.Read the Results from json file
		builder.generateReports();

	

}
}