package com.service;

import java.util.List;

import com.model.Admin;

public interface AdminService {

    public Admin createAdmin(Admin admin);

	public List<Admin> getAllAdmins();
	
    //public Admin getAdminById(int id);
    
	public void deleteAdmin(int adminId);

    public Admin findByAdminId(int adminId);

	public Admin loginAdmin(String userName, String password, String email);






    
    

}

