/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.infrastructure.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author LAB-2
 */
@Component
public class loginHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
       AtomicReference<String> redirectURL = new AtomicReference<>(request.getContextPath());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        userDetails.getAuthorities().forEach(
                grantedAuthority -> {
                    if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                        redirectURL.set("/admin");
                    } else {
                        redirectURL.set("/home");
                    }

                }
        );
        response.sendRedirect(String.valueOf(redirectURL));
    }
    
    }
    

