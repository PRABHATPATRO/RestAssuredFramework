package com.AutomationProject.configProperties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
//This is the method of using OWNER feature of java which is a replacement of properties
@Sources({
	"file:src/test/resources/PropertiesFile/configuration.properties"
})
//If we want to use OWNER functionality to ease the use of property file then
// we need to extend config interface 
public interface ConfigProperties extends Config {
	
	@Key("baseURI")
	public String getbaseURI();
	
	@Key("basePath")
	public String getBasePath();
	
	@Key("getCustomerDetails")
	public String getCustomerDetails();
	

}
