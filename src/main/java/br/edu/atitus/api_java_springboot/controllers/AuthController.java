package br.edu.atitus.api_java_springboot.controllers;

import br.edu.atitus.api_java_springboot.dtos.SignupDTO;
import br.edu.atitus.api_java_springboot.entities.UserEntity;
import br.edu.atitus.api_java_springboot.entities.UserType;
import br.edu.atitus.api_java_springboot.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController() {
        super();
        this.service = new UserService();
    }

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> signup(@RequestBody SignupDTO dto) throws Exception{
        // Entidade criada
        UserEntity user = new UserEntity();
        // Propriedades da DTO copiadas para a entidade
        BeanUtils.copyProperties(dto, user);
        //Valores não presentes na DTO setados
        user.setType(UserType.Regular);


        service.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        String message = ex.getMessage().replaceAll("\r\n", "");
        return ResponseEntity.badRequest().body(message);
    }

}
