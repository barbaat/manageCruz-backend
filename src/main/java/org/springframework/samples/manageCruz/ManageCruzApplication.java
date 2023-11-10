package org.springframework.samples.manageCruz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.samples.manageCruz.config.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication()
public class ManageCruzApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageCruzApplication.class, args);
	}

}
