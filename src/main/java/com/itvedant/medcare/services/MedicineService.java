package com.itvedant.medcare.services;

import org.springframework.stereotype.Service;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itvedant.medcare.FileStorageProperties;
import com.itvedant.medcare.entities.Medicine;
import com.itvedant.medcare.repositories.MedicineRepository;

   
    //service class will contain the business logic which will be accessed from the controller
    @Service
    public class MedicineService {
    
        @Autowired
        private MedicineRepository repository;
    
        //Setting the location where the upload is to be done
        //and from the file will be download
        private final Path rootLocation;
    
        public MedicineService(FileStorageProperties properties){
            this.rootLocation = Paths.get(properties.getUploadDir());
    
            try{
                Files.createDirectories(rootLocation);
            }
            catch(IOException e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                                        "Could create the directory to upload and download");
            }
        }
    
        public String storeFile(Integer id, MultipartFile file){
            //1. File is coming in the request which we need 
            //to add in the uploads.
            Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
    
            try{
                InputStream inputSteream = file.getInputStream();
                Files.copy(inputSteream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            catch(IOException e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                                "Could not save the file");
            }
    
            //2. Create the URL that will be used to download the file
            // and we will be updating for all the products.
           
            //"http://localhost:8080" to get this part of the url ==> ServletUriComponentsBuilder.fromCurrentContextPath()
            String uploadedFileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                                    .path("/medicines/download/")
                                    .path(file.getOriginalFilename())
                                    .toUriString();
            Medicine medicine = this.repository.findById(id).get();
            medicine.setId(id);
            medicine.setImageUrl(uploadedFileUrl);
            this.repository.save(medicine);
            return "File Uploaded Successfully";
        }
    
        public Resource downloadFile(String filename){
            Path file = rootLocation.resolve(filename);
    
            try{
                Resource resource = new UrlResource(file.toUri());
    
                return resource;
            }
            catch(Exception e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                                                  "Could not download the file");
            }
        }
    
}
