package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hsptl")
@Data
public class Hospital {
	
	@Value("KIMS") //hard coding
	private String name;
	@Value("30") //hard coding
	private int rank;
	
	@Value("${hsptl.name}") //collecting from properties
	private String name1;
	
	@Value("${hsptl.age}") //collecting from properties
	private String age;
	
	@Value("${Path}") //injecting from env.variable
	private String pathData;
	
	@Value("${os.name}") //injecting system property value
	private String os;
	
	@Autowired //Autowiring
	@Value("#{lInfo}") //using SPEL performing injection to object type property
	private LabTestInfo info;
	
	@Value("#{lInfo.bloodProfilePrice+lInfo.rtcpPrice}") //SPEL based arithmetic operation and injection
	private float labTestBillAmt;

}
 