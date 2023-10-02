package com.jsp.controller;

import com.jsp.service.AdminService;

public class RejectLibrarian { 
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		boolean res = adminService.rejectLibrarians(2, 1);
		System.out.println(res);
	}

}
