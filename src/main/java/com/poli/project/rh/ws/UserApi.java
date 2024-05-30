package com.poli.project.rh.ws;

import com.poli.project.rh.business.UserService;
import com.poli.project.rh.dto.LoginDTO;
import com.poli.project.rh.dto.PeticionDTO;
import com.poli.project.rh.dto.UserDTO;
import com.poli.project.rh.payload.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO login) {
        LoginResponse response = userService.loginUser(login);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getEmployeeInfo(){
        List<UserDTO> response = userService.getUsers();
        return ResponseEntity.ok(response);
    }


    @PostMapping("/create/peticion")
    public String createPeticion(@RequestBody PeticionDTO peticion) {
        return userService.createPeticion(peticion);
    }

    @GetMapping("/peticiones")
    public ResponseEntity<List<PeticionDTO>> getPeticionesInfo(){
        List<PeticionDTO> response = userService.getPeticiones();
        return ResponseEntity.ok(response);
    }
}
