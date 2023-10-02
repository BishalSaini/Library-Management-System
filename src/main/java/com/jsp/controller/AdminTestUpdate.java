package com.jsp.controller;

import com.jsp.dto.Admin;
import com.jsp.service.AdminService;

public class AdminTestUpdate {  
	public static void main(String[] args) {
	AdminService adminService=new AdminService();
	Admin a = adminService.updateAdminEmailById(1, "Vishu", "vishu06");
  } 
}
