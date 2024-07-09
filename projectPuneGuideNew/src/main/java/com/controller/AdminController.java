package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Admin;
import com.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin( origins="http://localhost:4200")

public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody Admin admin) {
        Admin foundAdmin = adminService.loginAdmin(admin.getUserName(), admin.getPassword(), admin.getEmail());

        if (foundAdmin != null && admin.getPassword().equals(foundAdmin.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

	
	
	/*
    @PostMapping("/login")
   
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
        Admin foundAdmin = adminService.findByAdminId(admin.getAdminId());
        if(admin.getPassword().equals(admin.getPassword()))
			return ResponseEntity.ok(admin);
        return ResponseEntity.ok(foundAdmin);	
    }*/
	
    /*
	public ResponseEntity<?>loginAdmin(@RequestBody Admin adminData){
		System.out.println(adminData);
		Admin admin=adminService.findByAdminId(adminData.getAdminId());
		if(admin.getPassword().equals(adminData.getPassword()))
			return ResponseEntity.ok(admin);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}*/
	

	
	@PostMapping("/createAdmin")
	public Admin createAdmin(@RequestBody Admin a) {
		return adminService.createAdmin(a);
	}
	/*@PostMapping("/createAdmin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin a) {
        Admin admin = adminService.createAdmin(a);
        return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Admin Added").body(admin);
    }*/	
	@GetMapping("/getAdminById/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("id")int id){
		
		Admin admin=adminService.findByAdminId(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get","Get Admin").body(admin);	
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public void deleteAdmin(@PathVariable("id")int id) {
		adminService.deleteAdmin(id);
	}
	
}
