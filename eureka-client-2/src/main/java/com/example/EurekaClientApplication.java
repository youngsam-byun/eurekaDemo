package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication eurekaClient= new SpringApplication(EurekaClientApplication.class);
		eurekaClient.addListeners(new ApplicationPidFileWriter("eureka-client-2.pid"));
		eurekaClient.run();
	}
}

@RestController
class ServiceInstanceRestController{
	@Autowired
	private DiscoveryClient discoverClient;
	
	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstanceByApplicationName(@PathVariable String applicationName){
		return this.discoverClient.getInstances(applicationName);
	}
	
	@RequestMapping("/greeting")
	public String greeting(){
		return "hello this is client 2";
	}
}