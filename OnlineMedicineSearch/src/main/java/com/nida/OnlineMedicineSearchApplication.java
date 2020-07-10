package com.nida;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineMedicineSearchApplication {
static Logger log = Logger.getLogger(OnlineMedicineSearchApplication.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineMedicineSearchApplication.class, args);
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        log.error("Error!");
        log.fatal("Fatal error!");
        log.debug("Debugging...");
        log.info("Informational only.");
        log.warn("Warning!");
    }

}
