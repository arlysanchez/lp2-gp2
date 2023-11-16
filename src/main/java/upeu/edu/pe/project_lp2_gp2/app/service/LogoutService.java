/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.app.service;

import jakarta.servlet.http.HttpSession;

/**
 *
 * @author LAB-2
 */
public class LogoutService {
    
    public LogoutService() {
        
    }

    public void logout(HttpSession httpSession) {
        httpSession.removeAttribute("iduser");
    }
}
