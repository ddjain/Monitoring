package com.example.promethus;

import jakarta.websocket.server.PathParam;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PromethusApplication {

	@Autowired
	CustomMetricsService customMetricsService;
	public static void main(String[] args) {
		String abc=null;
		System.out.println(StringUtils.Em);
		//SpringApplication.run(PromethusApplication.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(){
		return "hello";
	}
	@GetMapping("/test")
	public String test(@RequestParam String name){
		if(name.equals("1234")) {
			customMetricsService.incrementCustomMetric();
			throw new RuntimeException("1234 is not acceptable");
		}
			return name;

	}

}
