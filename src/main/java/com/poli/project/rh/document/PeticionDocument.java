package com.poli.project.rh.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Data
@Document("PETICION")
public class PeticionDocument {

    @Id
    private String id;
    private String employeeName;
    private String documentNumber;
    private String type;
    private Boolean sate;
    private byte[] files;
}
