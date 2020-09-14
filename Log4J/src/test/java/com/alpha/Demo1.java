package com.alpha;

import org.apache.logging.log4j.*;
public class Demo1 {

	private static Logger log=LogManager.getLogger(Demo1.class.getName());


	public static void main(String[] args) {

		log.debug("I am debugging");
		if(2>0) {
			log.error("Error occured");
		}		else {
			log.error("object is not present");
		}
		log.fatal("Fatal error");
		log.info("Button is not displayed");
	}
}