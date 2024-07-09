package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

	public Admin findByAdminId(int adminId);

	public Admin findByUserNameAndEmail(String userName, String email);




}
