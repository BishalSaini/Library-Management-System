package com.jsp.controller;

import com.jsp.service.AdminService;

public class ApproveLib { 
	public static void main(String[] args) {
			AdminService adminService = new AdminService();
			boolean res = adminService.approveLibrarianById(1, 1);
			System.out.println(res);
		}

	}