package com.poli.project.rh.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("USER")
public class UserDocument {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
}
