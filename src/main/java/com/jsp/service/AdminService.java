package com.jsp.service;

import java.util.List;

import com.jsp.dao.AdminDao;
import com.jsp.dao.LibrarianDao;
import com.jsp.dto.Admin;
import com.jsp.dto.Librarian;

public class AdminService {
    AdminDao adminDao = new AdminDao();
    Admin admin = new Admin();
    LibrarianDao librarianDao = new LibrarianDao();

    public Admin saveAdminDetails(Admin admin) {
        Admin savedAdmin = adminDao.saveAdminDetails(admin);
        if (savedAdmin != null) {
            System.out.println("Admin details have been saved.");
        } else {
            System.out.println("Failed to save admin details");
        }
        return savedAdmin;
    }

    public Admin deleteAdminById(int id) {
        Admin deletedAdmin = adminDao.deleteAdminById(id);
        if (deletedAdmin != null) {
            System.out.println("Admin has been deleted.");
        } else {
            System.out.println("Failed to delete");
        }
        return deletedAdmin;
    }

    public Admin updateAdminEmailById(int id, String username, String password) {
        Admin updatedAdmin = adminDao.updateAdminEmailById(id, username, password);
        if (updatedAdmin != null) {
            System.out.println("Admin email and password have been updated");
        } else {
            System.out.println("Failed to update email and password");
        }
        return updatedAdmin;
    }

    public Admin getAdminDetailsById(int id) {
        Admin admin = adminDao.getAdminDetailsById(id);
        if (admin != null) {
            System.out.println("ID: " + admin.getId());
            System.out.println("Username: " + admin.getUsername());
            System.out.println("Password: " + admin.getPassword());
        } else {
            System.out.println("Admin not found");
        }
        return admin;
    }

    public List<Admin> getAllAdminDetails() {
        List<Admin> adminList = adminDao.getAllAdminDetails();
        if (!adminList.isEmpty()) {
            System.out.println("All admin details:");
            for (Admin a : adminList) {
                System.out.println("================");
                System.out.println("ID: " + a.getId());
                System.out.println("Username: " + a.getUsername());
                System.out.println("Password: " + a.getPassword());
                System.out.println("================");
            }
        } else {
            System.out.println("No admin details found.");
        }
        return adminList;
    }

    public boolean login(int id, String username, String password) {
        Admin a = adminDao.getAdminDetailsById(id);
        if (a != null && a.getUsername().equals(username) && a.getPassword().equals(password)) {
            System.out.println("Login successful");
            return true;
        } else {
            System.out.println("Login failed");
            return false;
        }
    } 
    
    public boolean approveLibrarianById(int libid, int adminid) {
        Librarian librarian = librarianDao.getLibrarianDetailsById(libid);
        Admin admin = adminDao.getAdminDetailsById(adminid);
        if (librarian != null && admin != null) {
            librarian.setStatus("Authorized");
            librarian.setAdmin(admin);
            boolean result = librarianDao.approveLibrarian(librarian);
            if (result) {
                System.out.println("Librarian has been authorized.");
            } else {
                System.out.println("Failed to authorized");
            }
            return result;
        }

        System.out.println("Authorization failed");
        return false;
    }

	
    public boolean rejectLibrarians(int libid, int adminid) {
        Librarian librarian = librarianDao.getLibrarianDetailsById(libid);
        Admin admin = adminDao.getAdminDetailsById(adminid);
        if (librarian != null && admin != null) {
            librarian.setStatus("rejected");
            librarian.setAdmin(admin);
            boolean result = librarianDao.approveLibrarian(librarian);
            if (result) {
                System.out.println("Librarian with ID " + libid + " has been rejected");
            } else {
                System.out.println("Failed to reject librarian with ID " + libid);
            }
            return result;
        }

        System.out.println("Librarian or admin not found");
        return false;
    }	
}
