package com.jsp.controller;

import com.jsp.service.AdminService;

public class AdminTestGetById { 
	public static void main(String[] args) {
		AdminService adminService =new AdminService();
		adminService.getAdminDetailsById(2);
}

}
