package com.nt.comp;

public final class DTDC implements Courier{
	
	public DTDC() {
		System.out.println("DTDC::0-param constructor");
	}
	
	@Override
	public String deliver(int oid) {
		return oid+"order id is delivered by DTDC";
		
	}
}

