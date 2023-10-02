package com.jsp.controller;

import com.jsp.service.AdminService;

public class AdminTestDelete {
	public static void main(String[] args) {
		AdminService adminService =new AdminService();
		adminService.deleteAdminById(2);

	}
}
