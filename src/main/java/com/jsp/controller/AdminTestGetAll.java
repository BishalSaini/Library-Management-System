package com.jsp.controller;

import com.jsp.service.AdminService;

public class AdminTestGetAll { 
	public static void main(String[] args) {
			AdminService adminService =new AdminService();
			adminService.getAllAdminDetails();
	}
}
