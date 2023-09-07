/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author LAB-2
 */
public class UploadFile {
    
    private final String FOLDER = "images//";
    private final String IMG_DEFAULT = "default.jpg";
    
    
    public String upload(MultipartFile multipartFile) throws IOException{
        if(!multipartFile.isEmpty()){
            byte [] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            return multipartFile.getOriginalFilename();
            
        }
        return IMG_DEFAULT;
    }
    public void delete(String nameFile){
        File file = new File(FOLDER + nameFile);
        file.delete();
    }
    
}
