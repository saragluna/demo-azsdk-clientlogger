package com.example.demoazsdkclientlogger;

import com.azure.core.util.logging.ClientLogger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAzsdkClientLoggerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoAzsdkClientLoggerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final ClientLogger clientLogger = new ClientLogger(DemoAzsdkClientLoggerApplication.class);
		clientLogger.info("This is from the client logger.");
	}
}
