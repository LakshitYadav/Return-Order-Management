package com.cts.rom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackagingAndDeliveryController{
	
	
	
	@GetMapping("/PackagingAndDeliveryCharge/{componentType}/{count}")
	public int PackagingAndDeliveryCost(@PathVariable String componentType, @PathVariable int count) 
	{
		int charge=50;
		if(componentType.equals("integral"))
		{
			charge=charge+100+200;
			return (charge*count);
			
		}
		else if(componentType.equals("accessory"))
		{
			charge=charge+100+50;
			return(charge*count);
		}
		else
		{
			charge=0;
			return charge;
		}
		
	}
	
}