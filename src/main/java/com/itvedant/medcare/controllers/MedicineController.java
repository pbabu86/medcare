package com.itvedant.medcare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itvedant.medcare.services.MedicineService;



//controller class will receive the request and will send the response
@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PutMapping("/medicines/{id}/upload")
    public ResponseEntity<?>upload(@PathVariable Integer id,
                                    @RequestParam("file") MultipartFile file){   
        return ResponseEntity.ok(medicineService.storeFile(id, file));
    }
    
    @GetMapping("/medicines/download/{filename}")
    public ResponseEntity<?> download(@PathVariable String filename){
        Resource resource = this.medicineService.downloadFile(filename);

        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment; filename=\"" + filename + "\"")
                             .body(resource);
    }

}

