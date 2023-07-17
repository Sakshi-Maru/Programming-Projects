package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("lInfo")
@Data

public class LabTestInfo {
	
	@Value("${lab.bpPrice}")
	private float bloodProfilePrice;
	
	@Value("${lab.rtpcPrice}")
	private float rtcprPrice;
	
	@Value("${lab.echo2DPrice}")
	private float echo2DPrice;
	
	
 
}
