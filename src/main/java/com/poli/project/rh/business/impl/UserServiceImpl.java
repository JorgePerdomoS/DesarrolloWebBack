package com.poli.project.rh.business.impl;

import com.poli.project.rh.business.UserService;
import com.poli.project.rh.document.PeticionDocument;
import com.poli.project.rh.document.UserDocument;
import com.poli.project.rh.dto.LoginDTO;
import com.poli.project.rh.dto.PeticionDTO;
import com.poli.project.rh.dto.UserDTO;
import com.poli.project.rh.payload.response.LoginResponse;
import com.poli.project.rh.persistent.PeticionRepository;
import com.poli.project.rh.persistent.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PeticionRepository peticionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String createUser(UserDTO user) {

        UserDocument document = new UserDocument();
        document.setName(user.getName());
        document.setEmail(user.getEmail());
        document.setPassword(passwordEncoder.encode(user.getPassword()));
        document.setRole(user.getRole());
        userRepository.save(document);

        return document.getId();
    }

    @Override
    public LoginResponse loginUser(LoginDTO login) {
        UserDocument document = userRepository.findByEmail(login.getEmail()).orElse(null);
        if (document != null) {
            String password = login.getPassword();
            String encryptedPassword = document.getPassword();
            boolean authenticated = passwordEncoder.matches(password, encryptedPassword);

            if (authenticated) {
                UserDocument doc = userRepository.findByEmailAndPassword(login.getEmail(), encryptedPassword).orElse(null);
                if (doc != null) {
                    return new LoginResponse("Login success.", true, document.getRole());
                } else {
                    return new LoginResponse("Login fail.", false, document.getRole());
                }
            } else {
                return new LoginResponse("Password not match.", false, null);
            }
        } else {
            return new LoginResponse("Invalid email.", false, null);
        }
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserDocument> documents = userRepository.findAll();
        List<UserDTO> users = new ArrayList<>();
        for (UserDocument document : documents) {
            UserDTO user = new UserDTO();
            user.setId(document.getId());
            user.setName(document.getName());
            user.setEmail(document.getEmail());
            user.setPassword(document.getPassword());
            users.add(user);
        }
        return users;
    }

    @Override
    public String createPeticion(PeticionDTO peticion) {
        PeticionDocument document = new PeticionDocument();
        document.setType(peticion.getType());
        document.setDocumentNumber(peticion.getDocumentNumber());
        document.setEmployeeName(peticion.getEmployeeName());
        document.setFiles(peticion.getFile());
        document.setSate(true);

        peticionRepository.save(document);
        return document.getId();
    }

    @Override
    public List<PeticionDTO> getPeticiones() {
        List<PeticionDocument> documents = peticionRepository.findAll();
        List<PeticionDTO> peticiones = new ArrayList<>();
        for (PeticionDocument document : documents) {
            PeticionDTO peticion = new PeticionDTO();
            peticion.setId(document.getId());
            peticion.setType(document.getType());
            peticion.setEmployeeName(document.getEmployeeName());
            peticion.setSate(document.getSate());
            peticion.setDocumentNumber(document.getDocumentNumber());
            peticiones.add(peticion);
        }
        return peticiones;
    }
}
