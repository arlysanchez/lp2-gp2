/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.UserEntity;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.UserType;

/**
 *
 * @author LAB-2
 */
public class UserDto {
     private String username;
    @NotBlank (message = "Nombre es requerido")
    private String firtName;
    @NotBlank (message = "Apellido es requerido")
    private String lastName;
    @Email(message = "Debe ingresar un email valido")
    private String email;
    @NotBlank (message = "Dirección es requerido")
    private String address;
    @NotBlank (message = "Celular es requerido")
    private String cellphone;
    @NotBlank (message = "Clave es requerido")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public UserEntity userDtoToUser(){
        return new UserEntity(null,this.getEmail(),this.getFirtName(), this.getLastName(),this.getEmail(), this.getAddress(), this.getCellphone(), this.getPassword(), UserType.USER, LocalDateTime.now());
    }
}
