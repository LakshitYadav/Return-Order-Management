package com.cts.rom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.rom.client.PaymentFeignClient;
import com.cts.rom.model.Payment;
import com.cts.rom.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PaymentFeignClient paymentFeignClient;

	public String completeProcessing(int requestID, long creditCardNumber, double creditLimit,
			double processingCharge) {
		double currentBalance = -1;
		String finalResponse = "Unable to connect to Payment Microservice";
		
		Payment payment = new Payment();
		payment.setRequestID(requestID);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setCreditLimit(creditLimit);
		payment.setProcessingCharge(processingCharge);
		paymentRepository.save(payment);

		/*
		 * Call Payment Microservice 
		 * Input to give - Credit Card Number, Processing Charge 
		 * Output to receive - Current Balance
		 */
		
		
		currentBalance = paymentFeignClient.getCurrentBalance(creditCardNumber, processingCharge);
		
		if (currentBalance  <= -1)
			finalResponse = "We are sorry. Your payment could not be processed due to insufficient limit.";
		else
			finalResponse = "Your Payment is successful. Thank you for using our service";

		return finalResponse;
	}

}
