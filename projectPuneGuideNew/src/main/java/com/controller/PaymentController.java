package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.PaymentNotFoundException;
import com.model.Payment;
import com.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin( origins="http://localhost:4200")

public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/createPayment")
	public ResponseEntity<Payment> createPayment(@RequestBody Payment p){
		
		Payment payment=paymentService.createPayment(p);
		
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Payment Added").body(payment);
	}
	
	@GetMapping("/getOnePayment/{id}")
	public ResponseEntity<Payment> getOnePayment(@PathVariable("id")int id){
		
		Payment payment=paymentService.getOnePayment(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get","Get Payment").body(payment);	
	}
	
	@DeleteMapping("/deletePayment/{id}")
	public ResponseEntity<Map<String, Object>> deletePayment(@PathVariable("id")int id)throws PaymentNotFoundException
	{
		Map<String,Object> response = paymentService.deletePayment(id);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/updatePayment")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) throws PaymentNotFoundException{
		Payment p=paymentService.updatePayment(payment);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("updated","Payment updated").body(payment);	
	}
	
	@GetMapping("/getAllPayment")
	public List<Payment> getAllPayment() {
		return paymentService.getAllPayments();
	}
}
