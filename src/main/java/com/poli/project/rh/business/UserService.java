package com.poli.project.rh.business;

import com.poli.project.rh.dto.LoginDTO;
import com.poli.project.rh.dto.PeticionDTO;
import com.poli.project.rh.dto.UserDTO;
import com.poli.project.rh.payload.response.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    String createUser(UserDTO user);
    LoginResponse loginUser(LoginDTO login);
    List<UserDTO> getUsers();
    String createPeticion(PeticionDTO peticion);
    List<PeticionDTO> getPeticiones();
}
