package com.poli.project.rh.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PeticionDTO {

    private String id;
    private String employeeName;
    private String documentNumber;
    private String type;
    private Boolean sate;
    private byte[] file;
}
