package com.example.demoazsdkclientlogger;

import com.azure.core.util.logging.ClientLogger;

public class DemoAzsdkClientLoggerApplication  {

	public static void main(String[] args) {
		final ClientLogger clientLogger = new ClientLogger(DemoAzsdkClientLoggerApplication.class);
		clientLogger.info("This is from the client logger.");
	}

}
