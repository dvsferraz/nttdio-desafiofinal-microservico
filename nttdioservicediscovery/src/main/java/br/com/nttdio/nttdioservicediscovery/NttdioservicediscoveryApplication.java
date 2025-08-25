package br.com.nttdio.nttdioservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NttdioservicediscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NttdioservicediscoveryApplication.class, args);
	}

}
