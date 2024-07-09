package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.model.Admin;

@Service
public class AdminServiceImplementation implements AdminService{

	@Autowired
	private AdminRepository adminRepo;

	public Admin createAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}

	@Override
	public void deleteAdmin(int adminId) {
		adminRepo.deleteById(adminId);
	}

	public Admin findByAdminId(int adminId) {
        return adminRepo.findByAdminId(adminId);
    }	

	public Admin loginAdmin(String userName, String password, String email) {
        return adminRepo.findByUserNameAndEmail(userName, email);	
    }
}
