/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.infrastructure.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import upeu.edu.pe.project_lp2_gp2.app.service.LoginService;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final LoginService loginService;
    private final Integer USER_NOT_FOUND = 0;

    @Autowired
    private HttpSession httpSession;

    public UserDetailServiceImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Integer idUser = loginService.getUserId(username);
        if (idUser != USER_NOT_FOUND) {
            UserEntity user = loginService.getuser(username);
            httpSession.setAttribute("iduser", user.getId());
            httpSession.setAttribute("name", user.getFirtName());
            return org.springframework.security.core.userdetails.User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getUserType().name()).build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado ");
        }

    }

}
